package com.example.dicerollerapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dicerollerapp.ui.theme.DiceRollerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerAppTheme {
                DiceRollerApp()
            }
        }
    }
}
@Preview
@Composable
fun DiceRollerApp(){
    DiceWithImageAndButton(modifier= Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}

@Composable
fun DiceWithImageAndButton(modifier:Modifier=Modifier){
    var result by remember{
        mutableStateOf(0)
    }
    val imageResource=when(result){
        0->R.drawable.dice_1
        1->R.drawable.dice_1
        2->R.drawable.dice_2
        3->R.drawable.dice_3
        4->R.drawable.dice_4
        5->R.drawable.dice_5
        else->R.drawable.dice_6
    }
    Column(modifier=modifier,
    horizontalAlignment = Alignment.CenterHorizontally){
        if (result!=0) {
            Text(text = "You rolled $result !", fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
        }
        Image(painter= painterResource(imageResource),contentDescription=result.toString())
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {result=(1..6).random()}) {
            Text(text = stringResource(R.string.roll), fontSize = 24.sp, color = Color.White)
        }
        Spacer(modifier = Modifier.height(100.dp))
        Text(text= stringResource(R.string.madeby), fontSize = 20.sp , fontWeight = FontWeight(200))
        Spacer(modifier = Modifier.height(16.dp))
        Text(text=stringResource(R.string.chaitanya), fontSize = 20.sp, fontWeight = FontWeight(500))

    }
}