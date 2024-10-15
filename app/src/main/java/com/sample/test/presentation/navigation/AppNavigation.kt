package com.sample.test.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.sample.test.infrastructure.extensions.sharedViewModel
import com.sample.test.presentation.components.authentication.ForgotPasswordScreen
import com.sample.test.presentation.components.authentication.LoginScreen
import com.sample.test.presentation.components.authentication.RegistrationScreen
import com.sample.test.presentation.components.home.cataloglist.ToastCatalogListScreen
import com.sample.test.presentation.viewmodel.cataloglist.ToastCatalogListViewModel

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.Auth) {
        navigation<Screens.Auth>(startDestination = Screens.Auth.LoginScreen) {
            composable<Screens.Auth.LoginScreen> {
                LoginScreen(
                    modifier = Modifier
                ) {
                    navController.navigate(Screens.Home){
                        popUpTo<Screens.Auth> { inclusive = true }
                    }
                }
            }

            composable<Screens.Auth.RegistrationScreen> {
                RegistrationScreen(
                    modifier = Modifier
                ) {
                    navController.navigate(Screens.Home){
                        popUpTo<Screens.Home> { inclusive = true }
                    }
                }
            }

            composable<Screens.Auth.ForgotPasswordScreen> {
                ForgotPasswordScreen(
                    modifier = Modifier
                ) {
                    navController.popBackStack()
                }
            }
        }

        navigation<Screens.Home>(startDestination = Screens.Home.CatalogListScreen) {
            composable<Screens.Home.CatalogListScreen> {
                val viewModel = hiltViewModel<ToastCatalogListViewModel>()
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                ToastCatalogListScreen(
                    modifier = Modifier,
                    catalogList = uiState.toastList,
                    isLoading = uiState.isLoading
                )
            }

//            composable<Screens.Home.CatalogDetailsScreen> {
//                ToastCatalogDetailsScreen(
//                    modifier = Modifier,
//                    catalogDetails = null
//                )
//            }
        }
    }
}