package com.example.myapplication

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
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
            .padding(horizontal = 16.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        val textFieldModifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)

        OutlinedTextField(
            onValueChange = { it ->
                username.value = it
            },
            value = username.value,
            modifier = textFieldModifier,
            label = {
                Text("Username")
            },
            placeholder = {
                Text(text = "username")
            }
        )

        OutlinedTextField(
            value = password.value,
            onValueChange = { it ->
                password.value = it
            },
            label = {
                Text("Password")
            },
            placeholder = {
                Text("password")
            },
            modifier = textFieldModifier,

        )

        TextButton(
            onClick = {
                Toast.makeText(context, "Reset password ", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .align(androidx.compose.ui.Alignment.End)
                .padding(bottom = 16.dp)
        ) {
            Text("Forgot Password?")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(bottom = 12.dp),
            onClick = {
                if (username.value == "abc" && password.value == "xyz") {
                    Toast.makeText(context, "Login success", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text(text = "Login")
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
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