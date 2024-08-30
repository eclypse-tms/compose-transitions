package com.example.myapplication.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Screen2(
    goToScreen1: () -> Unit,
    goToScreen3: () -> Unit
) {
    Column(modifier = Modifier
        .background(Color.Blue)) {

        Spacer(modifier = Modifier.weight(33f))

        Text(modifier = Modifier.fillMaxWidth(),
            text = "Screen 2",
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 36.sp)

        Spacer(modifier = Modifier.padding(16.dp))

        Row(horizontalArrangement = Arrangement.End) {
            Spacer(modifier = Modifier.weight(50f))

            Button(onClick = goToScreen1) {
                Text(text = "Go to Screen 1")
            }

            Spacer(modifier = Modifier.padding(16.dp))

            Button(onClick = goToScreen3) {
                Text(text = "Go to Screen 3")
            }

            Spacer(modifier = Modifier.weight(50f))
        }

        Spacer(modifier = Modifier.weight(67f))
    }
}