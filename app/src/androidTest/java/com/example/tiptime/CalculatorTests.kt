package com.example.tiptime

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.assertion.ViewAssertions.matches
import org.hamcrest.Matchers.containsString
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.practicingkotlinandandroidstudio.TipTime.TipTime
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.example.practicingkotlinandandroidstudio.R

@RunWith(AndroidJUnit4::class)
class CalculatorTests {
    @get:Rule()
    val activity = ActivityScenarioRule(TipTime::class.java)

    @Test
    fun calculate_20_percent_tip() {
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.00"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.button_calculate))
            .perform(click())

        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$10.00"))))

    }

    @Test
    fun calculate_15_percent_tip() {
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("80.00"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.option_fifteen_percent))
            .perform(click())

        onView(withId(R.id.button_calculate))
            .perform(click())

        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$12.00"))))
    }

    @Test
    fun calculate_18_percent_and_not_round_tip() {
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("45.00"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.option_eighteen_percent))
            .perform(click())

        onView(withId(R.id.round_up_switch))
            .perform(click())

        onView(withId(R.id.button_calculate))
            .perform(click())

        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$8.10"))))
    }
}