package com.example.practicingkotlinandandroidstudio.lunchTray.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.practicingkotlinandandroidstudio.databinding.FragmentStartOrderBinding

/**
 * [StartOrderFragment] позволяет пользователям нажать кнопку "Пуск", чтобы начать оформление заказа.
 */
class StartOrderFragment : Fragment() {

    // Экземпляр объекта привязки, соответствующий fragment_start_order.xml планировка
    // Это свойство не равно нулю между обратными вызовами onCreateView() и onDestroyView() жизненного цикла,
    // когда иерархия представлений присоединена к фрагменту.
    private var _binding: FragmentStartOrderBinding? = null

    // Это свойство действительно только между onCreateView и onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartOrderBinding.inflate(inflater, container, false)
        val root: View = binding.root
        // Перейдите к Entire Menu
        binding.startOrderBtn.setOnClickListener {
            // TODO: перейдите к Entire Menu Fragment
        }
        return root
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