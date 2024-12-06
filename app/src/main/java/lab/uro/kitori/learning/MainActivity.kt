package lab.uro.kitori.learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import lab.uro.kitori.home.screen.HomeScreen
import lab.uro.kitori.learning.navigation.HomeBottomBarElement
import lab.uro.kitori.learning.navigation.HomeRoute
import lab.uro.kitori.learning.navigation.MenuBottomBarElement
import lab.uro.kitori.learning.navigation.MenuRoute
import lab.uro.kitori.learning.ui.theme.LearningTheme

private val topLevelRoutes = listOf(
    HomeBottomBarElement,
    MenuBottomBarElement,
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningTheme {
                val navController: NavHostController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar {
                            topLevelRoutes.forEach { route ->
                                val isSelected = currentDestination?.hierarchy?.any {
                                    it.hasRoute(route.route::class)
                                } == true

                                NavigationBarItem(
                                    selected = isSelected,
                                    onClick = {
                                        navController.navigate(route = route.route) {
                                            popUpTo(id = navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = route.icon,
                                            contentDescription = route.label,
                                        )
                                    },
                                    label = {
                                        Text(text = route.label)
                                    },
                                )
                            }
                        }
                    },
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = HomeRoute,
                        modifier = Modifier.padding(innerPadding),
                    ) {
                        composable<HomeRoute> {
                            HomeScreen()
                        }
                        composable<MenuRoute> {
                            Scaffold(modifier = Modifier.fillMaxSize()) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(it),
                                    contentAlignment = Alignment.Center,
                                ) {
                                    Text(text = "menu")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
