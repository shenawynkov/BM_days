package com.shenawynkov.bm_days

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.StateFlow

@Composable
fun PrefScreen(black : StateFlow<Boolean>, onClick: ()-> Unit)
{
    val isDark by black.collectAsState()

    Box(modifier = Modifier.fillMaxSize().background(if(isDark) Color.Black else Color.White))
    {

        Button(modifier = Modifier.align(Alignment.Center), onClick = onClick ) {
            Text("change color")
        }
    }
}