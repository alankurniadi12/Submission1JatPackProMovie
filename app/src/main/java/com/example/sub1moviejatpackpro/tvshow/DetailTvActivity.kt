package com.example.sub1moviejatpackpro.tvshow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.sub1moviejatpackpro.R
import kotlinx.android.synthetic.main.activity_detail_tv.*

class DetailTvActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TV = "extra_tv"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv)
        supportActionBar?.title = "Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]
        val extras = intent.extras
        if (extras != null) {
            val tvId = extras.getString(EXTRA_TV)
            if (tvId != null) {
                viewModel.selectIdTvShow(tvId)
                viewModel.getDetailTvShow().let {
                    if (it != null){
                        Glide.with(this)
                            .load(it.poster)
                            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                            .error(R.drawable.ic_error)
                            .into(img_poster_tv)
                        tv_detail_title_tv.text = it.title
                        tv_duration_detail_tv.text = it.duration
                        tv_score_detail_tv.text = it.score
                        tv_description_detail_tv.text = it.description
                    }
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}