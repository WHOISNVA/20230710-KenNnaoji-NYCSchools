package com.dapperartisancompany.kennnaoji_nycschools.service

import com.dapperartisancompany.kennnaoji_nycschools.data.SchoolDetailResults
import com.dapperartisancompany.kennnaoji_nycschools.data.SchoolResults
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("f9bf-2cp4.json")
    fun getSchoolData() : Call<List<SchoolResults>>

    @GET("s3k6-pzi2.json")
    fun getSchoolDetailsData() : Call<List<SchoolDetailResults>>

    companion object {
        //decided to use the api that contains both the names and the scores
        const val BASE_URL = "https://data.cityofnewyork.us/resource/"
    }
}