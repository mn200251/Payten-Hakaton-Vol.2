package com.example.posaplikacija.stateholders


import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mojkonobar.classes.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.parcelize.Parcelize


@Parcelize
data class LoginState(
    var usernameText: String = "",
    var passwordText: String = "",
    var errorMessage: String = "",

    var currScreen: Int = 1,

    var loginUsername: String = "payten",
    var loginPassword: String = "123",


    var places: List<Place> = listOf(
        Place(1, "payten@gmail.com", "123", "", "Richard Gyros", "Najbolji giros! Odma pored masinskog fakulteta", 6),
        Place(2, "rabat@gmail.com", "123", "", "Poncho", "Lepo mesto za studente da uzivaju i jedu :)", 107),
        Place(3, "etf@gmail.com", "123", "", "KST", "Klub studenata tehnike - Dom svih studenata", 266),
        Place(4, "bucko@gmail.com", "123", "", "Bucko", "Bucko pizza - najbolja i najfinija pizza u kraju. Svrati kad god.", 72),
        )

) : Parcelable

const val UI_STATE_KEY = "uiState"

class MojKonobarViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    private val _uiState1 = MutableStateFlow(LoginState())

    private val _uiState2 = savedStateHandle.getStateFlow(UI_STATE_KEY, LoginState())

    val uiState = _uiState2

    fun updateUsernameText(text: String) {
        savedStateHandle[UI_STATE_KEY] = _uiState2.value.copy(
            usernameText = text
        )
        _uiState1.update { currentCaloriesUiState -> currentCaloriesUiState.copy(
            usernameText = text
        ) }
    }

    fun updatePasswordText(text: String) {
        savedStateHandle[UI_STATE_KEY] = _uiState2.value.copy(
            passwordText = text
        )
        _uiState1.update { currentCaloriesUiState -> currentCaloriesUiState.copy(
            passwordText = text
        ) }
    }

    fun changeScreen(newScreen: Int)
    {
        savedStateHandle[UI_STATE_KEY] = _uiState2.value.copy(
            currScreen = newScreen
        )
        _uiState1.update { currentCaloriesUiState -> currentCaloriesUiState.copy(
            currScreen = newScreen
        ) }
    }

    fun tryLogin()
    {
        var newErrorMessage = ""

        if (uiState.value.usernameText == "")
        {
            newErrorMessage = "Please enter your username"
        }
        else if (uiState.value.passwordText == "")
        {
            newErrorMessage = "Please enter your password"
        }
        else if (uiState.value.usernameText == uiState.value.loginUsername &&
            uiState.value.passwordText== uiState.value.loginPassword)
        {
            newErrorMessage = ""
        }
        else if(uiState.value.usernameText != uiState.value.loginUsername)
        {
            newErrorMessage = "Username does not exist!"
        }
        else if(uiState.value.usernameText == uiState.value.loginUsername &&
        uiState.value.usernameText != uiState.value.loginPassword)
        {
            newErrorMessage = "Incorrect password!"
        }

        savedStateHandle[UI_STATE_KEY] = _uiState2.value.copy(
            errorMessage = newErrorMessage
        )
        _uiState1.update { currentCaloriesUiState -> currentCaloriesUiState.copy(
            errorMessage = newErrorMessage
        ) }
    }
}