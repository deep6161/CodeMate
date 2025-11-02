package com.example.codemate


import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.codemate.inputdata.Companion.addEntry



@Composable
fun NewEntryScreen(modifier: Modifier = Modifier, navController: NavController) {
    NewEntry(modifier = modifier, navController = navController)
}



@Composable
fun NewEntry (modifier: Modifier = Modifier,navController: NavController) {

    var text by remember { mutableStateOf("") }
    var input by remember { mutableStateOf("") }
    var decprition by remember { mutableStateOf("") }

    var selectedOption by remember { mutableStateOf("Java") }
    val options = listOf("Java", "Kotlin", "Python")

    val context = LocalContext.current


    Scaffold(
        modifier = modifier,
        topBar = {
            CodeMateTopBar(
                title = "CodeMate",
                showLogo = true,
                canNavigateBack = true,
                navController = navController
            )
        },
        content = { paddingValues ->
            Column(modifier=Modifier
                .padding(paddingValues)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center)
            {
                Text(
                    text = "New Entry",
                    modifier = Modifier.padding(start = 5.dp,top = 15.dp, bottom = 10.dp),
                    style = MaterialTheme.typography.headlineLarge
                )
                OutlinedTextField(
                    value = input,
                    onValueChange = { input = it },
                    label = { Text("Title") },
                    placeholder = { Text("Enter journal title") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    textStyle = MaterialTheme.typography.bodyLarge,
                )


                OutlinedTextField(
                    value = decprition,
                    onValueChange = { decprition = it },
                    label = { Text("decprition") },
                    placeholder = { Text("Enter decprition") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    textStyle = MaterialTheme.typography.bodyLarge,
                )

                OutlinedTextField(
                    value = text,
                    onValueChange = { text= it },
                    label = { Text("code snippet") },
                    placeholder = { Text("Enter code ") },
                    minLines = 12,
                    maxLines = 12,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    textStyle = MaterialTheme.typography.bodyLarge,
                )
                Text(
                    text = "language",
                    modifier = Modifier.padding(start = 5.dp,top = 15.dp, bottom = 5.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                )
                {
                    options.forEach { option ->

                        RadioButton(
                            selected = (option == selectedOption),
                            onClick = { selectedOption = option },
                            colors = androidx.compose.material3.RadioButtonDefaults.colors(
                                selectedColor = MaterialTheme.colorScheme.primary,
                                unselectedColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                            )
                        )
                        Text(
                            text = option,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }


                }
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                    horizontalArrangement = Arrangement.Center){
                    Button(onClick = {  if (input.isBlank() || decprition.isBlank() || text.isBlank()) {

                        Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()

                    } else {

                        addEntry(
                            name = input,
                            description = decprition,
                            code = text,
                            option = selectedOption
                        )

                        input = ""
                        decprition = ""
                        text = ""
                        selectedOption = "Java"

                        Toast.makeText(context, "saved succesfully", Toast.LENGTH_SHORT).show()
                    }},
                        modifier = Modifier.fillMaxWidth(0.5f)) {
                        Text(text="SAVE")
                    }
                }

            }
        }
    )
}