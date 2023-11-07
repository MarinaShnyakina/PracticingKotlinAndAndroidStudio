package com.example.lunchtray

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.practicingkotlinandandroidstudio.R
import com.example.practicingkotlinandandroidstudio.lunchTray.MainClassLunchTray
import com.example.practicingkotlinandandroidstudio.lunchTray.ui.AccompanimentMenuFragment
import com.example.practicingkotlinandandroidstudio.lunchTray.ui.EntreeMenuFragment
import com.example.practicingkotlinandandroidstudio.lunchTray.ui.SideMenuFragment
import org.hamcrest.core.StringContains
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class OrderFunctionalityTests : BaseTest() {

    /**
     * Test subtotal in [EntreeMenuFragment]
     *
     * It isn't necessarily best practice to make all these assertions in a single test,
     * however, it is done here for improved readability of the file.
     */
    @Test
    fun `radio_buttons_update_entree_menu_subtotal`() {
        // Launch the entree menu fragment
        launchFragmentInContainer<EntreeMenuFragment>(themeResId = R.style.Theme_LunchTray)

        // Select the cauliflower item
        Espresso.onView(withId(R.id.cauliflower)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.subtotal))
            .check(ViewAssertions.matches(ViewMatchers.withText(StringContains.containsString("Subtotal: $7.00"))))

        // Select the chili item
        Espresso.onView(withId(R.id.chili)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.subtotal))
            .check(ViewAssertions.matches(ViewMatchers.withText(StringContains.containsString("Subtotal: $4.00"))))

        // Select the pasta item
        Espresso.onView(withId(R.id.pasta)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.subtotal))
            .check(ViewAssertions.matches(ViewMatchers.withText(StringContains.containsString("Subtotal: $5.50"))))

        // Select the skillet item
        Espresso.onView(withId(R.id.skillet)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.subtotal))
            .check(ViewAssertions.matches(ViewMatchers.withText(StringContains.containsString("Subtotal: $5.50"))))
    }

    /**
     * Test subtotal in [SideMenuFragment]
     *
     * It isn't necessarily best practice to make all these assertions in a single test,
     * however, it is done here for improved readability of the file.
     */
    @Test
    fun `radio_buttons_update_side_menu_subtotal`() {
        // Launch the side menu fragment
        launchFragmentInContainer<SideMenuFragment>(themeResId = R.style.Theme_LunchTray)

        // Select the salad item
        Espresso.onView(withId(R.id.salad)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.subtotal))
            .check(ViewAssertions.matches(ViewMatchers.withText(StringContains.containsString("Subtotal: $2.50"))))

        // Select the soup item
        Espresso.onView(withId(R.id.soup)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.subtotal))
            .check(ViewAssertions.matches(ViewMatchers.withText(StringContains.containsString("Subtotal: $3.00"))))

        // Select the potato item
        Espresso.onView(withId(R.id.potatoes)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.subtotal))
            .check(ViewAssertions.matches(ViewMatchers.withText(StringContains.containsString("Subtotal: $2.00"))))

        // Select the rice item
        Espresso.onView(withId(R.id.rice)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.subtotal))
            .check(ViewAssertions.matches(ViewMatchers.withText(StringContains.containsString("Subtotal: $1.50"))))
    }

    /**
     * Test subtotal in [AccompanimentMenuFragment]
     *
     * It isn't necessarily best practice to make all these assertions in a single test,
     * however, it is done here for improved readability of the file.
     */
    @Test
    fun `radio_buttons_update_accompaniment_menu_subtotal`() {
        // Launch the side menu fragment
        launchFragmentInContainer<AccompanimentMenuFragment>(themeResId = R.style.Theme_LunchTray)

        // Select the salad item
        Espresso.onView(withId(R.id.bread)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.subtotal))
            .check(ViewAssertions.matches(ViewMatchers.withText(StringContains.containsString("Subtotal: $0.50"))))

        // Select the soup item
        Espresso.onView(withId(R.id.berries)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.subtotal))
            .check(ViewAssertions.matches(ViewMatchers.withText(StringContains.containsString("Subtotal: $1.00"))))

        // Select the potato item
        Espresso.onView(withId(R.id.pickles)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.subtotal))
            .check(ViewAssertions.matches(ViewMatchers.withText(StringContains.containsString("Subtotal: $0.50"))))
    }

    /**
     * Test subtotals in full order flow
     */
    @Test
    fun `subtotal_updates_in_full_order_flow`() {
        // Launch the main activity
        launchActivity<MainClassLunchTray>()
        // Start order
        Espresso.onView(withId(R.id.start_order_btn)).perform(ViewActions.click())
        // Select entree item
        Espresso.onView(withId(R.id.cauliflower)).perform(ViewActions.click())
        // We already have a test for a single menu item selection, so we don't need to check the
        // subtotal here.
        // Move to next fragment
        Espresso.onView(withId(R.id.next_button)).perform(ViewActions.click())
        // Select side item
        Espresso.onView(withId(R.id.salad)).perform(ViewActions.click())
        // Check that subtotal has updated
        Espresso.onView(withId(R.id.subtotal))
            .check(ViewAssertions.matches(ViewMatchers.withText(StringContains.containsString("Subtotal: $9.50"))))
        // Move to next fragment
        Espresso.onView(withId(R.id.next_button)).perform(ViewActions.click())
        // Select accompaniment item
        Espresso.onView(withId(R.id.bread)).perform(ViewActions.click())
        // Check that subtotal has updated
        Espresso.onView(withId(R.id.subtotal))
            .check(ViewAssertions.matches(ViewMatchers.withText(StringContains.containsString("Subtotal: $10.00"))))
        // Move to next fragment
        Espresso.onView(withId(R.id.next_button)).perform(ViewActions.click())
        // Check that subtotal in checkout is correct
        Espresso.onView(withId(R.id.subtotal))
            .check(ViewAssertions.matches(ViewMatchers.withText(StringContains.containsString("Subtotal: $10.00"))))
    }

    /**
     * Test subtotal, tax, and total in [CheckoutFragment]
     */
    @Test
    fun `subtotal_tax_total_in_checkout`() {
        // Select items and move to checkout
        fullOrderFlow()
        // Check subtotal. Note that this is already done in a separate test, but the other values
        // depend on it so this assertion is a sanity check
        Espresso.onView(withId(R.id.subtotal))
            .check(ViewAssertions.matches(ViewMatchers.withText(StringContains.containsString("Subtotal: $10.00"))))
        // Check tax
        Espresso.onView(withId(R.id.tax))
            .check(ViewAssertions.matches(ViewMatchers.withText(StringContains.containsString("Tax: $0.80"))))
        // Check total
        Espresso.onView(withId(R.id.total))
            .check(ViewAssertions.matches(ViewMatchers.withText(StringContains.containsString("Total: $10.80"))))
    }

    /**
     * Test that the order is reset after canceling in [EntreeMenuFragment]
     */
    @Test
    fun `order_reset_after_cancel_from_entree_menu`() {
        // Launch the app
        launchActivity<MainClassLunchTray>()
        // Start the order
        Espresso.onView(withId(R.id.start_order_btn)).perform(ViewActions.click())
        // Select an item
        Espresso.onView(withId(R.id.cauliflower)).perform(ViewActions.click())
        // Cancel order
        Espresso.onView(withId(R.id.cancel_button)).perform(ViewActions.click())
        // Start the order
        Espresso.onView(withId(R.id.start_order_btn)).perform(ViewActions.click())
        // Make sure subtotal is zero
        Espresso.onView(ViewMatchers.withText("Subtotal: $0.00"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    /**
     * Test that the order is reset after canceling in [SideMenuFragment]
     */
    @Test
    fun `order_reset_after_cancel_from_side_menu`() {
        // Launch the app
        launchActivity<MainClassLunchTray>()
        // Start the order
        Espresso.onView(withId(R.id.start_order_btn)).perform(ViewActions.click())
        // Select an item
        Espresso.onView(withId(R.id.cauliflower)).perform(ViewActions.click())
        // Move to side menu
        Espresso.onView(withId(R.id.next_button)).perform(ViewActions.click())
        // Select an item
        Espresso.onView(withId(R.id.soup)).perform(ViewActions.click())
        // Cancel the order
        Espresso.onView(withId(R.id.cancel_button)).perform(ViewActions.click())
        // Start the order
        Espresso.onView(withId(R.id.start_order_btn)).perform(ViewActions.click())
        // Make sure subtotal is zero
        Espresso.onView(ViewMatchers.withText("Subtotal: $0.00"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    /**
     * Test that the order is reset after canceling in [AccompanimentMenuFragment]
     */
    @Test
    fun `order_reset_after_cancel_from_accompaniment_menu`() {
        // Launch the app
        launchActivity<MainClassLunchTray>()
        // Start the order
        Espresso.onView(withId(R.id.start_order_btn)).perform(ViewActions.click())
        // Select an item
        Espresso.onView(withId(R.id.cauliflower)).perform(ViewActions.click())
        // Move to side menu
        Espresso.onView(withId(R.id.next_button)).perform(ViewActions.click())
        // Select an item
        Espresso.onView(withId(R.id.soup)).perform(ViewActions.click())
        // Move to accompaniment menu
        Espresso.onView(withId(R.id.next_button)).perform(ViewActions.click())
        // Select item
        Espresso.onView(withId(R.id.bread)).perform(ViewActions.click())
        // Cancel the order
        Espresso.onView(withId(R.id.cancel_button)).perform(ViewActions.click())
        // Start the order
        Espresso.onView(withId(R.id.start_order_btn)).perform(ViewActions.click())
        // Make sure subtotal is zero
        Espresso.onView(ViewMatchers.withText("Subtotal: $0.00"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    /**
     * Test that the order is reset after canceling in [CheckoutFragment]
     */
    @Test
    fun `order_reset_after_cancel_from_checkout`() {
        // Select items and move to checkout
        fullOrderFlow()
        // Cancel the order
        Espresso.onView(withId(R.id.cancel_button)).perform(ViewActions.click())
        // Start the order
        Espresso.onView(withId(R.id.start_order_btn)).perform(ViewActions.click())
        // Make sure subtotal is zero
        Espresso.onView(ViewMatchers.withText("Subtotal: $0.00"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    /**
     * Test that the correct snackbar is displayed when order is submitted
     */
    @Test
    fun `order_snackbar`() {
        // Select items and move to checkout
        fullOrderFlow()
        // Click submit
        Espresso.onView(withId(R.id.submit_button)).perform(ViewActions.click())
        // Check for snackbar text
        Espresso.onView(ViewMatchers.withText(StringContains.containsString("Order Submitted!")))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
