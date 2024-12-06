package lab.uro.kitori.learning.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector

sealed interface AppNavigationBarItem<T : Any> {
    val route: T
    val icon: ImageVector
    val label: String
}

@Immutable
data object HomeBottomBarElement : AppNavigationBarItem<HomeRoute> {
    override val route: HomeRoute = HomeRoute
    override val icon: ImageVector = Icons.Default.Home
    override val label: String = "home"
}

@Immutable
data object HomeDummy1BottomBarElement : AppNavigationBarItem<HomeDummy1Route> {
    override val route: HomeDummy1Route = HomeDummy1Route
    override val icon: ImageVector = Icons.Default.Star
    override val label: String = "dummy1"
}

@Immutable
data object HomeDummy2BottomBarElement : AppNavigationBarItem<HomeDummy2Route> {
    override val route: HomeDummy2Route = HomeDummy2Route
    override val icon: ImageVector = Icons.Default.Menu
    override val label: String = "dummy2"
}
