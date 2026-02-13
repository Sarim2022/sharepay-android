package com.example.sharepay_

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sharepay_.AuthScreen.LoginScreen
import com.example.sharepay_.AuthScreen.SharePaySplashScreen
import com.example.sharepay_.AuthScreen.SignUpScreen
import com.example.sharepay_.onBoardScreen.HomedashBoard
import com.example.sharepay_.ui.theme.Sharepay_Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sharepay_Theme {
            SharePayApp()
            }
        }
    }
}

@Composable
fun SharePayApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SharePaySplashScreen(onTimeout = {
                navController.navigate("login") { popUpTo("splash") { inclusive = true } }
            })
        }
        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate("home") { popUpTo("login") { inclusive = true } }
                },
                onSignUpClick = { navController.navigate("signup") },
                onForgotPassClick = { /* Logic */ }
            )
        }
        composable("signup") {
            SignUpScreen(
                onLoginClick = { navController.popBackStack() }
            )
        }
        composable("home") {
            HomedashBoard(onTimeout = { /* Can be used for logout if needed */ })
        }
    }
}