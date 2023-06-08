package com.example.new_swapify.ui

import android.content.Intent
import android.net.Uri
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.new_swapify.R
import com.example.new_swapify.SpotifyLoginActivity
import com.example.new_swapify.ui.theme.My_Theme
import com.example.new_swapify.ui.theme.blueBGNight


val REQUEST_CODE = 1337
val REDIRECT_URI = "http://localhost:8080"
val CLIENT_ID = "338e7ddbbb344761b87776da268adf5f"

@Composable
fun ConnectScreen(spotifyActivityResultLauncher: ActivityResultLauncher<Intent>) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
    ) {
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(35.dp))

        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
        Text(
            text = "swapify",
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.surface
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
        Text(
            text = stringResource(R.string.info1),
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.surface
        )
        Text(
            text = stringResource(R.string.info2),
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.surface

        )
        Spacer(modifier = Modifier.height(180.dp))

        Button(onClick = {
            val intent = Intent(context, SpotifyLoginActivity::class.java)
            spotifyActivityResultLauncher.launch(intent)
        }) {
            Text(text = "connect")
        }
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
        val normalText = "don't forget to "
        val underlinedText = "install spotify"

        val annotatedString = AnnotatedString.Builder().apply {
            // add normal text with the style, but no underline
            pushStyle(
                style = SpanStyle(
                    color = MaterialTheme.colors.surface,
                    fontSize = MaterialTheme.typography.subtitle2.fontSize
                )
            )
            append(normalText)
            pop()

            // add the underlined text with the style
            pushStyle(
                style = SpanStyle(
                    textDecoration = TextDecoration.Underline,
                    color = MaterialTheme.colors.surface,
                    fontSize = MaterialTheme.typography.subtitle2.fontSize,
                )
            )
            append(underlinedText)
            pop()
        }.toAnnotatedString()
        ClickableText(
            text = annotatedString,
            onClick = { offset ->
                val url = "https://play.google.com/store/apps/details?id=com.spotify.music"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                context.startActivity(intent)
            },
        )
    }

}
//@Preview(showBackground = true)
//@Composable
//fun GameScreenPreview() {
//    My_Theme {
//        ConnectScreen()
//    }
//}