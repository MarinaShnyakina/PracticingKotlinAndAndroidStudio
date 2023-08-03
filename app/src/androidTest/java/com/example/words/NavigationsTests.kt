package com.example.words

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.practicingkotlinandandroidstudio.Words.LetterListFragment
import com.example.practicingkotlinandandroidstudio.R
import junit.framework.TestCase.assertEquals
import org.junit.Test

class NavigationsTests {

    @Test
    fun navigate_to_words_nav_component() {
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        )

        val letterListScenario = launchFragmentInContainer<LetterListFragment>(
            themeResId = R.style.Widget_Words_TextView
        )

        letterListScenario.onFragment { fragment ->
            navController.setGraph(R.navigation.nav_graph)
            Navigation.setViewNavController(fragment.requireView(), navController)

            onView(withId(R.id.recycler_view))
                .perform(RecyclerViewActions
                    .actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))
            assertEquals(navController.currentDestination?.id, R.id.wordListFragment)
        }
    }
}