package com.example.myapplication.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.UserDataUiEvents
import com.example.myapplication.data.UserInputScreenState

class UserInputViewModel : ViewModel() {

    companion object{
        const val TAG = "UserInputViewModel"
    }

    var uiState = mutableStateOf(UserInputScreenState())

    fun onEvent(event: UserDataUiEvents) {
        when (event) {
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
                Log.d(TAG, "onEvent:UserNameEntered->> ")
                Log.d(TAG, "${uiState.value}")
            }

            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(
                    animalSelected = event.animalValue
                )
                Log.d(TAG, "onEvent:AnimalSelected->> ")
                Log.d(TAG, "${uiState.value}")
            }
        }
    }

    fun isValidate() : Boolean{
        return uiState.value.nameEntered.isNotEmpty() && uiState.value.animalSelected.isNotEmpty()
    }
}

