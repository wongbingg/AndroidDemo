package com.example.androiddemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddemo.ui.theme.AndroidDemoTheme
import com.example.androiddemo.views.ArtSpace
import com.example.androiddemo.views.BusinessCard
import com.example.androiddemo.views.DiceRollerApp
import com.example.androiddemo.views.Lemonade
import com.example.androiddemo.views.TipCalculator

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
        composable("tipcalculator") {
            TipCalculator(
                navController = navController
            )
        }
        composable("artspace") {
            ArtSpace(
                navController = navController
            )
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
            MainScreen()
        }
    }
}