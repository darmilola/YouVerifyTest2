package com.assignment.youverifytest2.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.assignment.youverifytest2.R
import com.assignment.youverifytest2.accountSetup.GettingStarted
import com.assignment.youverifytest2.main.account.AccountScreen
import com.assignment.youverifytest2.main.budget.BudgetScreen
import com.assignment.youverifytest2.main.expenses.ExpensesScreen
import com.assignment.youverifytest2.main.home.HomeScreen
import com.assignment.youverifytest2.main.savings.SavingsScreen
import com.assignment.youverifytest2.ui.theme.YouVerifyTest2Theme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YouVerifyTest2Theme {
                MainScreen()
            }
        }
    }
}

sealed class BottomBarScreen(
    val title: String,
    val icon: Int,
    val description: String,
    val page: Int
) {
    object Home : BottomBarScreen(
        title = "Home",
        icon = R.drawable.home_icon,
        description = "",
        page = 0
    )

    object Budget : BottomBarScreen(
        title = "Budget",
        icon = R.drawable.budget_icon,
        description = "",
        page = 1
    )

    object Savings : BottomBarScreen(
        title = "Savings",
        icon = R.drawable.savings_icon,
        description = "",
        page = 2
    )

    object Expenses : BottomBarScreen(
        title = "Expenses",
        icon = R.drawable.expenses_icon,
        description = "",
        page = 3
    )

    object Account : BottomBarScreen(
        title = "Account",
        icon = R.drawable.account_icon,
        description = "",
        page = 4
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BottomNavGraph(
    pagerState: PagerState
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        HorizontalPager(
            state = pagerState
        ) { page ->
            when (page) {
                0 -> HomeScreen()
                1 -> BudgetScreen()
                2 -> SavingsScreen()
                3 -> ExpensesScreen()
                4 -> AccountScreen()
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen() {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Budget,
        BottomBarScreen.Savings,
        BottomBarScreen.Expenses,
        BottomBarScreen.Account,
    )

    val pagerState = PagerState(pageCount = screens.size)

    Scaffold(
        bottomBar = { BottomBar(pagerState = pagerState, screens = screens) }
    ) { innerPaddingValues ->
        Box(
            modifier = Modifier.padding(innerPaddingValues)
        ) {
            BottomNavGraph(pagerState = pagerState)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BottomBar(
    pagerState: PagerState,
    screens: List<BottomBarScreen>
) {
    Row(
        modifier = Modifier
            .height(80.dp)
            .background(Color.Black)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                pagerState = pagerState
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AddItem(
    screen: BottomBarScreen,
    pagerState: PagerState
) {
    val coroutineScope = rememberCoroutineScope()
    val selected = pagerState.currentPage == screen.page
    val tint = if (selected) Color.Magenta else Color.White

    Box(
        modifier = Modifier
            .height(60.dp)
            .clickable(
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(screen.page)
                    }
                }
            )
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(screen.icon),
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = tint),
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = screen.title,
                color = tint
            )
        }
    }
}

