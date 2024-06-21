package com.example.androiddemo.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androiddemo.R


@Composable
fun Lemonade(navController: NavHostController) {
    var index by remember { mutableStateOf(1) }
    val squeezeCount = (2..4).random()
    var squeezeCountSubscriber = 0

    val imageResource = when (index) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.dice_6
    }

    val descriptionResource = when (index) {
        1 -> "Tap the lemon tree to select a lemon"
        2 -> "Keep tapping the lemon to squeeze it"
        3 -> "Tap the lemonade to drink it"
        4 -> "Tap the empty glass to start again"
        else -> "[Error] Something went wrong!"
    }
    Box {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                "Lemonade",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color(0xFFf9e44b))
            )


        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = {
                    if (index == 4) {
                        index = 1
                    } else {
                        if (index == 2) { // 레몬의 경우
                            // 2..4 사이 랜덤한 횟수를 탭해야 다음으로 이동하도록
                            squeezeCountSubscriber++
                            if (squeezeCount == squeezeCountSubscriber) {
                                index++
                            } else {
                                return@Button
                            }
                            return@Button
                        }
                        index++
                    }
                },
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFc3ecd2)
                )
            ) {
                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = "1"
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(descriptionResource)

            Spacer(modifier = Modifier.height(30.dp))

            // FIXME : 버튼 이중 탭 에러 존재. Combine throttle과 같은 기능이 필요.
            Button(onClick = { navController.popBackStack() }) {
                Text("go back")
            }
        }
    }
}