package com.dapperartisancompany.kennnaoji_nycschools

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dapperartisancompany.kennnaoji_nycschools.data.SchoolResults
import com.dapperartisancompany.kennnaoji_nycschools.databinding.ActivityMainBinding
import com.dapperartisancompany.kennnaoji_nycschools.service.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val schoolData: ArrayList<SchoolResults> = arrayListOf()
    val adapter = SchoolAdapter(this, schoolData)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.mainContent.recyclerView.setHasFixedSize(true)
        binding.mainContent.recyclerView.adapter = adapter

        getSchoolData()
    }

    private fun getSchoolData() {
        val call = RetrofitClient.getApi().getSchoolData()
        call.enqueue(object : Callback<List<SchoolResults>> {
            @SuppressLint("NotifyDataSetChanged") override fun onResponse(call: Call<List<SchoolResults>>, response: Response<List<SchoolResults>>) {
                val schoolData = response.body()
                schoolData?.let {
                    this@MainActivity.schoolData.addAll(it)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<SchoolResults>>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occurred", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }
}