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

//@Composable
//fun SignupComposable(name: String, modifier: Modifier = Modifier){
//    Text(text = "Hello, $name!", modifier = modifier)
//    val context = LocalContext.current
//    val empname = remember { mutableStateOf("") }
//    val email = remember { mutableStateOf("") }
//    val username = remember { mutableStateOf("") }
//    val password = remember { mutableStateOf("") }
//    val phone = remember { mutableStateOf("") }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(start = 8.dp, end = 8.dp),
//
//        verticalArrangement = Arrangement.SpaceEvenly
//    ) {
//        val modifier = Modifier
//            .fillMaxWidth()
//        OutlinedTextField(
//            onValueChange = { it ->
//                empname.value = it
//            },
//            value = empname.value,
//            modifier = modifier,
//            placeholder = {
//                Text(
//                    text = "EmpName",
//                )
//            }
//
//        )
//        OutlinedTextField(
//            onValueChange = { it ->
//                email.value = it
//            },
//            value = email.value,
//            modifier = modifier,
//            placeholder = {
//                Text(
//                    text = "Email",
//                )
//            }
//
//        )
//        OutlinedTextField(
//            onValueChange = {
//                username.value = it
//            },
//            value = username.value,
//            modifier = modifier,
//            placeholder = {
//                Text(
//                    text = "Username",
//                )
//            }
//
//        )
//
//
//        OutlinedTextField(
//            onValueChange = {
//                password.value = it
//            },
//            value = password.value,
//            modifier = modifier,
//            placeholder = {
//                Text(
//                    text = "Password",
//                )
//            }
//        )
//        OutlinedTextField(
//            onValueChange = { it ->
//                phone.value = it
//            },
//            value = phone.value,
//            modifier = modifier,
//            placeholder = {
//                Text(
//                    text = "Phone",
//                )
//            }
//
//        )
//        Button(
//            modifier = modifier,
//            onClick = {
//                if (username.value == "abc" && password.value == "xyz") {
//                    Toast.makeText(context, "login sucess", Toast.LENGTH_SHORT).show()
//                } else {
//                    Toast.makeText(context, "login failed", Toast.LENGTH_SHORT).show()
//                }
//            }
//
//        ) {
//            Text(text = "Click Me")
//        }
//    }
//}
@Preview(showBackground = true)
@Composable
fun SignupComposablePreview() {
    MyApplicationTheme {
        LoginComposable(("Android"))
    }
}