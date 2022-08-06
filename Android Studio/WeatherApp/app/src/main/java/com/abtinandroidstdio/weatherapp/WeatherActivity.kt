package com.abtinandroidstdio.weatherapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.abtinandroidstdio.weatherapp.databinding.ActivityWeatherBinding
import com.bumptech.glide.Glide
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class WeatherActivity : AppCompatActivity() {


    lateinit var binding:ActivityWeatherBinding
    lateinit var cityName : String
    lateinit var appLanguage : String

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase!!))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cityName = intent.getStringExtra("cityName").toString()
        appLanguage = intent.getStringExtra("appLanguage").toString()
        initialFunc()
    }
    fun initialFunc(){
        val client = OkHttpClient()
        val url = "https://api.openweathermap.org/data/2.5/weather?q=${cityName}&appid=a5ab76fae5a9227d96ff3adf0b793c8f&lang=$appLanguage&units=metric"
        val request = Request.Builder()
            .url(url)
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO()
            }
            override fun onResponse(call: Call, response: Response) {
                val rawJSONContext = response.body!!.string()
                Log.d("tagJson" , "Json: ${rawJSONContext}")
                val jsonObject = JSONObject(rawJSONContext)

                runOnUiThread {
                    cityNameFunc(jsonObject)
                }

            }

        })
    }


    fun cityNameFunc(jsonObject: JSONObject){
        val cityName = jsonObject.getString("name")
        binding.cityName.text = cityName
        descriptionOfWeatherFunc(jsonObject)

    }

    private fun descriptionOfWeatherFunc(jsonObject: JSONObject) {

        val weatherArray = jsonObject.getJSONArray("weather")
        val weatherArrayJsonObject = weatherArray.getJSONObject(0)
        binding.weatherDescription.text = weatherArrayJsonObject.getString("description")
        weatherIconDownloader(weatherArrayJsonObject )
        sunRiseAndSunSetView(jsonObject)
    }


    private fun weatherIconDownloader(weatherArrayJsonObject : JSONObject) {

        val iconId = weatherArrayJsonObject.getString("icon")
        val iconUrl = "https://openweathermap.org/img/wn/$iconId@2x.png"
        Glide.with(this@WeatherActivity).load(iconUrl).into(binding.iconImage)
    }

    private fun sunRiseAndSunSetView(jsonObject : JSONObject){
        languageSelection()
        val sunriseTime = jsonObject.getJSONObject("sys").getInt("sunrise")
        val sunsetTime = jsonObject.getJSONObject("sys").getInt("sunset")
        val sunriseText = timeFormatter(sunriseTime)
        val sunsetText = timeFormatter(sunsetTime)
        binding.sunriseTextView.append(sunriseText.toString())
        binding.sunsetTextView.append(sunsetText.toString())
        weatherDetails(jsonObject)

    }

    private fun timeFormatter(time :Int):String{
        val longTime = time * 1000.toLong()
        val date = Date(longTime)
        val dateFormatter = SimpleDateFormat("HH:mm a")
        return dateFormatter.format(date)
    }

    private fun languageSelection(){
        if(appLanguage.equals("fa")){
            binding.sunriseTextView.text = "ساعت طلوع آفتاب :"
            binding.sunsetTextView.text = "ساعت غروب آفتاب :"
            binding.maxTemperatureView.text = "بیشینه دمای هوا : "
            binding.minTemperatureView.text = "کمینه دمای هوا : "
            binding.humidityView.text = "رطوبت هوا : "
            binding.temperatureView.text = "دمای هوا : "
            binding.weatherDescripton.text = "وضعیت دما و هوا:"
            binding.windDetailsView.text = "وضعیت وزش باد:"
            binding.windSpeedView.text = "سرعت باد :  "
            binding.windDegTextView.text = "جهت وزش باد:  "
            binding.otherDetails.text  = "وضعیت جوی: "
            binding.visibilityView.text = "شعاع دید(کیلومتر):  "
            binding.pressureView.text = "فشار هوا:  "
        }else{
            binding.sunriseTextView.text = "sunrise Time:"
            binding.sunsetTextView.text = "sunset Time:  "
            binding.maxTemperatureView.text = "max Temperature:  "
            binding.minTemperatureView.text = "min Temperature:  "
            binding.humidityView.text = "Humidity Of Air: "
            binding.temperatureView.text = "Air Temperature:  "
            binding.weatherDescripton.text = "Air & Temperature:"
            binding.windDetailsView.text = "Wind:"
            binding.windSpeedView.text = "wind speed:  "
            binding.windDegTextView.text = "wind degrees:  "
            binding.otherDetails.text  = "Other Details:"
            binding.visibilityView.text = "visibility(Km):  "
            binding.pressureView.text = "pressure: "


        }
    }

    private fun weatherDetails(jsonObject : JSONObject){
       val mainJSONObject = jsonObject.getJSONObject("main")
       val temperature = mainJSONObject.getDouble("temp")
       val minTemperature = mainJSONObject.getDouble("temp_min")
       val  maxTemperature = mainJSONObject.getDouble("temp_max")
       val  humidity = mainJSONObject.getDouble("humidity")
       val  pressure =  mainJSONObject.getDouble("pressure")
       val  visibility = jsonObject.getDouble("visibility")

        binding.maxTemperatureView.append(maxTemperature.toString())
        binding.minTemperatureView.append(minTemperature.toString())
        binding.humidityView.append(humidity.toString())
        binding.temperatureView.append(temperature.toString())
        binding.pressureView.append(pressure.toString())
        binding.visibilityView.append(visibility.toString())
        windSetter(jsonObject)
    }

    private fun windSetter(jsonObject : JSONObject){
        val windJSONObject = jsonObject.getJSONObject("wind")
        val windSpeed = windJSONObject.getDouble("speed")
        val windDeg = windJSONObject.getDouble("deg")
        binding.windSpeedView.append(windSpeed.toString().plus(" Km/h"))
        binding.windDegTextView.append(windDeg.toString())
    }


}