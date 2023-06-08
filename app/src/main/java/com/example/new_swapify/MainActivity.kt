package com.example.new_swapify

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.new_swapify.ui.CLIENT_ID
import com.example.new_swapify.ui.ConnectScreen
import com.example.new_swapify.ui.theme.My_Theme
import com.example.new_swapify.ui.REDIRECT_URI
import com.example.new_swapify.ui.REQUEST_CODE
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse

class MainActivity : ComponentActivity() {
    private lateinit var spotifyActivityResultLauncher: ActivityResultLauncher<Intent>

//    // this is how to retrieve the token from local storage. don't know where this should go so I am putting it here.
//    val sharedPreferences = getSharedPreferences("com.example.new_swapify", Context.MODE_PRIVATE)
//    val token = sharedPreferences.getString("SPOTIFY_ACCESS_TOKEN", null)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        spotifyActivityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val token = data?.getStringExtra("RESULT")
                println("auth lib success: $token")
            }
        }

        setContent {
            val currentTheme = isSystemInDarkTheme()

            My_Theme{
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    ConnectScreen()
                }
            New_swapifyTheme {
                ConnectScreen(spotifyActivityResultLauncher)
            }
        }
    }


    private fun setDarkTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)    }

    private fun setDayTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }
}


//@ExperimentalAnimationApi
//@Preview("Dark Theme", widthDp = 360, heightDp = 640)
//@Composable
//fun DarkPreview() {
//    My_Theme() {
//        ConnectScreen()
//    }
//}

