package com.example.myapplication

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

@Composable
fun ProfileComposable(name: String, modifier: Modifier = Modifier,onClick:  () -> Unit) {
    Text(text = "Hello, $name!", modifier = modifier)
    val context = LocalContext.current
    val employeeName = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }
    val department = remember { mutableStateOf("") }

    val coroutine = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp),
        verticalArrangement = Arrangement.Center,
        content = {
//            Text (
//                text = "profile",
//                fontsize = 28.sp,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier.fillMaxWidth(),
//                textAlign = TextAlign.Center,
//
//                )

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
                        text = "employeeName",
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
            OutlinedTextField(
                onValueChange = { it ->
                    department.value = it
                },
                value = department.value,
                modifier = modifier,
                placeholder = {
                    Text(
                        text = "Department",
                    )
                }
            )

            Button(
                onClick = {
                    Toast.makeText(context, "Profile save", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "Save Profile")
            }
            Button(
                onClick = {
                    Toast.makeText(context, "Profile Edit ", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "Edit Profile")
            }
            Button(
                onClick = {
                    Toast.makeText(context, "Profile Updated", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "Update Profile")
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
    )
    }

@Preview(showBackground = true)
@Composable
fun ProfileComposablePreview() {
    ProfileComposable("Android", onClick = {})
}