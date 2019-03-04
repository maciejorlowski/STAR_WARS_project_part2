package project.pb.star_wars_project.functional.rest

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object Rest {


        fun create(): RestInterface {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create())

                .addConverterFactory(
                    GsonConverterFactory.create())
                .baseUrl("https://swapi.co/api/")
                .build()

            return retrofit.create(RestInterface::class.java)
        }



}