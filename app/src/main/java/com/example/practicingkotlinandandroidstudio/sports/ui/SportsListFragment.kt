package com.example.practicingkotlinandandroidstudio.sports.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.example.practicingkotlinandandroidstudio.databinding.FragmentSportsListBinding
import com.example.practicingkotlinandandroidstudio.sports.SportsViewModel
import com.example.practicingkotlinandandroidstudio.sports.adapter.SportsAdapter

/**
 * Простой подкласс [Fragment] в качестве пункта назначения по умолчанию в навигации.
 */

class SportsListFragment : Fragment() {

    private val sportsViewModel: SportsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentSportsListBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSportsListBinding.bind(view)
        val slidingPaneLayout = binding.slidingPaneLayout

        // блокирует SlidingPaneLayout, чтобы пользователи не могли входить и выходить с помощью жестов
        slidingPaneLayout.lockMode = SlidingPaneLayout.LOCK_MODE_LOCKED
        // Подключает SlidingPaneLayout к кнопке возврата в систему
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            SportsListOnBackPressedCallback(slidingPaneLayout)
        )

        // Инициализация адаптера и установка для него значение RecyclerView
        val adapter = SportsAdapter {
            // Обновляет выбранный пользователем вид спорта в качестве текущего вида спорта в общей viewModel
            // Это автоматически обновит содержимое двойной панели
            sportsViewModel.updateCurrentSport(it)
            // Перейти к экрану сведений
            // openPane() в SlidingPaneLayout, поменяет местами вторую панель поверх первой панели
            binding.slidingPaneLayout.openPane()
        }
        binding.recyclerView.adapter = adapter
        adapter.submitList(sportsViewModel.sportsData)
    }

    // Обратный вызов, обеспечивающий пользовательскую обратную навигацию
    class SportsListOnBackPressedCallback(
        private val slidingPaneLayout: SlidingPaneLayout
    ) : OnBackPressedCallback(
        // Установите для состояния isSlideable по умолчанию значение true только в том случае,
        // если оно является скользящим (т.е. панели перекрываются) и isOpen (т.е. видна панель сведений).
        slidingPaneLayout.isSlideable && slidingPaneLayout.isOpen
    ), SlidingPaneLayout.PanelSlideListener {

        init {
            slidingPaneLayout.addPanelSlideListener(this)
        }

        override fun handleOnBackPressed() {
            // Вернитесь к панели списка при нажатии кнопки возврата в систему
            slidingPaneLayout.closePane()
        }

        override fun onPanelSlide(panel: View, slideOffset: Float) {}

        override fun onPanelOpened(panel: View) {
            // Перехватывает кнопку возврата к системе, когда станет видна панель сведений
            isEnabled = true
        }

        override fun onPanelClosed(panel: View) {
            // Отключает перехват системной кнопки возврата, когда пользователь возвращается в панель списка
            isEnabled = false
        }

    }
}