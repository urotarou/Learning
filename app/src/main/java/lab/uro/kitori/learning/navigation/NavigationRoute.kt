package lab.uro.kitori.learning.navigation

import kotlinx.serialization.Serializable

sealed interface NavigationRoute

// Home
@Serializable
data object HomeRoute : NavigationRoute

// Menu
@Serializable
data object MenuRoute : NavigationRoute
