package com.example.androiddemo

import android.os.Bundle
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddemo.ui.theme.AndroidDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            BusinessCard(navController)
        }
        composable("second") {
            DiceRollerApp(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                navController = navController
            )
        }
        composable("lemonade") {
            Lemonade(
                navController = navController
            )
        }
    }
}

@Composable
fun BusinessCard(navController: NavHostController) {

    val image = painterResource(id = R.drawable.android_logo)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFd3e7d4))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .width(150.dp)
                    .background(Color(0xFF082f42))
            )
            Text(
                "Wonbeen Lee",
                fontWeight = FontWeight.W300,
                fontSize = 40.sp,
                modifier = Modifier
                    .padding(10.dp)
            )
            Text(
                "Android Developer Extraordinaire",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0b6c38)
            )
        }

        Spacer(modifier = Modifier.height(150.dp))

        Column {
            infoRow(
                icon = Icons.Filled.Call,
                content = "010-3856-8436",
            )
            infoRow(
                icon = Icons.Filled.Share,
                content = "@AndroidDev"
            )
            infoRow(
                icon = Icons.Filled.Email,
                content = "leewonbeen@gmail.com"
            )
        }

        Button(onClick = { navController.navigate("second") }) {
            Text(text = "Go to DiceRoller")
        }
        Button(onClick = { navController.navigate("lemonade") }) {
            Text(text = "Go to Lemonade")
        }
    }
}
@Composable
fun infoRow(icon: ImageVector, content: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            icon,
            tint = Color(0xFF016d3b),
            contentDescription = null,
            modifier = Modifier.padding(10.dp)
        )
        Text(content)
    }
}

@Composable
fun DiceRollerApp(modifier: Modifier = Modifier, navController: NavHostController) {

    // remember 컴포저블을 이용해 컴포지션 객체를 메모리에 저장
    // mutableStateOf() 함수로 UI를 새로고침하여 observable을 만듦
    var result by remember { mutableStateOf(1) }

    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = "1"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result = (1..6).random() }) {
            Text("Roll")
        }

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Go Back")
        }
    }
}

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

            Button(onClick = { navController.popBackStack() }) {
                Text("go back")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidDemoTheme {
        Lemonade(navController = rememberNavController())
    }
}