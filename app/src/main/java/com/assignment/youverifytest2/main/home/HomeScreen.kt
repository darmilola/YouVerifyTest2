package com.assignment.youverifytest2.main.home

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
import com.assignment.youverifytest2.signUpAndVerifications.ProvideDetails
import com.assignment.youverifytest2.signUpAndVerifications.Verify

enum class HomeScreen {
    Home,
    InsightAndReport,
    LinkedBankAccount
}

@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = {}
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = HomeScreen.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = HomeScreen.Home.name) {
                Home(
                    onInsightAndReportClicked = {
                        navController.navigate(HomeScreen.InsightAndReport.name)
                    },
                    onLinkedAccountClicked = {
                        navController.navigate(HomeScreen.LinkedBankAccount.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = HomeScreen.InsightAndReport.name) {
                InsightAndReport(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium)),
                    onBackButtonPressed = {
                        navController.navigateUp()
                    }
                )
            }
            composable(route = HomeScreen.LinkedBankAccount.name) {
                LinkedBankAccount(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium)),
                    onBackButtonPressed = {
                        navController.navigateUp()
                    }
                )
            }
        }

    }
}