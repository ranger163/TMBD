package me.inassar.tmbd.view.popularmovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import io.reactivex.disposables.CompositeDisposable
import me.inassar.tmbd.configs.Constants.PAGING_POST_PER_PAGE
import me.inassar.tmbd.data.api.AppApi
import me.inassar.tmbd.data.model.PopularMoviesModel
import me.inassar.tmbd.data.repository.NetworkState
import me.inassar.tmbd.data.repository.PopularMovieDataSourceFactory
import me.inassar.tmbd.data.repository.PopularMoviesDataSource

class MoviePagedListRepository(private val apiService: AppApi) {

    lateinit var moviePagedList: LiveData<PagedList<PopularMoviesModel.Movie>>
    lateinit var moviesDataSourceFactory: PopularMovieDataSourceFactory

    fun fetchLiveMoviePagedList(compositeDisposable: CompositeDisposable): LiveData<PagedList<PopularMoviesModel.Movie>> {
        moviesDataSourceFactory = PopularMovieDataSourceFactory(apiService, compositeDisposable)

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(PAGING_POST_PER_PAGE)
            .build()

        moviePagedList = LivePagedListBuilder(moviesDataSourceFactory, config).build()

        return moviePagedList
    }

    fun getNetworkState(): LiveData<NetworkState> {
        return Transformations.switchMap<PopularMoviesDataSource, NetworkState>(
            moviesDataSourceFactory.moviesLiveDataSource, PopularMoviesDataSource::networkState
        )
    }
}