package com.example.words


import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.practicingkotlinandandroidstudio.R
import com.example.practicingkotlinandandroidstudio.Words.LetterListFragment
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class NavigationTests {

    lateinit var navController: TestNavHostController
    lateinit var letterListScenario: FragmentScenario<LetterListFragment>

    // @Before - позволяет не писать много кода, чтобы проверить все кнопки фрагмента
    // @After - можно использовать для очистки ресурса, который мы использовали для нашего теста,
    // или для инструментальных тестов, мы можем использовать его для возврата устройства в определенное состояние

    @Before
    @Test
    fun setup() {
        navController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        )
        letterListScenario = launchFragmentInContainer(
            themeResId = R.style.Theme_TipTime)
        letterListScenario.onFragment { fragment ->
            navController.setGraph(R.navigation.nav_graph)
            Navigation.setViewNavController(fragment.requireView(), navController)
        }
    }


        @Test
        fun navigate_to_words_nav_component() {
            val navController = TestNavHostController(
                ApplicationProvider.getApplicationContext()
            )

            val letterListScenario = launchFragmentInContainer<LetterListFragment>(
                themeResId =
                R.style.Theme_TipTime
            )

            letterListScenario.onFragment { fragment ->

                navController.setGraph(R.navigation.nav_graph)

                Navigation.setViewNavController(fragment.requireView(), navController)
            }

            onView(withId(R.id.recycler_view))
                .perform(
                    RecyclerViewActions
                        .actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click())
                )

            assertEquals(navController.currentDestination?.id, R.id.wordListFragment)
        }
    }