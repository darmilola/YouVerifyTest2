package com.assignment.youverifytest2.signUpAndVerifications

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.assignment.youverifytest2.R
import com.assignment.youverifytest2.accountSetup.AccountSetup
import com.assignment.youverifytest2.splashAndOnBoarding.OnBoardingScreen
import com.assignment.youverifytest2.splashAndOnBoarding.OnBoardingScreen1
import com.assignment.youverifytest2.splashAndOnBoarding.OnBoardingScreen2
import com.assignment.youverifytest2.splashAndOnBoarding.OnBoardingScreen3
import com.assignment.youverifytest2.ui.theme.YouVerifyTest2Theme

class SignupActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            YouVerifyTest2Theme {
                SignUpScreen(onNextButtonClicked = {
                    startActivity(Intent(this@SignupActivity, AccountSetup::class.java))
                })
            }
        }
    }
}

enum class SignUpScreen {
    ProvideDetails,
    Verify
}

@Composable
fun SignUpScreen(
    navController: NavHostController = rememberNavController(),
    onNextButtonClicked:() -> Unit
) {

    Scaffold(
        topBar = {}
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = SignUpScreen.ProvideDetails.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = SignUpScreen.ProvideDetails.name) {
                ProvideDetails(
                    onNextButtonClicked = {
                        navController.navigate(SignUpScreen.Verify.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = SignUpScreen.Verify.name) {
                Verify(
                    onNextButtonClicked = {
                        onNextButtonClicked()
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
        }

    }
}