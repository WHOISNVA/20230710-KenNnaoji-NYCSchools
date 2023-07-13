package com.dapperartisancompany.kennnaoji_nycschools.data

import com.google.gson.annotations.SerializedName

class SchoolDetailResults {
    //api database columns
    @SerializedName("school_name")
    val name: String? = null

    // retrieving and assigning values
    @SerializedName("dbn")
    val dBNumber: String? = null

    @SerializedName("phone_number")
    val phoneNumber: String? = null

    @SerializedName("email")
    val email: String? = null

    @SerializedName("website")
    val website: String? = null

    @SerializedName("location")
    val location: String? = null

    @SerializedName("ell_programs")
    val programs: String? = null

    @SerializedName("overview_paragraph")
    val overview: String? = null
}