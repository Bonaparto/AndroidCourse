package com.example.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.afinal.Country
import com.example.afinal.databinding.CountryItemBinding

class Adapter(
    var countries: List<Country>
): RecyclerView.Adapter<Adapter.CountryViewHolder>() {

    inner class CountryViewHolder(
        private val binding: CountryItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {
            binding.countryName.text = country.Country
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = CountryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        holder.bind(country)
    }

    override fun getItemCount() = countries.size
}