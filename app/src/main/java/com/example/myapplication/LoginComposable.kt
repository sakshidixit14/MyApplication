package com.example.myapplication

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun LoginComposable(name: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
//  Text(text = "Hello, $name!", modifier = modifier)
    val context = LocalContext.current
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier

            .fillMaxSize()
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.Center
    ) {
        val modifier = Modifier
            .fillMaxWidth()
        OutlinedTextField(
            onValueChange = { it ->
                username.value = it
            },
            value = username.value,
            modifier = modifier,
            placeholder = {
                Text(
                    text = "Username",
                )
            }

        )
        OutlinedTextField(
            onValueChange = { it ->
                password.value = it
            },
            value = password.value,
            modifier = modifier,
            placeholder = {
                Text(
                    text = "Password",
                )
            }

        )
        Button(
            onClick = {
                Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Login")
        }
        Button(
            modifier = modifier,
            onClick = {
                onClick()
            }
        ) {
            Text(text = "Go to Main")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginComposablePreview() {
    MyApplicationTheme {
        LoginComposable(("Android"), onClick = {})
    }
}