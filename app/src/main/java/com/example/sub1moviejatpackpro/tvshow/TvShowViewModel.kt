package com.example.sub1moviejatpackpro.tvshow

import androidx.lifecycle.ViewModel
import com.example.sub1moviejatpackpro.model.TvShow
import com.example.sub1moviejatpackpro.utils.DataDummy

class TvShowViewModel: ViewModel() {
    private lateinit var tvShowId: String

    fun selectIdTvShow(id: String) {
        this.tvShowId = id
    }

    fun getDetailTvShow(): TvShow? {
        var data: TvShow? = null
        for (dataTv in DataDummy.generateDummyTvShow()) {
            if (dataTv.id == tvShowId) {
                data = dataTv
            }
        }
        return data
    }

    fun getTvShow(): List<TvShow> = DataDummy.generateDummyTvShow()
}