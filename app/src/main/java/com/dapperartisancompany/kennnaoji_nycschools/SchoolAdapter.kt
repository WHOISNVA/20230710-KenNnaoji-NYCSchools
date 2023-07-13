package com.dapperartisancompany.kennnaoji_nycschools

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dapperartisancompany.kennnaoji_nycschools.data.SchoolResults
import com.dapperartisancompany.kennnaoji_nycschools.databinding.CardLayoutBinding

class SchoolAdapter(private val context: Context, private val listData: List<SchoolResults>) : RecyclerView.Adapter<SchoolAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val listItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = listData[position]
        holder.binding.textViewSchoolName.text = listData[position].name
        holder.binding.numOfSatTestTakers.text = "Number of sat test takers: ${model.testerNumber}"
        holder.binding.mathScore.text = "Math Score: ${model.mathScore}"
        holder.binding.readingScore.text = "Writing Score: ${model.readingScore}"
        holder.binding.writingScore.text = "Reading Score: ${model.writingScore}"
        holder.binding.wholeCardLayout.setOnClickListener {
            val intent = Intent(context, SchoolDetailActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("dbn", model.dBNumber)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = CardLayoutBinding.bind(itemView)
    }
}