package com.example.termsnow.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun InstalledApps(){
    Box(
        modifier= Modifier
            .fillMaxSize()
    ){
        Column(modifier= Modifier
            .fillMaxSize()
            .align(Alignment.Center)) { Text(text = "Installed Apps") }
    }
}