package com.example.practicingkotlinandandroidstudio.invertory

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.practicingkotlinandandroidstudio.databinding.FragmentAddItemBinding
import com.example.practicingkotlinandandroidstudio.inventory.InventoryViewModel
import com.example.practicingkotlinandandroidstudio.inventory.InventoryViewModelFactory
import com.example.practicingkotlinandandroidstudio.inventory.data.Item

class AddItemFragment : Fragment() {

    private val navigationArgs: ItemDetailFragmentArgs by navArgs()

    // can be reused
    private val viewModel: InventoryViewModel by activityViewModels {
        InventoryViewModelFactory(
            (activity?.application as InventoryApplication).database
            .itemDao()
        )
    }

    lateinit var item: Item

    private var _binbing: FragmentAddItemBinding? = null
    private val binding get() = _binbing!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binbing = FragmentAddItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Returns true if the EditTexts are not empty
    private fun isEntryValid(): Boolean {
        return viewModel.isEntryValid(
            binding.itemName.text.toString(),
            binding.itemPrice.text.toString(),
            binding.itemCount.text.toString(),
        )
    }

    // Вставляет новый элемент в базу данных и переходит к фрагменту списка
    private fun addNewItem() {
        if (isEntryValid()) {
            viewModel.addNewItem(
                binding.itemName.text.toString(),
                binding.itemPrice.text.toString(),
                binding.itemCount.text.toString(),
            )
            val action = AddItemFragmentDirections.actionAddItemFragmentToItemListFragment()
            findNavController().navigate(action)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.saveAction.setOnClickListener {
            addNewItem()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Hide keyboard.
        val inputMethodManager = requireActivity().getSystemService(INPUT_METHOD_SERVICE) as
                InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
        _binbing = null
    }
}