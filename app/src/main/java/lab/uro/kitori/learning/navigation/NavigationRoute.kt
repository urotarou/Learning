package lab.uro.kitori.learning.navigation

import kotlinx.serialization.Serializable

sealed interface NavigationRoute

@Serializable
data object HomeRoute : NavigationRoute

@Serializable
data object HomeDummy1Route : NavigationRoute

@Serializable
data object HomeDummy2Route : NavigationRoute
