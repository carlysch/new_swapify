package com.example.new_swapify

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.new_swapify.ui.CLIENT_ID
import com.example.new_swapify.ui.REDIRECT_URI
import com.example.new_swapify.ui.REQUEST_CODE
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse

class SpotifyLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initiateSpotifyAuthorization()
    }

    private fun initiateSpotifyAuthorization() {
        val builder = AuthorizationRequest.Builder(CLIENT_ID, AuthorizationResponse.Type.TOKEN, REDIRECT_URI)
        builder.setScopes(arrayOf("app-remote-control"))
        val request = builder.build()

        AuthorizationClient.openLoginActivity(this, REQUEST_CODE, request)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)

        // Check if result comes from the correct activity
        if (requestCode == REQUEST_CODE) {
            val response = AuthorizationClient.getResponse(resultCode, intent)
            when (response.type) {
                AuthorizationResponse.Type.TOKEN -> {
                    println("auth lib success: $response ${response.accessToken}")

                    val sharedPreferences = getSharedPreferences("com.example.new_swapify", Context.MODE_PRIVATE)
                    sharedPreferences.edit().apply {
                        putString("SPOTIFY_ACCESS_TOKEN", response.accessToken)
                        apply()
                    }

                }
                AuthorizationResponse.Type.ERROR -> {
                    println("auth lib failure: $response")
                }
                else -> {}
            }
        }
    }
}
