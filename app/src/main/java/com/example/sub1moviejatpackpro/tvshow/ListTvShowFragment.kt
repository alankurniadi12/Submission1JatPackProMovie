package com.example.sub1moviejatpackpro.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sub1moviejatpackpro.R
import kotlinx.android.synthetic.main.fragment_list_tv_show.*


class ListTvShowFragment : Fragment() {

    private lateinit var tvShowAdapter: TvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]
            val tv = viewModel.getTvShow()
            tvShowAdapter = TvShowAdapter()
            tvShowAdapter.setTvShow(tv)

            with(rv_tvshow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }

        //btn_play_tv.setOnClickListener(this)
    }


    /*override fun onClick(v: View) {
        when(v.id){
            R.id.btn_play_tv -> {
                val intent = Intent(context, DetailTvActivity::class.java)
                intent.putExtra(DetailTvActivity.EXTRA_TV, tvShow?.id)
                startActivity(intent)
            }
        }
    }*/

}