package com.assignment.youverifytest2.main.savings

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
import com.assignment.youverifytest2.main.budget.BudgetCreatedSuccessfully

enum class SavingsScreen {
    Savings,
    CreateSavingsPage1,
    CreateSavingsPage2,
    CreateSavingsPage3,
    SavingsPreview,
    SavingsCreatedSuccessfully
}

@Composable
fun SavingsScreen(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = {}
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = SavingsScreen.Savings.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = SavingsScreen.Savings.name) {
                Savings(
                    onCreateSavingsClicked = {
                        navController.navigate(SavingsScreen.CreateSavingsPage1.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = SavingsScreen.CreateSavingsPage1.name) {
                CreateSavingsPage1(
                    onNextClicked = {
                        navController.navigate(SavingsScreen.CreateSavingsPage2.name)
                    },
                    onBackButtonPressed = {
                        navController.navigateUp()
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = SavingsScreen.CreateSavingsPage2.name) {
                CreateSavingsPage2(
                    onNextClicked = {
                        navController.navigate(SavingsScreen.CreateSavingsPage3.name)
                    },
                    onBackButtonPressed = {
                        navController.navigateUp()
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = SavingsScreen.CreateSavingsPage3.name) {
                CreateSavingsPage3(
                    onNextClicked = {
                        navController.navigate(SavingsScreen.SavingsPreview.name)
                    },
                    onBackButtonPressed = {
                        navController.navigateUp()
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = SavingsScreen.SavingsPreview.name) {
                SavingsPreview(
                    onCreateSavingsClicked = {
                        navController.navigate(SavingsScreen.SavingsCreatedSuccessfully.name)
                    },
                    onBackButtonPressed = {
                        navController.navigateUp()
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = SavingsScreen.SavingsCreatedSuccessfully.name) {
                SavingsCreatedSuccessfully(
                    onEditGoalClicked = {
                        navController.popBackStack(SavingsScreen.Savings.name, inclusive = false)
                    },
                    onBackButtonPressed = {
                        navController.popBackStack(SavingsScreen.Savings.name, inclusive = false)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
        }

    }
}