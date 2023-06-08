package com.example.new_swapify.ui
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
//import androidx.compose.material.Icon
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.new_swapify.R
import com.example.new_swapify.components.SongCard
import com.example.new_swapify.data.FakeDataBase
import com.example.new_swapify.ui.theme.My_Theme

@Composable
fun SongScreen(
) {
    val songList = FakeDataBase.songList
//    val userList = songViewModel.data.value.toString()
      Column(modifier = Modifier
          .fillMaxSize()
          .background(MaterialTheme.colors.background)
          .padding(start = 10.dp, top = 10.dp)) {
          Text(text = "Hi User!",
              color = MaterialTheme.colors.surface,
              style = MaterialTheme.typography.h4)

          Text(text = "Check what songs others are listening too....",
                color = MaterialTheme.colors.surface,
                style = MaterialTheme.typography.body1)

        LazyColumn {
            items(songList){
                songList.forEach{
                    SongCard(it)
                }
            }
        }
      }

}
@Preview(showBackground = true)
@Composable
fun GmeScreenPreview() {
    My_Theme {
        SongScreen()
    }
}