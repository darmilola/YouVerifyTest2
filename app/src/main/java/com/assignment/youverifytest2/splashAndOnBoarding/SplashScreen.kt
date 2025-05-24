package com.assignment.youverifytest2.splashAndOnBoarding

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.assignment.youverifytest2.R
import com.assignment.youverifytest2.ui.theme.YouVerifyTest2Theme
import kotlinx.coroutines.delay

class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            YouVerifyTest2Theme {
                SplashScreenBackground()
                LaunchedEffect(key1 = true) {
                    delay(3000L)
                    startActivity(Intent(this@SplashScreen, OnBoardingActivity::class.java))
                }
            }
        }
    }
}

@Composable
fun SplashScreenBackground() {
    val bgStyle = Modifier
        .fillMaxWidth()
        .fillMaxHeight()

    Row(verticalAlignment = Alignment.CenterVertically, modifier = bgStyle) {
        gradientBlock()
    }
}

@Composable
fun gradientBlock() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        Color.Blue
                    )
                )
            )
    ) {
    }
}