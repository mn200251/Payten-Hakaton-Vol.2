package com.example.owner.activities.admin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.myapplication.StatisticsActivity
import com.example.owner.ui.AdminHomeScreen
import com.example.owner.ui.theme.OwnerTheme

class AdminActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OwnerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AdminHomeScreen(
                        onUpdatePlace = {
                            intent = Intent(this, UpdatePlaceActivity::class.java)
                            startActivity(intent)
                        },
                        onUpdateMenu = {
                            intent = Intent(this, UpdateMenuActivity::class.java)
                            startActivity(intent)
                        },
                        onManageWorkers = {
                            intent = Intent(this, ManageWorkersActivity::class.java)
                            startActivity(intent)
                        },
                        onGetQR = {
                            intent = Intent(this, GetQRCodeActivity::class.java)
                            startActivity(intent)
                        },
                        onStatistics = {
                            intent = Intent(this, StatisticsActivity::class.java)
                            startActivity(intent)
                        },
                        modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}