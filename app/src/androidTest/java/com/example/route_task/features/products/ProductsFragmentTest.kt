package com.example.route_task.features.products

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.route_task.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
@LargeTest
class ProductsFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var activityRule = ActivityTestRule(ProductsActivity::class.java)

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun testProductsFragmentLoading() {
        // Launch the fragment in the container
        val scenario = launchFragmentInContainer<ProductsFragment>()

        // Verify that the shimmer view is displayed while loading
        onView(withId(R.id.products_shimmer_view_container)).check(matches(isDisplayed()))

        // Add more checks here for different states (loading, success, error)
    }

    @Test
    fun testProductsFragmentSuccess() {
        // Launch the fragment in the container
        val scenario = launchFragmentInContainer<ProductsFragment>()

        // Simulate loading completion and display of RecyclerView
        onView(withId(R.id.success_view)).check(matches(isDisplayed()))

        // Verify that the RecyclerView is displayed
        onView(withId(R.id.category_products_rv)).check(matches(isDisplayed()))

        // Add more checks here to verify the data displayed in the RecyclerView
    }

    @Test
    fun testProductsFragmentError() {
        // Launch the fragment in the container
        val scenario = launchFragmentInContainer<ProductsFragment>()

        // Simulate an error and display of the error view
        onView(withId(R.id.error_view)).check(matches(isDisplayed()))

        // Verify that the error message and try again button are displayed
        onView(withId(R.id.error_message)).check(matches(isDisplayed()))
        onView(withId(R.id.try_again_btn)).check(matches(isDisplayed()))
    }
}
