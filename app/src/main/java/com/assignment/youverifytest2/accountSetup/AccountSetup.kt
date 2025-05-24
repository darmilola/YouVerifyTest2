package com.assignment.youverifytest2.accountSetup

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
import com.assignment.youverifytest2.main.MainActivity
import com.assignment.youverifytest2.R
import com.assignment.youverifytest2.ui.theme.YouVerifyTest2Theme

class AccountSetup : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            YouVerifyTest2Theme {
                AccountSetupScreen(onPinCreated = {
                    startActivity(Intent(this@AccountSetup, MainActivity::class.java))
                })
            }
        }
    }
}

enum class AccountSetupScreen {
    GettingStarted,
    CreateAPin
}

@Composable
fun AccountSetupScreen(
    navController: NavHostController = rememberNavController(),
    onPinCreated:() -> Unit
) {

    Scaffold(
        topBar = {}
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AccountSetupScreen.GettingStarted.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route =  AccountSetupScreen.GettingStarted.name) {
                GettingStarted(
                    skipGettingStarted = {
                        navController.navigate(AccountSetupScreen.CreateAPin.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route =  AccountSetupScreen.CreateAPin.name) {
                CreateAPin(
                    createAPin = {
                        onPinCreated()
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
        }

    }
}