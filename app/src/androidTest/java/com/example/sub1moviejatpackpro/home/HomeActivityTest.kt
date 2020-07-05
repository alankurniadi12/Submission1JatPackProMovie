package com.example.sub1moviejatpackpro.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.example.sub1moviejatpackpro.R
import com.example.sub1moviejatpackpro.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dataDummy = DataDummy.generateDummyMovie()

    @get:Rule
    var activityRule = ActivityTestRule(HomeActivity::class.java)


    @Test
    fun loadMovieList() {
        //Tampilkan listmovie dan scrol semua data yang tampil
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dataDummy.size))
    }

    @Test
    fun loadDetailMovie() {
        //Tampilkan listmovie dan klik urutan pertama, tampilkan detail
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        //swipUp detail activity
        onView(withId(R.id.detail_movie)).perform(swipeUp())
        onView(withId(R.id.detail_movie)).check(matches(isDisplayed()))

    }
}