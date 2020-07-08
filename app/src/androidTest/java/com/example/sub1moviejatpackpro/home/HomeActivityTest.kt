package com.example.sub1moviejatpackpro.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.example.sub1moviejatpackpro.R
import com.example.sub1moviejatpackpro.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dataDummy = DataDummy.generateDummyMovie()
    private val dataDummyTv = DataDummy.generateDummyTvShow()

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
        onView(withId(R.id.detail_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_movie)).perform(swipeUp())


        //Apakah data berhasil ditampilkan di detail?
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration_detail_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration_detail_movie)).check(matches(withText(dataDummy[0].duration)))
        onView(withId(R.id.tv_release_detail_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_detail_movie)).check(matches(withText(dataDummy[0].release)))
        onView(withId(R.id.tv_score_detail_movie)).check(matches(withText(dataDummy[0].score)))
        onView(withId(R.id.tv_description_detail_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description_detail_movie)).check(matches(withText(dataDummy[0].description)))

        //swipUp-swipdown detail activity
        onView(withId(R.id.detail_movie)).perform(swipeDown())
    }

    @Test
    fun loadTvShowList() {
        //Tampilkan listTvShow dan scroll semua data
        onView(withText("TvShow")).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dataDummyTv.size))
    }

    @Test
    fun loadDetailTvShow() {
        val btnPlayPosition =
        //Tampilkan listTvShow dan scroll semua list
        onView(withText("TvShow")).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))

        //Klikk button didalam item RecyclerView
        //onView(withId(R.id.rv_tvshow)).check(matches(withId(R.id.btn_play_tv))).perform(click())
        //onView(withText("Arrow")).check(matches(withId(R.id.btn_play_tv))).perform(click())
        //onView(withId(R.id.btn_play_tv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        //onView(withId(R.id.btn_play_tv)).check(matches(RecyclerViewActions.actionOnHolderItem(dataDummyTv[0].))).perform(click())
        //onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(withId(R.id.btn_play_tv), click()))

        //swipup detail
        onView(withId(R.id.detail_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_tvshow)).perform(swipeUp())

        //Apakah data berhasil ditampilkan di detail?
        onView(withId(R.id.img_poster_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration_detail_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration_detail_tv)).check(matches(withText(dataDummyTv[0].duration)))
        onView(withId(R.id.tv_score_detail_tv)).check(matches(withText(dataDummyTv[0].score)))
        onView(withId(R.id.tv_description_detail_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description_detail_tv)).check(matches(withText(dataDummyTv[0].description)))

        //swipdown detail
        onView(withId(R.id.detail_tvshow)).perform(swipeDown())

    }
}