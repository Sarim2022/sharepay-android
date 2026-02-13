package com.example.sharepay_.onBoardScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
fun HomedashBoard(onTimeout: () -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF6200EE)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Welcome",
            color = Color.White,
            fontSize = 42.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 2.sp
        )
    }
}