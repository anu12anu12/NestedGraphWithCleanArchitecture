package com.sample.test.presentation.components.authentication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.sample.test.R

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    loginClicked: () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            loginClicked()
        }) {
            Text(text = stringResource(id = R.string.login))
        }

        ForgotPasswordScreen(
            modifier = Modifier
        ) {

        }
    }
}