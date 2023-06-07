package com.example.new_swapify.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.new_swapify.data.FakeData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class MockViewModel: ViewModel() {
    var data = mutableStateOf(listOf<FakeData>())
    init {
        getData()
    }
    private fun getData(){
        viewModelScope.launch {
            data.value = getDataFromFirestore()
        }
    }
    private suspend fun getDataFromFirestore(): List<FakeData> {
        val db = FirebaseFirestore.getInstance()
        var result = listOf<FakeData>()
        try{
            result = db.collection("FakeData").get().await().map{
                it.toObject(FakeData::class.java)
            }
        }
        catch (e: FirebaseFirestoreException)
        {
            Log.d("error", "getDataFromFirestore: $e")
        }
        return result
    }


}