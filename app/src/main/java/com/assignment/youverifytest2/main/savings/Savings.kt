package com.assignment.youverifytest2.main.savings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.assignment.youverifytest2.R

@Composable
fun Savings(
    onCreateSavingsClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            Image(
                painter = painterResource(R.drawable.cupcake),
                contentDescription = null,
                modifier = Modifier.width(300.dp)
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            Text(
                text = "Savings",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
        }
        Column(
            modifier = Modifier.fillMaxWidth().height(300.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(id = R.dimen.padding_medium)
            )
        ) {
            Box(modifier = Modifier.fillMaxWidth().height(100.dp)) {
                Button(
                    onClick = {
                        onCreateSavingsClicked()
                    },
                    modifier = modifier.widthIn(min = 250.dp)
                ) {
                    Text("Create A Savings Goal")
                }
            }
        }
    }
}