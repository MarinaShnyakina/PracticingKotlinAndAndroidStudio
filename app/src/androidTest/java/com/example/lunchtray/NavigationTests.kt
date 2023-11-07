package com.example.lunchtray

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.practicingkotlinandandroidstudio.R
import com.example.practicingkotlinandandroidstudio.lunchTray.ui.*
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Tests for all navigation flows
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class NavigationTests : BaseTest() {

    /**
     * Test navigation from [StartOrderFragment] to [EntreeMenuFragment]
     */
    @Test
    fun `navigate_to_entree_menu_from_start_order`() {
        // Init nav controller
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext())
        // Launch StartOrderFragment
        val startOrderScenario =
            launchFragmentInContainer<StartOrderFragment>(themeResId = R.style.Theme_LunchTray)
        // Configure nav controller
        startOrderScenario.onFragment{ fragment ->
            navController.setGraph(R.navigation.mobile_navigation)
            Navigation.setViewNavController(fragment.requireView(), navController)
        }
        // Click start order
        Espresso.onView(withId(R.id.start_order_btn)).perform(ViewActions.click())
        // Check destination is correct
        Assert.assertEquals(navController.currentDestination?.id, R.id.entreeMenuFragment)
    }

    /**
     * Test navigation from [EntreeMenuFragment] to [StartOrderFragment]
     */
    @Test
    fun `navigate_to_start_order_from_entree_menu`() {
        // Init nav controller
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext())
        // Launch EntreeMenuFragment
        val entreeMenuScenario =
            launchFragmentInContainer<EntreeMenuFragment>(themeResId = R.style.Theme_LunchTray)
        // Configure nav controller
        entreeMenuScenario.onFragment{ fragment ->
            navController.setGraph(R.navigation.mobile_navigation)
            // Destination defaults to the home fragment, we have to explicitly set the current
            // destination
            navController.setCurrentDestination(destId = R.id.entreeMenuFragment)
            Navigation.setViewNavController(fragment.requireView(), navController)
        }
        // Click the cancel button
        Espresso.onView(withId(R.id.cancel_button)).perform(ViewActions.click())
        // Check that the destination is correct
        Assert.assertEquals(navController.currentDestination?.id, R.id.startOrderFragment)
    }

    /**
     * Test navigation from [EntreeMenuFragment] to [SideMenuFragment]
     */
    @Test
    fun `navigate_to_side_menu_from_entree_menu`() {
        // Init nav controller
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext())
        // Launch the EntreeMenuFragment
        val entreeMenuScenario =
            launchFragmentInContainer<EntreeMenuFragment>(themeResId = R.style.Theme_LunchTray)
        // Configure nav controller
        entreeMenuScenario.onFragment{ fragment ->
            navController.setGraph(R.navigation.mobile_navigation)
            // Destination defaults to the home fragment, we have to explicitly set the current
            // destination
            navController.setCurrentDestination(destId = R.id.entreeMenuFragment)
            Navigation.setViewNavController(fragment.requireView(), navController)
        }
        // Click the next button
        Espresso.onView(withId(R.id.next_button)).perform(ViewActions.click())
        // Check that the destination is correct
        Assert.assertEquals(navController.currentDestination?.id, R.id.sideMenuFragment)
    }

    /**
     * Test navigation from [SideMenuFragment] to [StartOrderFragment]
     */
    @Test
    fun `navigate_to_start_order_from_side_menu`() {
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext())
        val sideMenuScenario =
            launchFragmentInContainer<SideMenuFragment>(themeResId = R.style.Theme_LunchTray)
        sideMenuScenario.onFragment{ fragment ->
            navController.setGraph(R.navigation.mobile_navigation)
            navController.setCurrentDestination(destId = R.id.sideMenuFragment)
            Navigation.setViewNavController(fragment.requireView(), navController)
        }
        Espresso.onView(withId(R.id.cancel_button)).perform(ViewActions.click())
        Assert.assertEquals(navController.currentDestination?.id, R.id.startOrderFragment)
    }

    /**
     * Test navigation from [SideMenuFragment] to [AccompanimentMenuFragment]
     */
    @Test
    fun `navigate_to_accompaniment_menu_from_side_menu`() {
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext())
        val sideMenuScenario =
            launchFragmentInContainer<SideMenuFragment>(themeResId = R.style.Theme_LunchTray)
        sideMenuScenario.onFragment{ fragment ->
            navController.setGraph(R.navigation.mobile_navigation)
            navController.setCurrentDestination(destId = R.id.sideMenuFragment)
            Navigation.setViewNavController(fragment.requireView(), navController)
        }
        Espresso.onView(withId(R.id.next_button)).perform(ViewActions.click())
        Assert.assertEquals(navController.currentDestination?.id, R.id.accompanimentMenuFragment)
    }

    /**
     * Test navigation from [AccompanimentMenuFragment] to [StartOrderFragment]
     */
    @Test
    fun `navigate_to_start_order_from_accompaniment_menu`() {
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext())
        val accompanimentMenuScenario =
            launchFragmentInContainer<AccompanimentMenuFragment>(
                themeResId = R.style.Theme_LunchTray)
        accompanimentMenuScenario.onFragment{ fragment ->
            navController.setGraph(R.navigation.mobile_navigation)
            navController.setCurrentDestination(destId = R.id.accompanimentMenuFragment)
            Navigation.setViewNavController(fragment.requireView(), navController)
        }
        Espresso.onView(withId(R.id.cancel_button)).perform(ViewActions.click())
        Assert.assertEquals(navController.currentDestination?.id, R.id.startOrderFragment)
    }

    /**
     * Test navigation from [AccompanimentMenuFragment] to [CheckoutFragment]
     */
    @Test
    fun `navigate_to_checkout_from_accompaniment_menu`() {
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext())
        val accompanimentMenuScenario =
            launchFragmentInContainer<AccompanimentMenuFragment>(
                themeResId = R.style.Theme_LunchTray)
        accompanimentMenuScenario.onFragment{ fragment ->
            navController.setGraph(R.navigation.mobile_navigation)
            navController.setCurrentDestination(destId = R.id.accompanimentMenuFragment)
            Navigation.setViewNavController(fragment.requireView(), navController)
        }
        Espresso.onView(withId(R.id.next_button)).perform(ViewActions.click())
        Assert.assertEquals(navController.currentDestination?.id, R.id.checkoutFragment)
    }

    /**
     * Test navigation from [CheckoutFragment] to [StartOrderFragment]
     */
    @Test
    fun `navigate_to_start_order_from_checkout`() {
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext())
        val checkoutScenario =
            launchFragmentInContainer<CheckoutFragment>(themeResId = R.style.Theme_LunchTray)
        checkoutScenario.onFragment{ fragment ->
            navController.setGraph(R.navigation.mobile_navigation)
            navController.setCurrentDestination(destId = R.id.checkoutFragment)
            Navigation.setViewNavController(fragment.requireView(), navController)
        }
        Espresso.onView(withId(R.id.cancel_button)).perform(ViewActions.click())
        Assert.assertEquals(navController.currentDestination?.id, R.id.startOrderFragment)
    }

    /**
     * Test Navigation from [CheckoutFragment] to [StartOrderFragment]
     */
    @Test
    fun `navigate_to_start_order_from_checkout_via_submit`() {
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext())
        val checkoutScenario =
            launchFragmentInContainer<CheckoutFragment>(themeResId = R.style.Theme_LunchTray)
        checkoutScenario.onFragment{ fragment ->
            navController.setGraph(R.navigation.mobile_navigation)
            navController.setCurrentDestination(destId = R.id.checkoutFragment)
            Navigation.setViewNavController(fragment.requireView(), navController)
        }
        Espresso.onView(withId(R.id.submit_button)).perform(ViewActions.click())
        Assert.assertEquals(navController.currentDestination?.id, R.id.startOrderFragment)
    }
}
