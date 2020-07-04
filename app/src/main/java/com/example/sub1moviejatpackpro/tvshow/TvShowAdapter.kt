package com.example.sub1moviejatpackpro.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.sub1moviejatpackpro.R
import com.example.sub1moviejatpackpro.model.TvShow
import kotlinx.android.synthetic.main.items_tv_show.view.*

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.TvViewModel>() {
    private var listTvShow = ArrayList<TvShow>()

    fun setTvShow(tv: List<TvShow>?) {
        if (tv == null) return
        listTvShow.clear()
        listTvShow.addAll(tv)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewModel {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_tv_show, parent, false)
        return TvViewModel(view)
    }

    override fun getItemCount(): Int = listTvShow.size

    override fun onBindViewHolder(holder: TvViewModel, position: Int) {
        val tv = listTvShow[position]
        holder.bind(tv)
    }

    class TvViewModel(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(tvShow: TvShow) {
            with(itemView) {
                tv_item_title_tv.text = tvShow.title
                tv_item_tv_duration.text = tvShow.duration
                Glide.with(itemView.context)
                    .load(tvShow.poster)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(img_item_tv_show)
                btn_play_tv.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvActivity::class.java)
                    intent.putExtra(DetailTvActivity.EXTRA_TV, tvShow.id)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}