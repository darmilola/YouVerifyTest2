package com.assignment.youverifytest2.main.budget

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
import com.assignment.youverifytest2.main.home.Home
import com.assignment.youverifytest2.main.home.HomeScreen
import com.assignment.youverifytest2.main.home.InsightAndReport
import com.assignment.youverifytest2.main.home.LinkedBankAccount

enum class BudgetScreen {
    Budgets,
    CreateBudgetPage1,
    CreateBudgetPage2,
    BudgetPreview,
    BudgetCreatedSuccessfully
}

@Composable
fun BudgetScreen(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = {}
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BudgetScreen.Budgets.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = BudgetScreen.Budgets.name) {
                Budgets(
                    onCreateBudgetClicked = {
                        navController.navigate(BudgetScreen.CreateBudgetPage1.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = BudgetScreen.CreateBudgetPage1.name) {
                CreateBudgetPage1(
                    onNextClicked = {
                        navController.navigate(BudgetScreen.CreateBudgetPage2.name)
                    },
                    onBackButtonPressed = {
                        navController.navigateUp()
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = BudgetScreen.CreateBudgetPage2.name) {
                CreateBudgetPage2(
                    onNextClicked = {
                        navController.navigate(BudgetScreen.BudgetPreview.name)
                    },
                    onBackButtonPressed = {
                        navController.navigateUp()
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = BudgetScreen.BudgetPreview.name) {
                BudgetPreview(
                    onCreateBudgetClicked = {
                        navController.navigate(BudgetScreen.BudgetCreatedSuccessfully.name)
                    },
                    onBackButtonPressed = {
                        navController.navigateUp()
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = BudgetScreen.BudgetCreatedSuccessfully.name) {
                BudgetCreatedSuccessfully(
                    onEditBudgetClicked = {
                        navController.popBackStack(BudgetScreen.Budgets.name, inclusive = false)
                    },
                    onBackButtonPressed = {
                        navController.popBackStack(BudgetScreen.Budgets.name, inclusive = false)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
        }

    }
}