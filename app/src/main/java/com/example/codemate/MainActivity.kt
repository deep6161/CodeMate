package com.example.codemate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.codemate.ui.theme.CodeMateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {

            CodeMateTheme {
                val navController= rememberNavController()
                NavHost(navController=navController, startDestination = "HomeScreen", builder ={
                    composable(route = "HomeScreen"){
                        HomeScreen(navController = navController)
                    }

                    composable(route = "NewEntry") {
                        NewEntryScreen( navController = navController) }
                } )
            }
        }
    }
}