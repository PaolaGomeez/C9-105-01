package com.example.c9_105_01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.c9_105_01.ui.navigation.SoundInNavGraph
import com.example.c9_105_01.ui.theme.C910501Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            C910501Theme {
                val navController = rememberNavController()
                SoundInNavGraph(navController = navController)
            }
        }
    }
}