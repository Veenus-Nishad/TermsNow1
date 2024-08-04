package com.example.termsnow.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.termsnow.DetailsCard
import com.example.termsnow.getServiceList
import com.example.termsnow.viewmodels.NameViewModel
import java.util.jar.Attributes.Name

@Composable
fun Explore(){
    // as the details are now in viewmodel after api call we need to make view model object for consumption
    val nameViewModel:NameViewModel= viewModel()//ye method object bana ke dega
    val names: State<List<String>> =nameViewModel.name.collectAsState() //acessing Flow
    Box(
        modifier= Modifier
            .fillMaxSize()
    ){
        Column(modifier= Modifier
            .fillMaxSize()
            .align(Alignment.Center)) {
            LazyColumn(content={
                items(names.value){ item->
                    DetailsCard(appName=item)
                }
            })
        }
    }
}