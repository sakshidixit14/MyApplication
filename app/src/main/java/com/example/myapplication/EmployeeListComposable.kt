package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyListComposable(
    name: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit ={}
) {
    val context = LocalContext.current
    val listCoroutineScope = rememberCoroutineScope()
    val appDb = AppDb.getDatabase(context)
    val employeeDao = (appDb as AppDb).employeeDao()

    val employeeList: MutableState<List<Employee>> = remember { mutableStateOf(emptyList()) }

    LaunchedEffect(Unit) {
        employeeList.value = employeeDao.getAllEmployees()
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp),
        content = {

            for (employeeObject in employeeList.value) {

                Text(text = employeeObject.name)
            }
        },
        verticalArrangement = Arrangement.Center
    )
}

@Preview(showBackground = true)
@Composable
fun MyListComposablePreview() {
    MyListComposable(name = "Android", onClick = {})
}