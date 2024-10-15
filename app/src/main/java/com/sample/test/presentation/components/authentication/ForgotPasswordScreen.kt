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
fun ForgotPasswordScreen(
    modifier: Modifier = Modifier,
    forgotPassword: () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            forgotPassword()
        }) {
            Text(text = stringResource(id = R.string.forgot_password))
        }
    }
}