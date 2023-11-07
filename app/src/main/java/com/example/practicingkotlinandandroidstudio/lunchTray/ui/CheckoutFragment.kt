package com.example.practicingkotlinandandroidstudio.lunchTray.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.practicingkotlinandandroidstudio.R
import com.example.practicingkotlinandandroidstudio.lunchTray.model.OrderViewModel
import com.example.practicingkotlinandandroidstudio.databinding.FragmentCheckoutBinding
import com.google.android.material.snackbar.Snackbar

/**
 * [[Фрагмент оформления заказа] позволяет пользователям применить купон к своему заказу, отправить заказ или отменить заказ.
 */
class CheckoutFragment : Fragment() {

    // Экземпляр объекта привязки, соответствующий fragment_start_order.xml планировка
    // Это свойство не равно нулю между обратными вызовами onCreateView() и onDestroyView() жизненного цикла,
    // когда иерархия представлений присоединена к фрагменту.
    private var _binding: FragmentCheckoutBinding? = null
    // Это свойство действительно только между onCreateView и onDestroyView.
    private val binding get() = _binding!!
    // Используйте делегат свойства Kotlin 'by activity ViewModels()' из артефакта fragment-ktx
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCheckoutBinding.inflate(inflater, container, false)
        val root = binding.root

        // Calculate tax and total upon creating the CheckoutFragment view
        sharedViewModel.calculateTaxAndTotal()

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            // инициализируйте переменные OrderViewModel и Checkout Fragment
            viewModel = sharedViewModel
            checkoutFragment = this@CheckoutFragment
        }
    }

    /**
     * Отмените заказ и начните все сначала.
     */
    fun cancelOrder() {
        // Сбросить порядок в модели просмотра
        sharedViewModel.resetOrder()
        // Вернитесь к [StartFragment], чтобы начать все сначала
        findNavController().navigate(R.id.action_checkoutFragment_to_startOrderFragment)
    }

/**
 * Отправьте заказ и перейдите на главный экран.
 */
fun submitOrder() {
    // Show snackbar to "confirm" order
    Snackbar.make(binding.root, R.string.submit_order, Snackbar.LENGTH_SHORT).show()
    // Сбросить порядок в модели просмотра
    sharedViewModel.resetOrder()
    // Вернитесь к [StartFragment], чтобы начать все сначала
    findNavController().navigate(R.id.action_checkoutFragment_to_startOrderFragment)
}

    /**
     * Этот метод жизненного цикла фрагмента вызывается, когда удаляется иерархия представлений,
     * связанная с фрагментом. В результате очистите объект привязки.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}