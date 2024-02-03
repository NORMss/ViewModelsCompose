package com.norm.myviewmodelscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.norm.myviewmodelscompose.ui.theme.MyViewModelsComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyViewModelsComposeTheme {
                val viewModel by viewModels<ContactsViewModel>(
                    factoryProducer = {
                        object : ViewModelProvider.Factory {
                            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                                return ContactsViewModel(
                                    helloWorld = "Hello World!"
                                ) as T
                            }
                        }
                    }
                )
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = viewModel.backgroundColor
                ) {
                    Button(
                        onClick = {
                            viewModel.changeBackgroundColor()
                        }
                    ) {
                        Text(
                            text = "Change color"
                        )
                    }
                }
            }
        }
    }
}