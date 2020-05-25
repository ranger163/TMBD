package me.inassar.tmbd.data.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import io.reactivex.disposables.CompositeDisposable
import me.inassar.tmbd.data.api.AppApi
import me.inassar.tmbd.data.model.PopularMoviesModel

class PopularMovieDataSourceFactory(
    private val apiService: AppApi,
    private val compositeDisposable: CompositeDisposable
) : DataSource.Factory<Int, PopularMoviesModel.Movie>() {

    val moviesLiveDataSource = MutableLiveData<PopularMoviesDataSource>()

    override fun create(): DataSource<Int, PopularMoviesModel.Movie> {
        val movieDataSource = PopularMoviesDataSource(apiService, compositeDisposable)

        moviesLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }
}