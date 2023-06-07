package com.example.kmmktormediumapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kmmktormediumapp.Greeting
import com.example.kmmktormediumapp.provider.Provider
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {

    private val provider = Provider()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val coroutineScope = rememberCoroutineScope()

                    var user by remember {
                        mutableStateOf("Pending")
                    }
                    Greeting(Greeting().greeting(), user){
                        coroutineScope.launch {
                            user = provider.getUser()
                        }
                    }
                }
            }
        }
    }


    @Composable
    fun Greeting(text: String, user: String, onClick: () -> Unit) {
        Column {
            Button(onClick = onClick) {
                Text(text = text)
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(user)
        }
    }

}