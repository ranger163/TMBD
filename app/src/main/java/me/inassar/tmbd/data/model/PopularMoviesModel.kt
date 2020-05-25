package me.inassar.tmbd.data.model


import com.google.gson.annotations.SerializedName

data class PopularMoviesModel(
    val page: Int,
    @SerializedName("results")
    val movieList: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
) {
    data class Movie(
        val id: Int,
        @SerializedName("poster_path")
        val posterPath: String,
        @SerializedName("release_date")
        val releaseDate: String,
        val title: String
    )
}