package com.example.afinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Button
import android.widget.TextView
import org.json.JSONObject
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8) {
            val policy = StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        val countryList = CountryList()
        val choosenCountry = Country()

        val countriesListURL = "https://api.covid19api.com/countries"
        val choosenCountryURL = "https://api.covid19api.com/country/"

        val btn = findViewById<Button>(R.id.button)
        val countryListText = findViewById<TextView>(R.id.countryList)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.countryListFragment, choosenCountry)
            addToBackStack(null)
            commit()
        }

        btn.setOnClickListener {
            var apiResponse = URL(countriesListURL).readText()
            Log.d("response", apiResponse)
            val countryListArray = apiResponse

            countryListText.setText(countryListArray)
        }
    }
}