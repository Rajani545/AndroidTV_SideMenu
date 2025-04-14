package ca.knowledge.kapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay

class SplashActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreen()
        }
    }

    @Preview
    @Composable
    private fun SplashScreen() {
        val systemUiController = rememberSystemUiController()
        systemUiController.setStatusBarColor(
            color = Color(0xFF141414),
            darkIcons = false
        )
        systemUiController.setNavigationBarColor(
            color = Color(0xFF141414),
            darkIcons = false
        )
        MaterialTheme {
            LaunchedEffect(key1 = false) {
                delay(2000)
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Color(0xFF141414)
                    ), contentAlignment = Alignment.Center
            ) {
                Image(painter = painterResource(id = R.drawable.ic_home), contentDescription = null)
            }
        }
    }
}