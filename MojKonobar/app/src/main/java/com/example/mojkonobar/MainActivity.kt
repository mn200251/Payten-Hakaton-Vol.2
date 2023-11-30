package com.example.mojkonobar

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
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
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mojkonobar.composables.PreviewViewComposable
import com.example.mojkonobar.screens.AccountScreen
import com.example.mojkonobar.screens.HomeScreen
import com.example.mojkonobar.screens.ItemsActivity
import com.example.mojkonobar.screens.LoginScreen
import com.example.mojkonobar.screens.MenuScreen
import com.example.mojkonobar.screens.OrderScreen
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
}




@androidx.annotation.OptIn(androidx.camera.core.ExperimentalGetImage::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun  MojKonobar(mainActivity: MainActivity, viewModel:MojKonobarViewModel)
{
    //val viewModel: MojKonobarViewModel = viewModel()
    var vm=viewModel
    val uiState by viewModel.uiState.collectAsState()

    // viewModel.changeScreen(int)
    val selected1=true

    //uiState.currScreen=int

    if (uiState.currScreen==0){

        LoginScreen(viewModel, modifier = Modifier,mainActivity)
    }
    else if(uiState.currScreen==-1){
        RegisterScreen(modifier = Modifier)

    }
    else if (uiState.currScreen==1) {
        // LoginScreen(viewModel, modifier = Modifier)
        // RegisterScreen(modifier = Modifier)

        Scaffold (
            bottomBar = {
                NavigationBar() {
                    NavigationBarItem(

                        selected = false ,
                        onClick = {

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
                            /*
                            val REQUEST_IMAGE_CAPTURE = 1
                            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                            try {
                                startActivityForResult(mainActivity, takePictureIntent, REQUEST_IMAGE_CAPTURE, null)
                            } catch (e: ActivityNotFoundException) {
                                // display error state to the user
                            }*/


                            vm.changeScreen(10)
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

                            vm.changeScreen(11)
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
            HomeScreen(viewModel, modifier = Modifier, mainActivity)}
    }
    else if (uiState.currScreen==2){
        Scaffold (
            bottomBar = {
                NavigationBar() {
                    NavigationBarItem(

                        selected = false ,
                        onClick = {

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

                            vm.changeScreen(10)
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

                            vm.changeScreen(11)
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
            LoginScreen(viewModel, modifier = Modifier,mainActivity)
        }}
    else if (uiState.currScreen==3){
        Scaffold (
            bottomBar = {
                NavigationBar() {
                    NavigationBarItem(

                        selected = false ,
                        onClick = {

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

                            vm.changeScreen(10)
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

                            vm.changeScreen(11)
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
        }
        // RegisterScreen(modifier = Modifier)
        OrderScreen(viewModel, modifier = Modifier, mainActivity)

    }
    else if(uiState.currScreen==4){
        Scaffold (
            bottomBar = {
                NavigationBar() {
                    NavigationBarItem(

                        selected = false ,
                        onClick = {

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

                            vm.changeScreen(10)
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

                            vm.changeScreen(11)
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

            MenuScreen(viewModel, modifier= Modifier,mainActivity)
        }}
    else if(uiState.currScreen==5){
        Scaffold (
            bottomBar = {
                NavigationBar() {
                    NavigationBarItem(

                        selected = false ,
                        onClick = {

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

                            vm.changeScreen(10)
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

                            vm.changeScreen(11)
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

            ItemsActivity(viewModel,modifier= Modifier,mainActivity)
        }}
    else if(uiState.currScreen==6){
        Scaffold (
            bottomBar = {
                NavigationBar() {
                    NavigationBarItem(

                        selected = false ,
                        onClick = {

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

                            vm.changeScreen(10)
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

                            vm.changeScreen(11)
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

            MenuScreen(viewModel, modifier= Modifier,mainActivity)
        }}
    else if(uiState.currScreen==7){
        Scaffold (
            bottomBar = {
                NavigationBar() {
                    NavigationBarItem(

                        selected = false ,
                        onClick = {

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

                            vm.changeScreen(10)
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

                            vm.changeScreen(11)
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

            MenuScreen(viewModel, modifier= Modifier,mainActivity)
        }}
    else if (uiState.currScreen == 10) {
        PreviewViewComposable(vm)
    }
    else if (uiState.currScreen == 11) {






        Scaffold (
            bottomBar = {
                NavigationBar() {
                    NavigationBarItem(

                        selected = false ,
                        onClick = {

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
                            /*
                            val REQUEST_IMAGE_CAPTURE = 1
                            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                            try {
                                startActivityForResult(mainActivity, takePictureIntent, REQUEST_IMAGE_CAPTURE, null)
                            } catch (e: ActivityNotFoundException) {
                                // display error state to the user
                            }*/


                            vm.changeScreen(10)
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

                            vm.changeScreen(11)
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
            AccountScreen(viewModel = viewModel, modifier = Modifier, context = mainActivity)
        }
    }
    else if(uiState.currScreen==8){
        Scaffold (
            bottomBar = {
                NavigationBar() {
                    NavigationBarItem(

                        selected = false ,
                        onClick = {

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

                            vm.changeScreen(10)
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

                            vm.changeScreen(11)
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

            MenuScreen(viewModel, modifier= Modifier,mainActivity)
        }}
}