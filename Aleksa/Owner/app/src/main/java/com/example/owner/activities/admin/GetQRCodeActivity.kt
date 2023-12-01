package com.example.owner.activities.admin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.owner.ui.GetQRCodeScreen
import com.example.owner.ui.bitmapToBase64
import com.example.owner.ui.getPaytenPrintRequestJson
import com.example.owner.ui.getPaytenSaleRequestJson
import com.example.owner.ui.theme.OwnerTheme
import com.example.owner.ui.toRSD

class GetQRCodeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OwnerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /*
                    TO DO: User inputs table identifier,
                    and a qr code is generated that represents
                    the place id + table id, so users can scan the code
                    to order from the menu
                     */
                    GetQRCodeScreen(onPrint = {
                        val json = getPaytenPrintRequestJson(bitmapToBase64(it))
                        intent = Intent("com.payten.ecr.action")
                        intent.setPackage("com.payten.paytenapos")
                        intent.putExtra(
                            "ecrJson",
                            json
                        )
                        intent.putExtra("senderIntentFilter", "paytenreceiveqr")
                        intent.putExtra("senderPackage", "com.example.owner.activities.admin")
                        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
                        sendBroadcast(intent)
                    }, modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}