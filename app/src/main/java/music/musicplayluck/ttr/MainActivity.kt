package music.musicplayluck.ttr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import music.musicplayluck.ttr.ui.theme.BananfsAdventureTheme
import music.musicplayluck.ttr.ui.theme.mainfile.NavigationGraph
import music.musicplayluck.ttr.ui.theme.viewmodels.BananViewModel

class MainActivity : ComponentActivity() {

    val bananViewModel by viewModels<BananViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BananfsAdventureTheme {
                // A surface container using the 'background' color from the theme
                NavigationGraph(bananViewModel)
            }
        }
    }

    companion object{
        const val NAV1 = "NAV1"
        const val NAV2 = "NAV2"
        const val NAV3 = "NAV3"
        const val NAV4 = "NAV4"
        const val SHARED_PREF_NAME = "SHARED_PREF_NAME"
        const val GAMER_NAME = "GAMER_NAME"
    }
}
