package com.example.androiddemo.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddemo.MainScreen
import com.example.androiddemo.R
import com.example.androiddemo.ui.theme.AndroidDemoTheme

@Composable
fun ArtSpace() {
    val imageArray = arrayOf(
        R.drawable.android_logo,
        R.drawable.lemon_tree,
        R.drawable.dice_1
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.6f)
                .padding(top = 50.dp, bottom = 50.dp)
                .background(Color.White)
                .shadow(3.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = imageArray[0]),
                contentDescription = null
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                .background(Color.Gray.copy(alpha = 0.1f))
        ) {

            Text(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp),
                text = "Artwork Title"
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 20.dp),
                text = "Artwork Artist (Year)"
            )
        }
        Row {
            Button(
                modifier = Modifier
                    .width(150.dp),
                onClick = { /*TODO*/ }
            ) {
                Text("Previous")
            }
            Spacer(modifier = Modifier.width(50.dp))
            Button(
                modifier = Modifier
                    .width(150.dp),
                onClick = { /*TODO*/ }
            ) {
                Text("Next")
            }
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
            ArtSpace()
        }
    }
}