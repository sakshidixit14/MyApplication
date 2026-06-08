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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

@Composable
fun SignupComposable(
    name: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Text(text = "Hello, $name!", modifier = modifier)
    val context = LocalContext.current
    val employeeName = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }

    val coroutine = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        val modifier = Modifier
            .fillMaxWidth()
        OutlinedTextField(
            onValueChange = { it ->
                employeeName.value = it
            },
            value = employeeName.value,
            modifier = modifier,
            placeholder = {
                Text(
                    text = "EmpName",
                )
            }
        )

        OutlinedTextField(
            onValueChange = { it ->
                email.value = it
            },
            value = email.value,
            modifier = modifier,
            placeholder = {
                Text(
                    text = "Email",
                )
            }
        )
        OutlinedTextField(
            onValueChange = {
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
            onValueChange = {
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
        OutlinedTextField(
            onValueChange = { it ->
                phone.value = it
            },
            value = phone.value,
            modifier = modifier,
            placeholder = {
                Text(
                    text = "Phone",
                )
            }
        )

        Button(
            modifier = modifier,
            onClick = {

                val dbInstance = AppDb.getDatabase(context)
                val employeeDao = (dbInstance as AppDb).employeeDao()

                if (username.value == "abc" && password.value == "xyz") {

                    val employee = Employee(
                        name = employeeName.value,
                        email = email.value,
                        phone = phone.value
                    )

                    coroutine.launch {
                        employeeDao.insert(employee)
                    }

                    Toast.makeText(context, "Signup success", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Signup failed", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text(text = "Click Me")
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
fun SignupComposablePreview() {
    MyApplicationTheme {
        LoginComposable("Android", onClick = {})
    }
}