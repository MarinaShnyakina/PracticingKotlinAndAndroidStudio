package com.example.dogglers

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.example.practicingkotlinandandroidstudio.Dogglers.MainClassDogglers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.example.practicingkotlinandandroidstudio.R

@RunWith(AndroidJUnit4::class)
@MediumTest
class ButtonTests {
    @get:Rule
    var activityRule: ActivityScenarioRule<MainClassDogglers> =
        ActivityScenarioRule(MainClassDogglers::class.java)

    @Test
    fun `vertical_list_button_is_displayed`() {
        onView(withId(R.id.vertical_button)).check(matches(isDisplayed()))
    }

    @Test
    fun `horizontal_list_button_is_displayed`() {
        onView(withId(R.id.horizontal_button)).check(matches(isDisplayed()))
    }

    @Test
    fun `grid_list_button_is_displayed`() {
        onView(withId(R.id.grid_button)).check(matches(isDisplayed()))
    }

    @Test
    fun `clicking_vertical_list_button_displays_vertical_list`() {
        onView(withId(R.id.vertical_button)).perform(click())
        onView(withId(R.id.vertical_recycler_view)).check(matches(isDisplayed()))
    }

    @Test
    fun `clicking_horizontal_list_button_displays_horizontal_list`() {
        onView(withId(R.id.horizontal_button)).perform(click())
        onView(withId(R.id.horizontal_recycler_view)).check(matches(isDisplayed()))
    }

    @Test
    fun `clicking_grid_list_button_displays_grid_list`() {
        onView(withId(R.id.grid_button)).perform(click())
        onView(withId(R.id.grid_recycler_view)).check(matches(isDisplayed()))
    }
}
