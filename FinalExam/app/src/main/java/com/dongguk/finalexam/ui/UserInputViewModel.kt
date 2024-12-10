package com.dongguk.finalexam.ui

import androidx.lifecycle.ViewModel
import com.dongguk.finalexam.data.UserInput
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserInputViewModel : ViewModel() {
    private val _userInputs = MutableStateFlow<List<UserInput>>(emptyList())
    val userInputs: StateFlow<List<UserInput>> = _userInputs

    fun addUserInput(userInput: UserInput) {
        _userInputs.value += userInput
    }
}