package com.sample.test.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screens {
    @Serializable
    object Auth {
        @Serializable
        object LoginScreen

        @Serializable
        object RegistrationScreen

        @Serializable
        object ForgotPasswordScreen
    }

    @Serializable
    object Home {
        @Serializable
        object CatalogListScreen

        @Serializable
        object CatalogDetailsScreen
    }
}