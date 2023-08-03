package com.example.practicingkotlinandandroidstudio.lunchTray.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.practicingkotlinandandroidstudio.lunchTray.model.OrderViewModel
import com.example.practicingkotlinandandroidstudio.databinding.FragmentAccompanimentMenuBinding

/**
 * [Меню аккомпанемента] позволяет пользователям добавлять аккомпанемент к своему заказу или отменять заказ.
 */
class AccompanimentMenuFragment : Fragment() {

    // Экземпляр объекта привязки, соответствующий fragment_start_order.xml планировка
    // Это свойство не равно нулю между обратными вызовами onCreateView() и onDestroyView()
    // жизненного цикла, когда иерархия представлений присоединена к фрагменту.
    private var _binding: FragmentAccompanimentMenuBinding? = null
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
        _binding = FragmentAccompanimentMenuBinding.inflate(inflater, container, false)
        val root = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            // TODO: инициализируйте переменные фрагмента меню сопровождения
        }
    }

    /**
     * Перейдите к фрагменту оформления заказа.
     */
    fun goToNextScreen() {
        // TODO: Перейдите к фрагменту оформления заказа
    }

    /**
     * Отмените заказ и начните все сначала.
     */
    fun cancelOrder() {
        // TODO: Сбросить порядок в модели просмотра
        // TODO: Вернитесь к [StartFragment], чтобы начать все сначала
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