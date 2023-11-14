package music.musicplayluck.ttr.ui.theme.dest

import android.content.Context
import android.graphics.Paint.Align
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import music.musicplayluck.ttr.MainActivity
import music.musicplayluck.ttr.R
import music.musicplayluck.ttr.ui.theme.viewmodels.BananViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Nav3(n: NavHostController, bananViewModel: BananViewModel){


    val selectButtonOffsetY = remember {
        Animatable(0f)
    }

    LaunchedEffect(Unit){
        bananViewModel.initAspects()
    }

    LaunchedEffect(Unit){
        repeat(2){
            selectButtonOffsetY.animateTo(-46f, tween(350, easing = LinearOutSlowInEasing))
            selectButtonOffsetY.animateTo(0f, tween(350, easing = FastOutSlowInEasing))
        }
    }
    
    val context = LocalContext.current
    val shared = context.getSharedPreferences(MainActivity.SHARED_PREF_NAME, Context.MODE_PRIVATE)
    val nameFromShared = shared.getString(MainActivity.GAMER_NAME, "gamer") ?: "gamer"

    val aspects = bananViewModel.aspects.observeAsState()
    val coins = bananViewModel.coins.observeAsState()


    //Game

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background2),
            contentDescription = "back",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = "Hello dear $nameFromShared",
            color = Color.Black,
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.TopCenter)
        )


        Box(modifier = Modifier
            .fillMaxWidth(0.5f)
            .fillMaxHeight(0.07f)
            .align(Alignment.TopCenter)
            .padding(top = 32.dp)
            .background(Color.Black.copy(alpha = 0.5f))
        ){

            Text(
                text = "Your score $coins",
                color = Color.White,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }


        FlowRow(modifier = Modifier
            .offset(y = 128.dp)
            .align(Alignment.TopCenter)
        ) {

            aspects.value?.forEach {
                if (it.isTop.isTop){
                    Box(modifier = Modifier.size(96.dp)){
                        Image(
                            painter = painterResource(id = it.image),
                            contentDescription = "top",
                            modifier = Modifier
                                .align(Alignment.Center)
                        )
                    }
                }else {

                } }
        }

        Box(modifier = Modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight(0.35f)
            .align(Alignment.Center)
            .background(Color.Black.copy(alpha = 0.75f))
        ){

            FlowRow(
                maxItemsInEachRow = 5,
                horizontalArrangement = Arrangement.Center,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .align(Alignment.Center)
            ){
                aspects.value?.forEach { 
                    Box(modifier = Modifier
                        .padding(2.dp)
                        .size(64.dp)
                        .border(
                            5.dp,
                            if (it.isSelected.isSelected) Color.White else Color.White.copy(alpha = 0f)
                        )
                    ){
                        Image(
                            painter = painterResource(id = if (it.isOpened.isOpened) it.image else R.drawable.qw1),
                            contentDescription = "aspect",
                            modifier = Modifier
                                .align(Alignment.Center)
                        )
                    }

                }
            }

        }


        Icon(
            imageVector = Icons.Rounded.KeyboardArrowLeft,
            contentDescription = "left",
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(bottom = 64.dp, start = 16.dp)
                .size(128.dp)
                .clickable {
                    bananViewModel.moveLeft()
                }
        )

        Icon(
            imageVector = Icons.Rounded.KeyboardArrowRight,
            contentDescription = "right",
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 64.dp, end = 16.dp)
                .size(128.dp)
                .clickable {
                    bananViewModel.moveRight()
                }
        )

        Image(
            painter = painterResource(id = R.drawable.qw6),
            contentDescription = "Button select",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 64.dp)
                .offset(y = selectButtonOffsetY.value.dp)
                .clickable {
                    bananViewModel.pressButtonSelect()
                }
        )
    }
}