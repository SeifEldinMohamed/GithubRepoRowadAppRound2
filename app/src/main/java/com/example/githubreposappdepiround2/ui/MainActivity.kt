package com.example.githubreposappdepiround2.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.githubreposappdepiround2.ui.navigation.AppNavHost
import com.example.githubreposappdepiround2.ui.theme.GithubRepoAppDEPIRound2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubRepoAppDEPIRound2Theme {
                AppNavHost()
            }
        }
    }
}
