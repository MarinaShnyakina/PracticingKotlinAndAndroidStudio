//package com.example.practicingkotlinandandroidstudio.busSchedule
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.activityViewModels
//import androidx.lifecycle.coroutineScope
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.practicingkotlinandandroidstudio.busSchedule.viewmodels.BusScheduleViewModel
//import com.example.practicingkotlinandandroidstudio.busSchedule.viewmodels.BusScheduleViewModelFactory
//import com.example.practicingkotlinandandroidstudio.databinding.StopScheduleFragmentBinding
//import kotlinx.coroutines.launch
//
//class StopScheduleFragment: Fragment() {
//
//    companion object {
//        var STOP_NAME = "stopName"
//    }
//
//    private var _binding: StopScheduleFragmentBinding? = null
//
//    private val binding get() = _binding!!
//
//    private lateinit var recyclerView: RecyclerView
//
//    private lateinit var stopName: String
//
//    private val viewModel: BusScheduleViewModel by activityViewModels {
//        BusScheduleViewModelFactory(
//            (activity?.application as BusScheduleApplication).database.scheduleDao()
//        )
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        arguments?.let {
//            stopName = it.getString(STOP_NAME).toString()
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = StopScheduleFragmentBinding.inflate(inflater, container, false)
//        val view = binding.root
//        return view
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        recyclerView = binding.recyclerView
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//
//        val busStopAdapter = BusStopAdapter({})
//        recyclerView.adapter = busStopAdapter
//
//        lifecycle.coroutineScope.launch {
//            viewModel.scheduleForStopName(stopName).collect() {
//                busStopAdapter.submitList(it)
//            }
//        }
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}