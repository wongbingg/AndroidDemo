package com.example.androiddemo.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androiddemo.MainScreen
import com.example.androiddemo.R
import com.example.androiddemo.ui.theme.AndroidDemoTheme

data class Art(val imageResource: Int, val title: String, val description: String)
@Composable
fun ArtSpace(navController: NavHostController) {
    val imageArray = listOf(
        Art(R.drawable.android_logo, "Android Logo", "android logo(2020)"),
        Art(R.drawable.lemon_tree, "Lemon Tree", "d"),
        Art(R.drawable.dice_1, "Dice_1", "dice 1 description")
    )

    var index by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .width(350.dp)
                .fillMaxHeight(0.6f)
                .padding(top = 50.dp, bottom = 50.dp)
                .background(Color.White)
                .shadow(3.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = imageArray[index].imageResource),
                contentDescription = null
            )
        }
        Column(
            modifier = Modifier
                .width(350.dp)
                .padding(bottom = 20.dp)
                .background(Color.Gray.copy(alpha = 0.1f))
        ) {

            Text(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp),
                text = imageArray[index].title
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 20.dp),
                text = imageArray[index].description
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Button(
                modifier = Modifier
                    .width(150.dp),
                onClick = {
                    if (index == 0) {
                        index = imageArray.count() - 1
                        return@Button
                    }
                    index--
                }
            ) {
                Text("Previous")
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                modifier = Modifier
                    .width(150.dp),
                onClick = {
                    if (index == imageArray.count() - 1) {
                        index = 0
                        return@Button
                    }
                    index++
                }
            ) {
                Text("Next")
            }
        }

        Button(onClick = { navController.popBackStack() }) {
            Text("go back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidDemoTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ArtSpace(rememberNavController())
        }
    }
}