package com.thikar.test_project_epoxy

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import org.json.JSONArray

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext

    val _amountLiveData = MutableLiveData<Character?>()
    val amountLiveData: LiveData<Character?> = _amountLiveData

    fun fetchCharacter(characterId: Int) = viewModelScope.launch {

    }
}

//val countryCodeJsonArray =
//    JSONArray(activity?.loadJSONFromAssets("country_code.json")) // Extension Function call
//for (i in 0 until countryCodeJsonArray.length()) {
//
//    countryCodeJSONObject = countryCodeJsonArray.getJSONObject(i)
//    countryCodeItem = CountryCode(
//        countryCodeJSONObject.getString("name"),
//        countryCodeJSONObject.getString("dial_code"),
//        countryCodeJSONObject.getString("code")
//    )
//    countryCodeList.add(countryCodeItem)
//}