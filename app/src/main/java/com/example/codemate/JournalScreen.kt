package com.example.codemate


import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController



@Composable
fun HomeScreen(modifier: Modifier = Modifier,navController: NavController) {


    var title = inputdata.title
    var language = inputdata.language
    var description = inputdata.description
    var code=inputdata.code


    Scaffold(
        modifier = modifier,
        topBar = {
            CodeMateTopBar(
                title = "CodeMate",
                showLogo = true,
                canNavigateBack = false,
                navController = navController
            )
        },
        content = { paddingValues ->
            Box(modifier=modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)) {
                    Text(
                        text = "Journal Entries",
                        modifier = Modifier.padding(top = 15.dp, bottom = 15.dp, start = 5.dp),
                        style = MaterialTheme.typography.headlineLarge,
                        color =Color( 0xFFBD93F9)
                    )

                    LazyColumn (modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ){

                        items(title.indices.toList()) { index ->
                            entery(
                                title = title[index],
                                language = language[index],
                                description = description[index],
                                code = code[index],
                                navController = navController
                            )
                        }

                    }
                }

                FloatingActionButton(
                    onClick = {navController.navigate("NewEntry")},
                    containerColor = colorResource(R.color.teal_700),
                    modifier = Modifier
                        .padding(24.dp)
                        .size(72.dp), // bigger button like in the image
                    shape = RoundedCornerShape(50)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "New Entry",
                        tint = Color.White,
                        modifier = Modifier.size(36.dp)
                    )
                }
            }
        }
    )
}


@Composable
fun entery(
    modifier: Modifier = Modifier,
    title:String,
    language:String,
    description: String,
    code: String,
    navController: NavController) {

    Card (modifier=modifier
        .padding(horizontal = 8.dp)
        .height(150.dp)
        .clickable {
            navController.navigate(
                "EntryDetail/${Uri.encode(title)}/${Uri.encode(description)}/${Uri.encode(code)}/${Uri.encode(language)}"
            )

        },
        colors = CardDefaults.cardColors(containerColor = Color(0xFFBD93F9)),
        shape = RoundedCornerShape(15.dp),
        elevation =CardDefaults.cardElevation(defaultElevation = 10.dp),

    ){
        Row(modifier=Modifier
            .fillMaxWidth()
            .padding(top = 25.dp, start = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text=title,
                modifier = Modifier,
                style = MaterialTheme.typography.headlineMedium, )
            IconButton(onClick = { /* edit action */ }) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Edit entry",
                    modifier = modifier.fillMaxSize(0.8f)

                )
            }
        }
        Text(text=language,
            modifier=Modifier.padding(8.dp),
            style = MaterialTheme.typography.bodyLarge)

    }
}