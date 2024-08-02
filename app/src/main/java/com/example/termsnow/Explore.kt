package com.example.termsnow

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Explore(){
    Box(
        modifier= Modifier
            .fillMaxSize()
    ){
        Column(modifier= Modifier
            .fillMaxSize()
            .align(Alignment.Center)) {
            LazyColumn(content={
                items(getServiceList()){item->
                    DetailsCard(appName=item.appName,appIcon=item.img)
                }
            })
        }
    }
}