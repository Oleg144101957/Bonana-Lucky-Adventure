package music.musicplayluck.ttr.ui.theme.mainfile

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import music.musicplayluck.ttr.MainActivity
import music.musicplayluck.ttr.ui.theme.dest.Nav1
import music.musicplayluck.ttr.ui.theme.dest.Nav2
import music.musicplayluck.ttr.ui.theme.dest.Nav3
import music.musicplayluck.ttr.ui.theme.dest.Nav4
import music.musicplayluck.ttr.ui.theme.viewmodels.BananViewModel


@Composable
fun NavigationGraph(bananViewModel: BananViewModel){

    val n = rememberNavController()

    NavHost(navController = n, startDestination = MainActivity.NAV1){
        composable(route = MainActivity.NAV1){
            Nav1(n = n, bananViewModel = bananViewModel)
        }

        composable(route = MainActivity.NAV2){
            Nav2(n = n, bananViewModel = bananViewModel)
        }

        composable(route = MainActivity.NAV3){
            Nav3(n = n, bananViewModel = bananViewModel)
        }

        composable(route = MainActivity.NAV4){
            Nav4(n = n, bananViewModel = bananViewModel)
        }
    }
}