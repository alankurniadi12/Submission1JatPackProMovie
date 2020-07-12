package com.example.sub1moviejatpackpro.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.sub1moviejatpackpro.R
import com.example.sub1moviejatpackpro.movie.ListMovieFragment
import com.example.sub1moviejatpackpro.tvshow.ListTvShowFragment

class SectionPagerAdapter(private val mContext: Context, fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.tab_movie, R.string.tab_tvshow)
    }

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> ListMovieFragment()
        1 -> ListTvShowFragment()
        else -> Fragment()
    }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = TAB_TITLES.size
}