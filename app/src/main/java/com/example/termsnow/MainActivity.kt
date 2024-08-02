package com.example.termsnow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.termsnow.ui.theme.TermsNowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TermsNowTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppBottomBar(modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBottomBar(modifier: Modifier){
    /* Implemented Using Nav Graph*/
    val navigationController= rememberNavController()
    val context= LocalContext.current.applicationContext
    val selected= remember {
        mutableStateOf(Icons.Default.Explore)
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.LightGray
            ) {
                IconButton( /*Explore Button*/
                    onClick = {
                        selected.value= Icons.Default.Explore
                        navigationController.navigate(Screens.Explore.screen){
                            /* To avoid StackUp Screens */
                            popUpTo(0)
                        }
                    },modifier=Modifier.weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                        Icon(
                            Icons.Default.Explore,
                            contentDescription = "Explore Button",
                            modifier=Modifier.size(26.dp) ,
                            tint=if(selected.value == Icons.Default.Explore) Color.Black else Color.Gray
                        )
                        Text(text = "Explore")

                    }

                }
                IconButton( /*Installed Apps*/
                    onClick = {
                        selected.value= Icons.Default.Apps
                        navigationController.navigate(Screens.InstalledApps.screen){
                            /* To avoid StackUp Screens */
                            popUpTo(0)
                        }
                    },modifier=Modifier.weight(1f)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            Icons.Default.Apps,
                            contentDescription = "Installed Apps Button",
                            modifier=Modifier.size(26.dp) ,
                            tint=if(selected.value == Icons.Default.Apps) Color.Black else Color.Gray
                        )
                        Text(text = "Installed Apps")
                    }

                }
            }
        }
    ) {paddingValues->

        Column(modifier=Modifier.padding(paddingValues)) {
            Row(horizontalArrangement = Arrangement.Center,modifier=Modifier.fillMaxWidth()){
                AppSearchBar(modifier=Modifier.weight(.5f))
            }
            NavHost(
                navController=navigationController,
                startDestination = Screens.Explore.screen,

                ){
                composable(Screens.Explore.screen){ Explore() }
                composable(Screens.InstalledApps.screen){ InstalledApps()}
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppSearchBar(modifier:Modifier){
    var text by remember { mutableStateOf("") } /* For entries*/
    var active by remember { mutableStateOf(false) }
    var history = remember { mutableStateListOf("") }
        Row(
            horizontalArrangement = Arrangement.Center){
            SearchBar(
                query = text,
                onQueryChange = {text=it
                }, /*updates text*/
                onSearch = { /* Search Button Dabane pe Kya hoga */
                    history.add(text)
                    active=false
                    text=""
                },
                active = active,
                onActiveChange ={
                    active=it
                },
                placeholder = {
                    Text(text="Search a Service")
                },
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = "Search Icon")
                },
                trailingIcon = {
                    if(active){
                        Icon(
                            /* to make things clickable*/
                            modifier=Modifier.clickable {
                                if(text.isNotEmpty()){
                                    text=""
                                }else{ /*What this does is if the string is empty and you again click the button
                            the searchBox will Close the Search bar*/
                                    active=false
                                }
                            },
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close Search"
                        )

                    }
                }
            ) {
                history.forEach {
                    if (history.isNotEmpty()){
                        Row(modifier=Modifier.padding(all=10.dp)){
                            Icon(
                                modifier=Modifier.padding(end=10.dp),
                                imageVector = Icons.Default.History ,
                                contentDescription = "History Icon")
                        }
                    }
                }
            }
        }


}