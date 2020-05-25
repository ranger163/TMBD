package me.inassar.tmbd.view.moviedetails

import androidx.lifecycle.LiveData
import io.reactivex.disposables.CompositeDisposable
import me.inassar.tmbd.data.api.AppApi
import me.inassar.tmbd.data.model.MovieDetailsModel
import me.inassar.tmbd.data.repository.MovieDetailsNetworkDataSource
import me.inassar.tmbd.data.repository.NetworkState

class MovieDetailsRepository(private val apiService: AppApi) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchMovieDetails(
        compositeDisposable: CompositeDisposable,
        movieId: Int
    ): LiveData<MovieDetailsModel> {
        movieDetailsNetworkDataSource =
            MovieDetailsNetworkDataSource(apiService, compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.movieDetailsResponse
    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }
}