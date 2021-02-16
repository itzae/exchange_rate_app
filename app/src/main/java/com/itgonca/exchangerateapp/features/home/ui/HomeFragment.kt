package com.itgonca.exchangerateapp.features.home.ui

import android.content.Context
import android.graphics.Color.red
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
        viewModel.getHistorical()

        viewModel.historicalData.observe(viewLifecycleOwner, Observer {
            when (it) {
                StateUI.Loading -> {
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

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initChart(dataList: List<Historical>) {
        //Part1
        val entries = ArrayList<Entry>()
        val stringData = arrayListOf<String>()

//Part2
        dataList.mapIndexed { index, historical ->
            entries.add(Entry((index.toFloat() ), historical.rate.toFloat()))
            stringData.add(index, historical.symbol)
        }
        //Part3
        val vl = LineDataSet(entries, "Rate")

//Part4
        vl.setDrawValues(true)
        vl.setDrawFilled(true)
        vl.lineWidth = 3f
        vl.fillColor = R.color.amber_700
        vl.fillAlpha = R.color.cyan_500
        binding.chartHistorical.apply {
            xAxis.labelRotationAngle = 0f
//Part6
            data = LineData(vl)

//Part7
            axisRight.isEnabled = false

//Part8
            setTouchEnabled(true)
            setPinchZoom(true)

//Part9
            description.text = "Currency"
            xAxis.granularity = 1f
            xAxis.valueFormatter = IndexAxisValueFormatter(stringData)

//Part10
            animateX(1800, Easing.EaseInExpo)
            invalidate()
        }
    }
}