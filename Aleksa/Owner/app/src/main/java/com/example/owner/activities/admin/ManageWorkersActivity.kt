package com.example.owner.activities.admin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.owner.models.Worker
import com.example.owner.ui.ManageWorkersScreen
import com.example.owner.ui.theme.OwnerTheme

class ManageWorkersActivity : ComponentActivity() {
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
                    TO DO -> Retrieve actual workers from database
                     */
                    ManageWorkersScreen(
                        onAddWorker = {
                            intent = Intent(this, AddWorkerActivity::class.java)
                            startActivity(intent)
                        },
                        workers = Worker.getFakeWorkers(),
                        onEdit = {
                            intent = Intent(this, EditWorkerActivity::class.java)
                            startActivity(intent)
                            /*
                            TO DO -> Pass worker to activity through intent or Application
                             */
                        },
                        onStats = {
                            intent = Intent(this, WorkerRankingActivity::class.java)
                            startActivity(intent)
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}