package com.example.mojkonobar

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Fastfood
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mojkonobar.screens.HomeScreen
import com.example.mojkonobar.screens.ItemsActivity
import com.example.mojkonobar.screens.LoginScreen
import com.example.mojkonobar.screens.MenuScreen
import com.example.mojkonobar.screens.RegisterScreen
import com.example.mojkonobar.ui.theme.MojKonobarTheme
import com.example.mojkonobar.ui.theme.Offwhite
import com.example.posaplikacija.stateholders.MojKonobarViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MojKonobarTheme {
                val vm: MojKonobarViewModel=viewModel()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {var selected1=false
                    var selected2 by rememberSaveable {
                        mutableStateOf(1)
                    }
                    Scaffold (
                    bottomBar = {
                        NavigationBar() {
                            NavigationBarItem(

                                selected = false ,
                                onClick = {
                                    selected2=1
                                    vm.changeScreen(1)
                                    },
                                icon = {  Icon(
                                    imageVector = if (selected1) {
                                        Icons.Default.Home
                                    } else Icons.Outlined.Home,
                                    contentDescription = "Home",
                                    tint= Color.Red
                                ) },
                                label = { Text(text = "Home")});
                            NavigationBarItem(

                                selected = false ,
                                onClick = {
                                    selected2=2
                                    vm.changeScreen(2)
                                     },
                                icon = {
                                    Icon(
                                        imageVector = if (selected1) {
                                            Icons.Default.PhotoCamera
                                        } else Icons.Outlined.PhotoCamera,
                                        contentDescription = "Skeniraj",
                                        tint= Color.Red
                                    )
                                }, label={ Text(text = "QR")});
                            NavigationBarItem(

                                selected = false ,
                                onClick = {
                                    selected1 = true
                                    selected2=3;
                                    vm.changeScreen(3)
                                },
                                        //startActivity(Intent(this@MainActivity,RegisterScreen::class.java)) },
                                icon = {
                                    Icon(
                                        imageVector = if (selected1) {
                                            Icons.Default.Fastfood
                                        } else Icons.Outlined.Fastfood,
                                        contentDescription = "FF",
                                        tint= Color.Red
                                    )
                                }, label={ Text(text = "Orders")});
                            NavigationBarItem(

                                selected = false ,
                                onClick = {
                                    selected1=true
                                    selected2=4
                                    vm.changeScreen(4)
                                     },
                                icon = {
                                    Icon(
                                        imageVector = if (selected1) {
                                            Icons.Default.AccountBox
                                        } else Icons.Outlined.AccountBox,
                                        contentDescription = "FF",
                                        tint= Color.Red
                                    )
                                }, label={ Text(text = "Account")})
                        }}

                ) {
                                //vm.changeScreen(selected2)
                    MojKonobar(this@MainActivity,vm)
//                    val simpleProgressBar = findViewById<ProgressBar>(com.example.mojkonobar.R.id.simpleProgressBar)
                    //MojKonobar(this)
//                    val simpleProgressBar: ProgressBar = findViewById(R.id.progressBar)
//                    simpleProgressBar.visibility = View.VISIBLE
//                    simpleProgressBar.progress = 50
                }}
                }
            }
        }}




@Composable
fun MojKonobar(mainActivity: MainActivity, viewModel:MojKonobarViewModel)
{
    //val viewModel: MojKonobarViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    //uiState.currScreen=int
    if (uiState.currScreen==1) {
        // LoginScreen(viewModel, modifier = Modifier)
        // RegisterScreen(modifier = Modifier)
        HomeScreen(viewModel, modifier = Modifier, mainActivity)
    }
    else if (uiState.currScreen==2){
        LoginScreen(viewModel, modifier = Modifier,mainActivity)
    }
    else if (uiState.currScreen==3){
        RegisterScreen(modifier = Modifier)
    }
    else if(uiState.currScreen==4){
        MenuScreen(viewModel, modifier= Modifier,mainActivity)
    }
    else if(uiState.currScreen==5){
        ItemsActivity(viewModel,modifier= Modifier,mainActivity)
    }
    else if(uiState.currScreen==6){
        MenuScreen(viewModel, modifier= Modifier,mainActivity)
    }
    else if(uiState.currScreen==7){
        MenuScreen(viewModel, modifier= Modifier,mainActivity)
    }
    else if(uiState.currScreen==8){
        MenuScreen(viewModel, modifier= Modifier,mainActivity)
    }
}