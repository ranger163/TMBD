package me.inassar.tmbd.configs

object Constants {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"

    const val THE_MOVIE_DB_API_KEY = "ADD YOUR API KET HERE"

    const val ENDPOINT_POPULAR_MOVIES = "movie/popular"
    const val ENDPOINT_MOVIE_DETAILS = "movie/{movie_id}"

    const val PATH_PARAM_MOVIE_ID = "movie_id"

    const val QUERY_PARAM_API_KEY = "api_key"
    const val QUERY_PARAM_PAGE = "page"

    const val PAGING_FIRST_PAGE = 1
    const val PAGING_POST_PER_PAGE = 20
}