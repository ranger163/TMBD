package me.inassar.tmbd.configs

import android.app.Application
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class AppConfig : Application() {

    val retrofit: Retrofit
        get() = retrofitConfig()

    private fun retrofitConfig(): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClientProvider())
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun okHttpClientProvider(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptorProvider())
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    private fun interceptorProvider(): Interceptor {
        return Interceptor { chain ->
            val url = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter(
                    Constants.PATH_PARAM_API_KEY,
                    Constants.THE_MOVIE_DB_API_KEY
                )
                .build()
            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()
            return@Interceptor chain.proceed(request)
        }
    }

    companion object {
        fun instance() = AppConfig()
    }
}