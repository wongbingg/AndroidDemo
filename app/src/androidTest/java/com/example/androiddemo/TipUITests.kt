package com.example.androiddemo

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.rememberNavController
import com.example.androiddemo.ui.theme.AndroidDemoTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test // 계측 테스트를 나타낸다. (test 디렉토리의 @Test 는 로컬테스트를 의미함)
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            AndroidDemoTheme {
                TipCalculator(navController = rememberNavController())
            }
        }
        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10") // TextField 컴포저블을 채운다.
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")

        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
            "No node with this text was found"
        )
    }
}

