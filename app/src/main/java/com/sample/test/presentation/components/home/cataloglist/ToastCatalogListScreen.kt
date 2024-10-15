package com.sample.test.presentation.components.home.cataloglist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.sample.test.domain.models.ToastEntity
import com.sample.test.presentation.components.shared.LoadingScreen

@Composable
fun ToastCatalogListScreen(
    modifier: Modifier = Modifier,
    catalogList: List<ToastEntity>,
    isLoading: Boolean
) {
    if (isLoading) {
        LoadingScreen(modifier = modifier.fillMaxSize())
    } else {
        LazyColumn(
            modifier = modifier.fillMaxSize()
        ) {
            items(
                key = {it.id},
                items = catalogList,
                itemContent = {
                    Text(text = it.name?: "", color = Color.Black)
                }
            )
        }
    }
}