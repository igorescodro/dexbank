package com.example.dexbank

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HelloScreen(viewModel: HelloViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp)
    ) {
        val name by viewModel.name

        HelloContent(name = name, onNameChange = viewModel::onNameChange)
    }
}

@Composable
fun HelloContent(name: String, onNameChange: (String) -> Unit) {
    if (name.isNotEmpty()) {
        Text(text = "Hello, $name!")
    }
    TextField(value = name, onValueChange = { onNameChange(it) })
}

class HelloViewModel : ViewModel() {

    // private val _name = MutableLiveData<String>()
    // val name: LiveData<String> = _name

    private val _name: MutableState<String> = mutableStateOf("")
    val name: State<String> = _name

    fun onNameChange(name: String) {
        _name.value = name
    }
}
