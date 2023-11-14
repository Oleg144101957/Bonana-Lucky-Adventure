package music.musicplayluck.ttr.ui.theme.dest

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import music.musicplayluck.ttr.MainActivity
import music.musicplayluck.ttr.R
import music.musicplayluck.ttr.ui.theme.viewmodels.BananViewModel

@Composable
fun Nav1(n: NavHostController, bananViewModel: BananViewModel){

    val rotationF = remember {
        Animatable(0f)
    }

    val l = remember {
        mutableStateOf("Loading")
    }

    LaunchedEffect(Unit){
        rotationF.animateTo(
            targetValue = 360f,
            animationSpec = infiniteRepeatable(
                tween(durationMillis = 1555, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
    }

    LaunchedEffect(Unit){
        delay(2000)
        n.navigate(MainActivity.NAV2)
    }

    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.background1),
            contentDescription = "back",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )


        Image(
            painter = painterResource(id = R.drawable.qw6),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.Center)
                .rotate(rotationF.value)
        )

        Text(
            text = l.value,
            color = Color.Black,
            fontSize = 32.sp,
            style = TextStyle(fontWeight = FontWeight(800)),
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = 128.dp)
        )
    }
}