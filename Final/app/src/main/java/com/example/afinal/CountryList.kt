package com.example.afinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.afinal.databinding.FragmentCountryListBinding
import com.example.myapplication.ui.adapter.Adapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryList : Fragment(R.layout.fragment_country_list) {

    private lateinit var binding: FragmentCountryListBinding
    private var countries = emptyList<Country>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCountryListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        countries = getCountries()
        Log.d("check", countries.toString())
        initUI()
    }

    fun getCountries(): List<Country> {
        var result = emptyList<Country>()
        App.instance.apiService.getCountries().enqueue(object : Callback<List<Country>> {
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                result = response.body()!!
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                Log.i("Error", "Error")
            }
        })
        return result
    }
    fun initUI() {
        binding.countryList.apply {
            adapter = Adapter(countries)
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }
}