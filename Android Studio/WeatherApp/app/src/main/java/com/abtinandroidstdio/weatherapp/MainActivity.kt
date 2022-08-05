package com.abtinandroidstdio.weatherapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.abtinandroidstdio.weatherapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun onSearchClick(view : View){

        val cityName = binding.CityNameInputView.text.toString()
        if(cityName.isEmpty()){
            Toast.makeText(this,"Please fill \"City Name\" field" , Toast.LENGTH_LONG).show()
        }else{
            val intent = Intent(this , WeatherActivity::class.java)
            intent.putExtra("cityName" , cityName)
            startActivity(intent)
        }
    }




}