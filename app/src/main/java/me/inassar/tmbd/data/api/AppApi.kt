package me.inassar.tmbd.data.api

import io.reactivex.Single
import me.inassar.tmbd.AppConfig
import me.inassar.tmbd.Constants
import me.inassar.tmbd.data.model.MovieDetailsModel
import retrofit2.http.GET
import retrofit2.http.Path

interface AppApi {
    @GET(Constants.MOVIE_DETAILS_URL)
    fun getMovieDetails(@Path(Constants.PATH_PARAM_MOVIE_ID) movieId: Int): Single<MovieDetailsModel>
}

object ApiCall {
    fun getClient(): AppApi {
        return AppConfig.instance().retrofit.create(AppApi::class.java)
    }
}