package com.example.afinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.afinal.databinding.FragmentCountryListBinding
import com.example.myapplication.ui.adapter.Adapter

class CountryList : Fragment(R.layout.fragment_country_list) {

    private lateinit var binding: FragmentCountryListBinding
    private var Countries = emptyList<Country>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCountryListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    fun initUI() {
        binding.countryList.apply {
            adapter = Adapter()
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }
}