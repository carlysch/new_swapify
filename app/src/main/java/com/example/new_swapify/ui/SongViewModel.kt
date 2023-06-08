package com.example.new_swapify.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.new_swapify.data.Song
import com.example.new_swapify.data.User
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class SongViewModel: ViewModel() {
    var data = mutableStateOf(listOf<User>())
    init {
        getUser()
    }
    private fun getUser(){
        viewModelScope.launch {
            data.value = getUserFromFirestore()
        }
    }
    private suspend fun getUserFromFirestore(): List<User> {
        val db = FirebaseFirestore.getInstance()
        var result = listOf<User>()
        try{
            result = db.collection("Users").get().await().map{
                it.toObject(User::class.java)
            }
        }
        catch (e: FirebaseFirestoreException)
        {
            Log.d("error", "getDataFromFirestore: $e")
        }
        return result
    }
    private suspend fun getSongFromFirestore(): List<Song> {
        val db = FirebaseFirestore.getInstance()
        var result = listOf<Song>()
        try{
            result = db.collection("Songs").get().await().map{
                it.toObject(Song::class.java)
            }
        }
        catch (e: FirebaseFirestoreException)
        {
            Log.d("error", "getDataFromFirestore: $e")
        }
        return result
    }
    fun addUserToFireStore(someUser: User){
        val db = FirebaseFirestore.getInstance()
        val userToAdd = hashMapOf(
            "name" to someUser.name,
            "username" to someUser.username,
            "queue" to someUser.queue
        )
        db.collection("Users")
            .add(userToAdd)
            .addOnSuccessListener { documentReference ->
                Log.d("success", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener{e ->
                Log.d("error", "Error adding document $e")
            }

    }
}