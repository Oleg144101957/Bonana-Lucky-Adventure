package music.musicplayluck.ttr.ui.theme.dest

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import music.musicplayluck.ttr.MainActivity
import music.musicplayluck.ttr.R
import music.musicplayluck.ttr.ui.theme.viewmodels.BananViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Nav4(n: NavHostController, bananViewModel: BananViewModel){

    //settings
    val context = LocalContext.current
    val shared = context.getSharedPreferences(MainActivity.SHARED_PREF_NAME, Context.MODE_PRIVATE)
    val nameFromShared = shared.getString(MainActivity.GAMER_NAME, "true_gamer") ?: "true_gamer"

    val name = remember {
        mutableStateOf(nameFromShared)
    }


    Box(modifier = Modifier.fillMaxSize()){

        Image(
            painter = painterResource(id = R.drawable.background2),
            contentDescription = "back",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = "Write your name",
            color = Color.Black,
            fontSize = 32.sp,
            style = TextStyle(fontWeight = FontWeight(800)),
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-64).dp)
        )

        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "go back",
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(32.dp)
                .clickable {
                    n.navigate(MainActivity.NAV2)
                }
        )

        TextField(
            value = name.value,
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(0.7f),
            onValueChange = {
                name.value = it
                shared.edit().putString(MainActivity.GAMER_NAME, it).apply()
            }
        )
    }
}