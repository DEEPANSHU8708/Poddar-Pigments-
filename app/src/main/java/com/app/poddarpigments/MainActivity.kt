package com.app.poddarpigments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.poddarpigments.ui.theme.PoddarPigmentsTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PoddarPigmentsTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun ShowLogo(navController: NavHostController) {
    Box(Modifier.fillMaxSize()) {
        // Use Box to handle full screen
        // Top image centered horizontally with gaps on left and right
        Image(
            painterResource(R.drawable.logo),
            "Poddar Pigments Logo",
            modifier = Modifier
                .align(Alignment.Center) // Align to center of the Box
                .padding(32.dp)

        )
        // Bottom image positioned at the bottom of the screen
        Image(
            painterResource(R.drawable.tagline),
            "Poddar Pigments Tagline",
            modifier = Modifier
                .align(Alignment.BottomCenter) // Align to bottom center of the Box
        )


    }

    LaunchedEffect(Unit) {
        delay(2000) // Wait for 2 seconds
        navController.navigate("home") {
            popUpTo("splash") { inclusive = true } // This clears the back stack
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { ShowLogo(navController) }
        composable("home") { HomeUi() }
    }

}


@Composable
@Preview
fun HomeUi() {
    val uriHandler = LocalUriHandler.current
    val website = "https://www.poddarpigmentsltd.com/"
    val linkedIn =
        "https://www.linkedin.com/company/poddar-pigments-limited/mycompany/?viewAsMember=true"
    val insta = "https://www.instagram.com/poddarpigmentsltd/"
    val fb = "https://www.facebook.com/people/Poddar-pigments/100076247146704/"
    val yt = "https://www.youtube.com/@PoddarPigmentsLimited"
    val dsc = "https://www.poddarpigmentsltd.com/digital-shade-card"
    val cv = "https://youtu.be/2qz4X8DDnf0?si=Dzk5C-8WrP4YudmT"
    val cp = "https://www.poddarpigmentsltd.com/"
    val pv = "https://www.youtube.com/watch?v=KdFyl-RkDMw&list=PLAwcA5pg617QUk1lFnd-Fn3lJ4jhdp9FM"
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painterResource(R.drawable.logo),
                "Poddar Pigments Logo",
                modifier = Modifier
                    .padding(32.dp)
                    .scale(0.5f)

            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Button(onClick = {
                uriHandler.openUri(website)
            }) {
                Text("Website")
            }
            Button(onClick = {
                uriHandler.openUri(linkedIn)
            }) {
                Text("LinkedIn")
            }
            Button(onClick = {
                uriHandler.openUri(insta)
            }) {
                Text("Instagram")
            }
            Button(onClick = {
                uriHandler.openUri(fb)
            }) {
                Text("Facebook")
            }
            Button(onClick = {
                uriHandler.openUri(yt)
            }) {
                Text("Youtube")
            }
            Button(onClick = {
                uriHandler.openUri(dsc)
            }) {
                Text("Digital Shade Card")
            }
            Button(onClick = {
                uriHandler.openUri(cv)
            }) {
                Text("Corporate Video")
            }
            Button(onClick = {
                uriHandler.openUri(cp)
            }) {
                Text("Corporate Presentation")
            }
            Button(onClick = {
                uriHandler.openUri(pv)
            }) {
                Text("Product Videos")
            }
        }
    }

}