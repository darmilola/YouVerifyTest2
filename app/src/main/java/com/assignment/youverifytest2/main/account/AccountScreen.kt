package com.assignment.youverifytest2.main.account

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
import com.assignment.youverifytest2.main.expenses.Expenses
import com.assignment.youverifytest2.main.expenses.SortTransactions
import com.assignment.youverifytest2.main.expenses.Transactions

enum class AccountScreen {
    Account
}


@Composable
fun AccountScreen(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = {}
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AccountScreen.Account.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = AccountScreen.Account.name) {
                Account(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }

        }

    }
}
