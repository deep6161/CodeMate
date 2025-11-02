package com.example.codemate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.codemate.ui.theme.DarkBackground
import com.example.codemate.ui.theme.PrimaryBlue
import com.example.codemate.ui.theme.PrimaryPurple
import com.example.codemate.ui.theme.SurfaceDark
import com.example.codemate.ui.theme.TextPrimary
import com.example.codemate.ui.theme.TextSecondary

@Composable
fun EntryDetailScreen(
    navController: NavController,
    title: String,
    description: String,
    code: String,
    language: String
) {


    Scaffold(
        topBar = {
            CodeMateTopBar(
                title = "CodeMate",
                showLogo = true,
                canNavigateBack = true,
                navController = navController
            )
        },
        containerColor = DarkBackground
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Entry Details",
                color = PrimaryBlue,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(8.dp)
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                colors = CardDefaults.cardColors(containerColor = SurfaceDark),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    Text(
                        text = "Title: $title",
                        color = PrimaryPurple,
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Spacer(Modifier.height(8.dp))

                    Text(
                        text = "Language: $language",
                        color = TextSecondary,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(Modifier.height(12.dp))

                    Text(
                        text = "Code:",
                        color = PrimaryBlue,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(Modifier.height(8.dp))

                    Text(
                        text = code,
                        color = TextPrimary,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFF1E1E2E), shape = MaterialTheme.shapes.medium)
                            .padding(12.dp)
                    )
                }
            }
        }
    }
}
