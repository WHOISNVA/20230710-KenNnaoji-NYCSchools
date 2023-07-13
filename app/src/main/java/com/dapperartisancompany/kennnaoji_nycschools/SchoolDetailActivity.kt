package com.dapperartisancompany.kennnaoji_nycschools

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dapperartisancompany.kennnaoji_nycschools.data.SchoolDetailResults
import com.dapperartisancompany.kennnaoji_nycschools.databinding.ActivitySchoolDetailBinding
import com.dapperartisancompany.kennnaoji_nycschools.service.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SchoolDetailActivity : AppCompatActivity() {

    val binding: ActivitySchoolDetailBinding by lazy { ActivitySchoolDetailBinding.inflate(layoutInflater) }
    var dbn: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        dbn = intent.getStringExtra("dbn")
        getSchoolDetailData()
        binding.backBtn.setOnClickListener { finish() }
    }

    private fun getSchoolDetailData() {
        binding.progressBar.visibility = View.VISIBLE
        binding.mainBody.visibility = View.GONE
        val call: Call<List<SchoolDetailResults>> = RetrofitClient.getApi().getSchoolDetailsData()
        call.enqueue(object : Callback<List<SchoolDetailResults>> {
            @SuppressLint("SetTextI18n") override fun onResponse(call: Call<List<SchoolDetailResults>>, response: Response<List<SchoolDetailResults>>) {
                val schoolData = response.body()
                var schoolDataModel: SchoolDetailResults? = null
                schoolData?.let {
                    schoolDataModel = it.find { sData -> sData.dBNumber == dbn }
                }
                schoolDataModel?.let {
                    binding.textViewSchoolName.text = it.name
                    binding.overviewParagraph.text = it.overview
                    if (it.email == null) {
                        binding.email.text = "Email: N/A"
                    } else {
                        binding.email.text = "Email: ${it.email}"
                    }
                    binding.website.text = "Website: ${it.website}"
                    binding.location.text = "Location: ${it.location}"
                    binding.phoneNumber.text = "Phone Number: ${it.phoneNumber}"
                    binding.ellPrograms.text = "Program: ${it.programs}"
                    binding.progressBar.visibility = View.GONE
                    binding.mainBody.visibility = View.VISIBLE
                }

            }

            override fun onFailure(call: Call<List<SchoolDetailResults>>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occurred", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }
}