package com.example.androiddemo.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.androiddemo.R

@Composable
fun BusinessCard(navController: NavHostController) {

    val image = painterResource(id = R.drawable.android_logo)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
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
        Button(onClick = { navController.navigate("tipcalculator") }) {
            Text(text = "Go to TipCalculator")
        }
        Button(onClick = { navController.navigate("artspace") }) {
            Text(text = "Go to ArtSpace")
        }
        Button(onClick = { navController.navigate("affirmation") }) {
            Text(text = "Go to Affirmation")
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
