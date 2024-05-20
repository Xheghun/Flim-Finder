package com.xheghun.kotlincoroutines.ui.movies

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.xheghun.kotlincoroutines.data.model.Movie
import com.xheghun.kotlincoroutines.databinding.ActivityMoviesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesActivity : AppCompatActivity(), MoviesView {

    private val presenter: MoviesPresenter by viewModel<MoviesPresenterImpl>()
    private val movieAdapter by lazy { MovieAdapter() }
    private lateinit var binding: ActivityMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initUi()
        presenter.setView(this)
    }

    private fun initUi() {
        binding.moviesList.adapter = movieAdapter
        binding.moviesList.layoutManager = LinearLayoutManager(this)
        binding.swipeToRefresh.setOnRefreshListener {
            presenter.getData()
        }
    }

    override fun showMovies(movies: List<Movie>) {
        movieAdapter.setData(movies)
        Log.d("", "recycler adapter ${(binding.moviesList.adapter as MovieAdapter).itemCount} ")
        binding.swipeToRefresh.isRefreshing = false
    }

    override fun showError(throwable: Throwable) {
        binding.swipeToRefresh.isRefreshing = false
    }

    override fun onStart() {
        super.onStart()
        presenter.getData()
    }
}
