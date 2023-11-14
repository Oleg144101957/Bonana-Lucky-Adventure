package music.musicplayluck.ttr.ui.theme.dest

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import music.musicplayluck.ttr.MainActivity
import music.musicplayluck.ttr.R
import music.musicplayluck.ttr.ui.theme.viewmodels.BananViewModel
import kotlin.system.exitProcess

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Nav2(n: NavHostController, bananViewModel: BananViewModel){


    val context = LocalContext.current


    Box(modifier = Modifier.fillMaxSize()){

        Image(
            painter = painterResource(id = R.drawable.background2),
            contentDescription = "back",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        FlowColumn(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(bottom = 196.dp)
        ){

            Box {
                Image(
                    painter = painterResource(id = R.drawable.text),
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clickable {
                            n.navigate(MainActivity.NAV3)
                        }
                )

                Text(
                    text = "Play",
                    color = Color.Black,
                    fontSize = 24.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Box {
                Image(
                    painter = painterResource(id = R.drawable.text),
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clickable {
                            n.navigate(MainActivity.NAV4)
                        }
                )

                Text(
                    text = "Settings",
                    color = Color.Black,
                    fontSize = 24.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Box {
                Image(
                    painter = painterResource(id = R.drawable.text),
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clickable {
                            val intent = Intent(Intent.ACTION_MAIN)
                            intent.addCategory(Intent.CATEGORY_HOME)
                            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                            context.startActivity(intent)
                            (context as? Activity)?.finish()
                            exitProcess(0)
                        }
                )

                Text(
                    text = "Exit",
                    color = Color.Black,
                    fontSize = 24.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}