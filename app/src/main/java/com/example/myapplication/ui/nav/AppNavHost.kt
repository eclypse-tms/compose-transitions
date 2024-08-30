package com.example.myapplication.ui.nav

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.screen.Screen1
import com.example.myapplication.ui.screen.Screen2
import com.example.myapplication.ui.screen.Screen3

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String,
) {
    NavHost(navController = navController,
        startDestination = startDestination) {

        navGraph(route = AppDestinations.Screen1.name) { navBackStackEntry ->
            Screen1(
                goToScreen2 = { navController.navigate(AppDestinations.Screen2.name) },
            )
        }

        navGraph(route = AppDestinations.Screen2.name) { navBackStackEntry ->
            Screen2(
                goToScreen1 = { navController.popBackStack() },
                goToScreen3 = { navController.navigate(AppDestinations.Screen3.name) }
            )
        }

        navGraph(route = AppDestinations.Screen3.name) { navBackStackEntry ->
            Screen3(
                goToScreen2 = { navController.popBackStack() }
            )
        }
    }
}

object TransitionAnimation {
    const val DURATION: Int = 1000
}

fun NavGraphBuilder.navGraph(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    this@navGraph.composable(route = route,
        arguments = arguments,
        deepLinks = deepLinks,
        enterTransition = {
            // slideIn(tween(TransitionAnimation.DURATION)) { IntOffset(it.width, 0) }
            // or
            slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Start, animationSpec = tween(TransitionAnimation.DURATION))
        },
        exitTransition = {
            fadeOut(tween(TransitionAnimation.DURATION))
        },
        popEnterTransition = {
            fadeIn(tween(TransitionAnimation.DURATION))
        },
        popExitTransition = {
            // slideOut(tween(TransitionAnimation.DURATION)) { IntOffset(it.width, 0) }
            // or
            slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.End, animationSpec = tween(TransitionAnimation.DURATION))
        },
        content = content)
}