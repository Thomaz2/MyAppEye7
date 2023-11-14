package com.example.myappeye7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myappeye7.ui.theme.MyAppEye7Theme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppEye7Theme {
                MyAppEye7()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MyAppEye7() {
    var foto by remember { mutableStateOf(1) }
    var idTexto = 1
    var idOriginalName = 1
    var idImagem = 1
    when (foto) {

        1 -> {
            idImagem = R.drawable.freddypng
            idTexto = R.string.freddy
            idOriginalName = R.string.freddykid
        }

        2 -> {
            idImagem = R.drawable.bonnie
            idTexto = R.string.bonnie
            idOriginalName = R.string.bonniekid
        }

        3 -> {
            idImagem = R.drawable.chica
            idTexto = R.string.chica
            idOriginalName = R.string.chicakid
        }

        else -> {
            idImagem = R.drawable.foxy
            idTexto = R.string.foxy
            idOriginalName = R.string.foxykid
        }
    }

    Card(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {


            Image(
                painter = painterResource(id = idImagem),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(end = 15.dp, start = 15.dp)
            )
            Text(
                text = stringResource(idTexto),
                textAlign = TextAlign.Center
            )

            Text(
                text = "nome da alma da criança:" + stringResource(idOriginalName),
                textAlign = TextAlign.Center
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 15.dp, start = 15.dp)
            ) {
                Button(
                    onClick = {
                        if (foto > 0) {
                            foto--
                        } else {
                            foto = 3
                        }
                    },
                    colors = ButtonDefaults.buttonColors(Color.Red),
                ) {
                    Text(
                        text = "Foto Anterior",
                        color = Color.Black
                    )
                }
                Button(
                    onClick = {
                        if (foto < 3) {
                            foto++
                        } else {
                            foto = 0
                        }
                    },
                    colors = ButtonDefaults.buttonColors(Color.Red),
                ) {
                    Text(
                        text = "Foto Seguinte",
                        color = Color.Black
                    )
                }
            }
        }
    }
}



