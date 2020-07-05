package com.example.sub1moviejatpackpro.tvshow

import com.example.sub1moviejatpackpro.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest {
    private lateinit var viewmodel: TvShowViewModel
    private val dataDummy = DataDummy.generateDummyTvShow()[0]

    @Before
    fun setUp() {
        viewmodel = TvShowViewModel()
    }

    @Test
    fun getDetailTvShow() {
        val dummyId = dataDummy.id
        viewmodel.selectIdTvShow(dummyId)
        val dataDetailTv = viewmodel.getDetailTvShow()
        assertNotNull(dataDetailTv)                         //apalah dataDetail null?
        //apakah data yang tampil sesuai dengan Id dari intent list item?
        assertEquals(dummyId, dataDetailTv?.id)
        assertEquals(dataDummy.poster, dataDetailTv?.poster)
        assertEquals(dataDummy.title, dataDetailTv?.title)
        assertEquals(dataDummy.duration, dataDetailTv?.duration)
        assertEquals(dataDummy.description, dataDetailTv?.description)
        assertEquals(dataDummy.score, dataDetailTv?.score)
    }

    @Test
    fun getTvShow() {
        val dataTvShow = viewmodel.getTvShow()
        assertNotNull(dataTvShow)                           //apakah data null?
    }
}