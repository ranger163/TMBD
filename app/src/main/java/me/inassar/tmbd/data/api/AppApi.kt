package me.inassar.tmbd.data.api

import io.reactivex.Single
import me.inassar.tmbd.configs.AppConfig
import me.inassar.tmbd.configs.Constants
import me.inassar.tmbd.configs.Constants.ENDPOINT_MOVIE_DETAILS
import me.inassar.tmbd.configs.Constants.ENDPOINT_POPULAR_MOVIES
import me.inassar.tmbd.configs.Constants.QUERY_PARAM_PAGE
import me.inassar.tmbd.data.model.MovieDetailsModel
import me.inassar.tmbd.data.model.PopularMoviesModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppApi {
    @GET(ENDPOINT_MOVIE_DETAILS)
    fun getMovieDetails(@Path(Constants.PATH_PARAM_MOVIE_ID) movieId: Int): Single<MovieDetailsModel>

    @GET(ENDPOINT_POPULAR_MOVIES)
    fun getPopularMovies(@Query(QUERY_PARAM_PAGE) page: Int): Single<PopularMoviesModel>
}

object ApiCall {
    fun getClient(): AppApi {
        return AppConfig.instance().retrofit.create(AppApi::class.java)
    }
}