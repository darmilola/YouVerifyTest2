package com.assignment.youverifytest2.main.expenses

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
import com.assignment.youverifytest2.main.budget.BudgetPreview
import com.assignment.youverifytest2.main.budget.Budgets
import com.assignment.youverifytest2.main.budget.CreateBudgetPage1
import com.assignment.youverifytest2.main.budget.CreateBudgetPage2

enum class ExpensesScreen {
    Expenses,
    Transactions,
    SortTransactions
}


@Composable
fun ExpensesScreen(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = {}
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ExpensesScreen.Expenses.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = ExpensesScreen.Expenses.name) {
                Expenses(
                    onViewTransactionsClicked = {
                        navController.navigate(ExpensesScreen.Transactions.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = ExpensesScreen.Transactions.name) {
                Transactions(
                    onSortTransactionClicked = {
                        navController.navigate(ExpensesScreen.SortTransactions.name)
                    },
                    onBackButtonPressed = {
                        navController.navigateUp()
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = ExpensesScreen.SortTransactions.name) {
                SortTransactions(
                    onBackButtonPressed = {
                        navController.navigateUp()
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }

        }

    }
}