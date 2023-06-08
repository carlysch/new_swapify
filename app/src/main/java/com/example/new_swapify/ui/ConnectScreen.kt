package com.example.new_swapify.ui

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
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.new_swapify.R
import com.example.new_swapify.ui.theme.My_Theme
import com.example.new_swapify.ui.theme.blueBGNight


@Composable
fun ConnectScreen(){
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

        Button(onClick = {}) {
            Text("connect")
        }
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
        Text(
            text = stringResource(R.string.install),
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.surface

        )
    }

}
@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    My_Theme {
        ConnectScreen()
    }
}