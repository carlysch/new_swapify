package com.example.new_swapify.ui

import android.content.Context
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.example.new_swapify.SpotifyLoginActivity

val REQUEST_CODE = 1337
val REDIRECT_URI = "http://localhost:8080"
val CLIENT_ID = "338e7ddbbb344761b87776da268adf5f"

@Composable
fun ConnectScreen(spotifyActivityResultLauncher: ActivityResultLauncher<Intent>) {
    val context = LocalContext.current

    val token = remember {
        mutableStateOf("")
    }

    LaunchedEffect(Unit) {
        context.getSharedPreferences("com.example.new_swapify", Context.MODE_PRIVATE)?.let {
            token.value = it.getString("SPOTIFY_ACCESS_TOKEN", "") ?: ""
        }
    }

    Column {
        Text("Swapify")
        Text("share current playing tracks with nearby users")
        Button(onClick = {
            val intent = Intent(context, SpotifyLoginActivity::class.java)
            spotifyActivityResultLauncher.launch(intent)
        }) {
            Text(text = "connect")
        }
        Text("don't forget to install spotify")
        if (token.value.isNotBlank()) {
            Text("Token: ${token.value}")
        }
    }
}





//@Preview(showBackground = true)
//@Composable
//fun ConnectScreenPreview() {
//    New_swapifyTheme {
//        ConnectScreen()
//    }
//}