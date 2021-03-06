package com.itgonca.exchangerateapp.features.home.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.itgonca.domain.model.Historical
import com.itgonca.exchangerateapp.base.MainActivity
import com.itgonca.exchangerateapp.R
import com.itgonca.exchangerateapp.common.StateUI
import com.itgonca.exchangerateapp.databinding.FragmentHomeBinding
import com.itgonca.exchangerateapp.features.home.ui.adapters.CurrencyAdapter
import com.itgonca.exchangerateapp.features.home.viewmodel.HomeViewModel
import com.itgonca.exchangerateapp.utils.extensions.getDateByDays
import com.itgonca.exchangerateapp.utils.extensions.getDate
import com.itgonca.exchangerateapp.utils.extensions.showToast
import javax.inject.Inject

/**
 * @author Itzae González Castillo
 * This class belongs to the Home screen, where all the application data will be displayed
 */
class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private lateinit var mCurrencyAdapter: CurrencyAdapter

    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).mainComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mCurrencyAdapter = CurrencyAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getHistorical(getDate())
        initObservers()
        initUI()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    /**
     * This method initialize the [HomeViewModel] observers
     */
    private fun initObservers() {
        viewModel.historicalData.observe(viewLifecycleOwner, Observer {
            when (it) {
                StateUI.Loading -> (activity as MainActivity).showLoader()
                is StateUI.Success -> {
                    (activity as MainActivity).hideLoader()
                    initChart(it.data)
                    loadDataInRecycler(it.data)
                }
                is StateUI.Error -> {
                    (activity as MainActivity).hideLoader()
                    showToast(getString(R.string.error_data_label))
                }
            }
        })
    }

    /**
     * This method initialize the views of the [HomeFragment]
     */
    private fun initUI() {
        binding.nestedScroll.parent.requestChildFocus(binding.nestedScroll,binding.nestedScroll)
        binding.chipDateGroup.setOnCheckedChangeListener { _, checkedId ->
            val dateParam = when (checkedId) {
                R.id.chipToday -> getDate()
                R.id.chipYesterday -> getDateByDays(1)
                R.id.chipSevenDays -> getDateByDays(7)
                R.id.chipThirtyDays -> getDateByDays(30)
                else -> getDate()
            }

            viewModel.getHistorical(dateParam)
        }
        binding.rvOtherCurrencies.apply {
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
            adapter = mCurrencyAdapter
        }
    }

    /**
     * This method performs the configuration of the linear graph, for example the data to display
     * and format.
     * @param dataList is the data source to represent in the graph
     */
    private fun initChart(dataList: List<Historical>) {
        val entries = ArrayList<Entry>()
        val listSymbols = listOf("CNY", "CAD", "MXN", "GBP", "USD")
        val stringData = arrayListOf<String>()
        val dataFiltered = dataList.filter { it.symbol in listSymbols }

        dataFiltered.mapIndexed { index, historical ->
            entries.add(Entry((index.toFloat()), historical.rate.toFloat()))
            stringData.add(index, historical.symbol)
        }

        val mDataSet = LineDataSet(entries, "Rate")

        mDataSet.apply {
            setDrawValues(true)
            setDrawFilled(true)
            lineWidth = 3f
            fillColor = R.color.amber_700
            fillAlpha = R.color.cyan_500
        }

        binding.chartHistorical.apply {
            xAxis.labelRotationAngle = 0f
            data = LineData(mDataSet)
            axisRight.isEnabled = false
            setTouchEnabled(true)
            setPinchZoom(true)
            description.text = "Currency"
            xAxis.granularity = 1f
            xAxis.valueFormatter = IndexAxisValueFormatter(stringData)
            animateX(1800, Easing.EaseInExpo)
            invalidate()
        }
    }

    /**
     * this method loads the data obtained from the viewmodel into the recycler
     * @param dataList is the data source to display
     */
    private fun loadDataInRecycler(dataList: List<Historical>) {
        mCurrencyAdapter.submitList(dataList)
        binding.rvOtherCurrencies.adapter = mCurrencyAdapter

    }
}