package com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67.utils

object Constants {
    const val BASE_URL="https://api.themoviedb.org/3/"
    const val API_KEY="f1ddd618cdb3c87a4bdf3e5ca21395c1"
    //https://api.themoviedb.org/3/movie/popular?api_key=f1ddd618cdb3c87a4bdf3e5ca21395c1
    //http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4

    /*
     @GET("movie/popular")
    Call<MoviesResponse> getPopularMovies(@Query("page") int page);

    @GET("movie/top_rated")
    Call<MoviesResponse> getTopRatedMovies(@Query("page") int page);

    @GET("movie/now_playing")
    Call<MoviesResponse> getNowPlayingMovies(@Query("page") int page);

    // Instead of using 4 separate requests we use append_to_response
    // to eliminate duplicate requests and save network bandwidth
    // this request return full movie details, trailers, reviews and cast
    @GET("movie/{id}?append_to_response=videos,credits,reviews")
    LiveData<ApiResponse<Movie>> getMovieDetails(@Path("id") long id);



     */
}