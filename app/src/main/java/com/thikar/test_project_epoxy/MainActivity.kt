package com.thikar.test_project_epoxy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.airbnb.epoxy.EpoxyRecyclerView
import org.json.JSONObject

const val TAG="Main Activity"


class MainActivity : AppCompatActivity() {

    lateinit var controller: BucketItemEpoxyController
    private val viewModel: MainViewModel by viewModels()

    lateinit var countryCodeJsonObj:JSONObject
    lateinit var availableCredit:String
    lateinit var creditZonesList:ArrayList<CreditZoneModel>
    lateinit var recomended:RecommendedModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getValues()

        val recyclerView = findViewById<EpoxyRecyclerView>(R.id.epoxyRecyclerView)
        recyclerView.setControllerAndBuildModels(controller)
    }

    private fun getValues(){
        countryCodeJsonObj = JSONObject(this.loadJSONFromAssets("country_code.json"))

        val data = countryCodeJsonObj.getJSONObject("data")
        availableCredit = data.getString("availableCredit")
        creditZonesList = data.getJSONArray("creditZones") as ArrayList<CreditZoneModel>
        recomended = data.getJSONObject("recommended") as RecommendedModel

        Log.d(TAG, "getValues: $availableCredit ${creditZonesList[1]} $recomended")
    }

    private fun loadJSONFromAssets(fileName: String): String {
        return applicationContext.assets.open(fileName).bufferedReader().use { reader ->
            reader.readText()
        }
    }
}



