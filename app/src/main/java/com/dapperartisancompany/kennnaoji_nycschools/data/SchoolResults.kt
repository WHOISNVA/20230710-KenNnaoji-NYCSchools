package com.dapperartisancompany.kennnaoji_nycschools.data

import com.google.gson.annotations.SerializedName

class SchoolResults {
    //api database columns
    @SerializedName("school_name")
    val name: String? = null

    // retrieving and assigning values
    @SerializedName("dbn")
    val dBNumber: String? = null

    @SerializedName("sat_writing_avg_score")
    val writingScore: String? = null

    @SerializedName("sat_math_avg_score")
    val mathScore: String? = null

    @SerializedName("sat_critical_reading_avg_score")
    val readingScore: String? = null

    @SerializedName("num_of_sat_test_takers")
    val testerNumber: String? = null
}