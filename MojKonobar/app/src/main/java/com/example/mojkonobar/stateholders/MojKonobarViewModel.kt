package com.example.posaplikacija.stateholders


import android.os.Parcelable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Star
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mojkonobar.R
import com.example.mojkonobar.classes.Order
import com.example.mojkonobar.classes.OrderItem
import com.example.mojkonobar.classes.Place
import com.example.mojkonobar.screens.Category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.parcelize.Parcelize
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@Parcelize
data class LoginState(
    var usernameText: String = "",
    var passwordText: String = "",
    var errorMessage: String = "",

    var currScreen: Int = 0,
    var currCategory: Int=0,
    var loginUsername: String = "payten",
    var loginPassword: String = "123",




) : Parcelable

var places: List<Place> = listOf(
    Place(1, "payten@gmail.com", "123", R.drawable.richard, "Richard Gyros", "Najbolji giros! Odma pored masinskog fakulteta", 45, 100, Icons.Rounded.Menu),
    Place(2, "rabat@gmail.com", "123", R.drawable.poncho, "Poncho", "Lepo mesto za studente da uzivaju i jedu :)", 9, 100, Icons.Rounded.Star),
    Place(3, "etf@gmail.com", "123", R.drawable.kst, "KST", "Klub studenata tehnike - Dom svih studenata", 200, 200, Icons.Rounded.Add),
    Place(4, "bucko@gmail.com", "123", R.drawable.bucko, "Bucko", "Bucko pizza - najbolja i najfinija pizza u kraju. Svrati kad god.", 367, 500, Icons.Rounded.Add),
    Place(5, "tramvaj@gmail.com", "123", R.drawable.tramvaj, "Tramvaj ", "Osvezen novim idejama ponovo otvara svoja vrata ljubiteljima piva.", 500, 500, Icons.Rounded.Add),
)

val orderItems1 = listOf<OrderItem>(
    OrderItem(1, 1, null, served = 1, name = "Mojito", price = 3.5, R.drawable.mojito)
)

val orderItems2 = listOf<OrderItem>(
    OrderItem(2, 2, "No ice", served = 0, name = "Margheritta", price = 3.0, R.drawable.margherita),
    OrderItem(3, 2, null, served = 0, name = "Apple pie", price = 3.0, R.drawable.applepie)
)

val order1 = Order(places[4], Order.WAITING, null, 3.5, null, LocalDate.parse("2023-11-29", DateTimeFormatter.ofPattern("yyyy-MM-dd")), orderItems1)
val order2 = Order(places[2], Order.DONE, 1, 6.0, 2.0, LocalDate.parse("2023-11-28", DateTimeFormatter.ofPattern("yyyy-MM-dd")), orderItems2)

val orders = listOf<Order>(order1, order2)




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

    public fun changeScreen(newScreen: Int)
    {
        savedStateHandle[UI_STATE_KEY] = _uiState2.value.copy(
            currScreen = newScreen
        )
        _uiState1.update { currentCaloriesUiState -> currentCaloriesUiState.copy(
            currScreen = newScreen
        ) }
    }
    public fun changeCategory(newScreen: Int)
    {
        savedStateHandle[UI_STATE_KEY] = _uiState2.value.copy(
            currCategory =  newScreen
        )
        _uiState1.update { currentCaloriesUiState -> currentCaloriesUiState.copy(
            currCategory = newScreen
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