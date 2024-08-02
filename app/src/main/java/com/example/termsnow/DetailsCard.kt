package com.example.termsnow

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun ShowPreview(){
    Column() {
        getServiceList().map{item->
            DetailsCard(appName = item.appName, appIcon =item.img )
        }
    }
}
@Composable
fun DetailsCard(appName:String,appIcon:Int){
    Card(
        modifier= Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 10.dp)
            .background(Color.White),
        elevation= CardDefaults.cardElevation(defaultElevation = 16.dp),
        colors= CardDefaults.cardColors(Color.White)
        ){
            Row() {
                Column(
                    modifier = Modifier.height(180.dp), horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                    Box(modifier= Modifier
                        .size(135.dp)
                        .padding(start = 12.dp, top = 12.dp)){
                        Image(
                            painter = painterResource(id = appIcon),
                            contentDescription = "Service Logo",
                        )
                    }
                    Text(text = appName)
                    Text(text="Grade E")
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier= Modifier
                        .padding(horizontal = 6.dp, vertical = 12.1.dp)
                        .height(180.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ){
                    CustomTextBox(text = "Facebook stores your data whether you have an account or not.")
                    CustomTextBox(text = "Your identity is used in ads that are shown to other users")
                    CustomTextBox(text = "The service can read your private message")
                    CustomTextBox(text = "This service can view your browser history")

                }
            }
    }
}

@Composable
fun CustomTextBox(text:String){
    Text(text=text,maxLines=2,modifier= Modifier
        .border(width = 1.3.dp, color = Color.LightGray)
        .padding(2.dp))
}

data class Services(val img:Int,val appName:String)

fun getServiceList():MutableList<Services>{
    val list= mutableListOf<Services>()
    list.add(Services(R.drawable.proxyimage,"FaceBook"))
    list.add(Services(R.drawable.zen,"Zen"))
    list.add(Services(R.drawable.chrome,"Chrome"))
    list.add(Services(R.drawable.instagram,"Instagram"))
    list.add(Services(R.drawable.appstore,"Appstore"))
    list.add(Services(R.drawable.proxyimage,"FaceBook"))
    list.add(Services(R.drawable.zen,"Zen"))
    list.add(Services(R.drawable.chrome,"Chrome"))
    list.add(Services(R.drawable.instagram,"Instagram"))
    list.add(Services(R.drawable.appstore,"Appstore"))
    
    return list
}