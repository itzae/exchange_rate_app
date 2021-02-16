package com.itgonca.exchangerateapp.features.home.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.itgonca.domain.model.Historical
import com.itgonca.exchangerateapp.MainActivity
import com.itgonca.exchangerateapp.R
import com.itgonca.exchangerateapp.common.StateUI
import com.itgonca.exchangerateapp.databinding.FragmentHomeBinding
import com.itgonca.exchangerateapp.features.home.viewmodel.HomeViewModel
import javax.inject.Inject

/**
 * @author Itzae González Castillo
 * This class belongs to the Home screen, where all the application data will be displayed
 */
class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).mainComponent.inject(this)
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
        viewModel.getHistorical("2021-01-15")
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
                StateUI.Loading -> {
                    //not implemented
                }
                is StateUI.Success -> {
                    initChart(it.data)
                    Log.i("TAG", "Data UI: ${it.data}")
                }
                is StateUI.Error -> {
                    Log.e("TAG", "Data Error: ${it.message}")
                }
            }
        })
    }

    private fun initUI() {
        binding.chipDateGroup.setOnCheckedChangeListener { _, checkedId ->
            val dateParam = when (checkedId) {
                R.id.chipToday -> "2021-01-10"
                R.id.chipYesterday -> "2021-01-20"
                R.id.chipSevenDays -> "2020-12-15"
                R.id.chipThirtyDays -> "2020-09-12"
                else -> ""
            }

            viewModel.getHistorical(dateParam)
        }
    }

    /**
     * This method performs the configuration of the linear graph, for example the data to display
     * and format.
     * @param dataList is the data source to represent in the graph
     */
    private fun initChart(dataList: List<Historical>) {
        val entries = ArrayList<Entry>()
        val stringData = arrayListOf<String>()

        dataList.mapIndexed { index, historical ->
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
}