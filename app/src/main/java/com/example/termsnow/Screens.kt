package com.example.termsnow

sealed class Screens(val screen:String) {
    data object Explore : Screens("explore")
    data object InstalledApps : Screens("installedapps")
}