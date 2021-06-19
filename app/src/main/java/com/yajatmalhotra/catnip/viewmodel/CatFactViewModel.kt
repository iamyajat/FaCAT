package com.yajatmalhotra.catnip.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yajatmalhotra.catnip.model.CatFact
import com.yajatmalhotra.catnip.repository.CatFactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatFactViewModel
@Inject
constructor(private val repository: CatFactRepository) : ViewModel() {
    private val _resp = MutableLiveData<CatFact>()
    val catFactResp: LiveData<CatFact>
        get() = _resp

    init {
        getCatFact()
    }

    fun getCatFact() = viewModelScope.launch {
        repository.getCatFact().let { response ->
            if (response.isSuccessful) {
                _resp.postValue(response.body())
            } else {
                Log.d("ERROR RESPONSE", "Meow: ${response.message()}")
            }
        }
    }
}
