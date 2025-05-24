package com.assignment.youverifytest2.splashAndOnBoarding

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.assignment.youverifytest2.R
import com.assignment.youverifytest2.signUpAndVerifications.SignupActivity
import com.assignment.youverifytest2.ui.theme.YouVerifyTest2Theme

class OnBoardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            YouVerifyTest2Theme {
                OnBoardingScreen(onCreateAccount = {
                    startActivity(Intent(this@OnBoardingActivity, SignupActivity::class.java))
                })
            }
        }
    }
}

enum class OnBoardingScreen {
    OnBoardingScreen1,
    OnBoardingScreen2,
    OnBoardingScreen3,
}

@Composable
fun OnBoardingScreen(
    navController: NavHostController = rememberNavController(),
    onCreateAccount: () -> Unit
) {

    Scaffold(
        topBar = {}
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = OnBoardingScreen.OnBoardingScreen1.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = OnBoardingScreen.OnBoardingScreen1.name) {
                OnBoardingScreen1(
                    onNextButtonClicked = {
                        navController.navigate(OnBoardingScreen.OnBoardingScreen2.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = OnBoardingScreen.OnBoardingScreen2.name) {
                OnBoardingScreen2(
                    onNextButtonClicked = {
                        navController.navigate(OnBoardingScreen.OnBoardingScreen3.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = OnBoardingScreen.OnBoardingScreen3.name) {
                OnBoardingScreen3(
                    onCreateAccount = {
                      onCreateAccount()
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
        }

    }
}