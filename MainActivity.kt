/*Kegomoditswe Leshope - 219189048
   MainActivity.kt
   10 April 2022
 */

package za.ac.cput.assignment2
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Welcome()
                    MainContent()
                    //MainContent2()
                }
        }
    }
}

@Composable
fun Welcome() {
    Text(
        text = "Welcome to My Jetpack Compose Journey",
        fontSize = 22.sp,
        color = Color.Blue,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAF9ED))
            .padding(16.dp)
            .wrapContentSize(Alignment.Center)
            .wrapContentWidth(Alignment.CenterHorizontally)
            .wrapContentHeight(Alignment.CenterVertically),
        textAlign = TextAlign.Center
    )
}

//Button
@Composable
fun MainContent() {
    val visible:MutableState<Boolean> = remember { mutableStateOf(false)}

    ShowDialog(visible = visible)

    Box(
        Modifier
            .fillMaxSize()
            .padding(24.dp), Alignment.BottomEnd){
        TextButton(onClick = { visible.value = true }) {
            Text(text = "INFO")
        }
    }
}

@Composable
fun ShowDialog(visible:MutableState<Boolean>){
    if(visible.value){
        AlertDialog(
            onDismissRequest = {visible.value = false },
            dismissButton = {
                TextButton(onClick = { visible.value = false }) {
                    Text(text = "Cancel")
                }
            },
            confirmButton = {
                TextButton(onClick = { visible.value = false }) {
                    Text(text = "OK")
                }
            },
            title = {Text(text = "Kegomoditswe Leshope" )},
            text = {Text(text = " Mobile Programming 2 , one of the best modules. Thou a bit challenging but the learning process has been nothing but fun. Having started withh a new language, although it seemed challenging at first, but it sure has been fun learning new concepts. I hope for this year to be an amazing year,and that I achieve the best marks. ")}
        )
    }
}

/*@Cposable
fun MainContent2(){
    Box(Modifier.fillMaxSize(),Alignment.Center){
       Button(onClick = {  },
           shape = RoundedCornerShape(12.dp)
       ) {
           Icon(imageVector = Icons.Filled.Favorite,
               contentDescription = "",
               tint = Color.Blue,
               modifier = Modifier.padding(
                   ButtonDefaults.IconSpacing
               )
           )
           Text(text = "Info")

       }
    }
}*/



@Preview
@Composable
fun ComposablePreview() {
    Welcome()
    MainContent()
    //ShowDialog()

}