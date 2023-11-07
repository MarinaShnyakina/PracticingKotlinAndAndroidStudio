package com.example.lunchtray

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.example.practicingkotlinandandroidstudio.R
import com.example.practicingkotlinandandroidstudio.lunchTray.ui.AccompanimentMenuFragment
import com.example.practicingkotlinandandroidstudio.lunchTray.ui.EntreeMenuFragment
import com.example.practicingkotlinandandroidstudio.lunchTray.ui.SideMenuFragment
import org.hamcrest.CoreMatchers
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class MenuContentTests : BaseTest() {

    /**
     * Test the menu content of the entire [EntreeMenuFragment]
     *
     * It isn't necessarily best practice to make all these assertions in a single test,
     * however, it is done here for improved readability of the file.
     */
    @Test
    fun `entree_menu_item_content`() {
        // launch the entree menu fragment
        launchFragmentInContainer<EntreeMenuFragment>(themeResId = R.style.Theme_LunchTray)

        // Check the cauliflower item
        Espresso.onView(withId(R.id.cauliflower))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("Cauliflower"))))
        Espresso.onView(withId(R.id.cauliflower_description))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("Whole cauliflower"))))
        Espresso.onView(withId(R.id.cauliflower_price))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("$7.00"))))

        // Check the chili item
        Espresso.onView(withId(R.id.chili))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("Three Bean Chili"))))
        Espresso.onView(withId(R.id.chili_description))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("Black beans"))))
        Espresso.onView(withId(R.id.chili_price))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("$4.00"))))

        // Check the pasta item
        Espresso.onView(withId(R.id.pasta))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("Mushroom Pasta"))))
        Espresso.onView(withId(R.id.pasta_description))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("Penne pasta"))))
        Espresso.onView(withId(R.id.pasta_price))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("$5.50"))))

        // Check the skillet item
        Espresso.onView(withId(R.id.skillet))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("Spicy Black Bean"))))
        Espresso.onView(withId(R.id.skillet_description))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("Seasonal vegetables"))))
        Espresso.onView(withId(R.id.skillet_price))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("$5.50"))))
    }

    /**
     * Test the menu content of the entire [SideMenuFragment]
     *
     * It isn't necessarily best practice to make all these assertions in a single test,
     * however, it is done here for improved readability of the file by reducing the number of
     * functions that would otherwise be necessary to test each item separately.
     */
    @Test
    fun `side_menu_item_content`() {
        // launch the side menu fragment
        launchFragmentInContainer<SideMenuFragment>(themeResId = R.style.Theme_LunchTray)

        // Check the salad item
        Espresso.onView(withId(R.id.salad))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("Summer Salad"))))
        Espresso.onView(withId(R.id.salad_description))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("Heirloom tomatoes"))))
        Espresso.onView(withId(R.id.salad_price))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("$2.50"))))

        // Check the soup item
        Espresso.onView(withId(R.id.soup))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("Butternut Squash"))))
        Espresso.onView(withId(R.id.soup_description))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("Roasted butternut squash"))))
        Espresso.onView(withId(R.id.soup_price))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("$3.00"))))

        // Check the potato item
        Espresso.onView(withId(R.id.potatoes))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("Spicy Potatoes"))))
        Espresso.onView(withId(R.id.potato_description))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("Marble potatoes"))))
        Espresso.onView(withId(R.id.potato_price))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("$2.00"))))

        // Check the rice item
        Espresso.onView(withId(R.id.rice))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("Coconut Rice"))))
        Espresso.onView(withId(R.id.rice_description))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("Rice, coconut milk"))))
        Espresso.onView(withId(R.id.rice_price))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("$1.50"))))
    }

    /**
     * Test the menu content of the entire [AccompanimentMenuFragment]
     *
     * It isn't necessarily best practice to make all these assertions in a single test,
     * however, it is done here for improved readability of the file by reducing the number of
     * functions that would otherwise be necessary to test each item separately.
     */
    @Test
    fun `accompaniment_menu_item_content`() {
        // launch the accompaniment menu fragment
        launchFragmentInContainer<AccompanimentMenuFragment>(themeResId = R.style.Theme_LunchTray)

        // Check the bread item
        Espresso.onView(withId(R.id.bread))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("Lunch Roll"))))
        Espresso.onView(withId(R.id.bread_description))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("Fresh baked"))))
        Espresso.onView(withId(R.id.bread_price))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("$0.50"))))

        // Check the berries item
        Espresso.onView(withId(R.id.berries))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("Mixed Berries"))))
        Espresso.onView(withId(R.id.berries_description))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("Strawberries"))))
        Espresso.onView(withId(R.id.berries_price))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("$1.00"))))

        // Check the pickle item
        Espresso.onView(withId(R.id.pickles))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("Pickled Veggies"))))
        Espresso.onView(withId(R.id.pickles_description))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("Pickled cucumbers"))))
        Espresso.onView(withId(R.id.pickles_price))
            .check(ViewAssertions.matches(ViewMatchers.withText(CoreMatchers.containsString("$0.50"))))
    }
}
