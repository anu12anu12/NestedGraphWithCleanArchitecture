package com.sample.test.presentation.components.home.catalogdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sample.test.R
import com.sample.test.domain.models.ToastEntity
import com.sample.test.presentation.components.shared.VSpacer

@Composable
fun ToastCatalogDetailsScreen(
    modifier: Modifier = Modifier,
    catalogDetails: ToastEntity
) {
    Column(
        modifier = modifier
    ) {
        catalogDetails.name?.let {
            Text(text = stringResource(id = R.string.details_screen))
            VSpacer(space = 8.dp)
            Text(text = catalogDetails.name)
        }
    }
}