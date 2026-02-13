package com.example.sharepay_.AuthScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun SharePaySplashScreen(onTimeout: () -> Unit) {
    LaunchedEffect(Unit) {
        // Show splash for 1.5 seconds before navigating
        delay(1500)
        onTimeout()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF6200EE)), // Replace with your brand color
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "SharePay",
            color = Color.White,
            fontSize = 42.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 2.sp
        )
    }
}