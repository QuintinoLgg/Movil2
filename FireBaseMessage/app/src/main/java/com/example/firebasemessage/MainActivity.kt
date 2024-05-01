package com.example.firebasemessage

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firebasemessage.ui.theme.FireBaseMessageTheme
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FireBaseMessageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Recuperar Token del dispositivo
                        getToken()
                        Log.d("Hola TOKEN","Vaya vaya")
                    }
                }
            }
        }
    }
}

private fun getToken() {
    //FirebaseMessaging.getInstance().token.addOnCompleteListener( OnCompleteListener { task->
    FirebaseMessaging.getInstance().token.addOnCompleteListener( OnCompleteListener { task ->
        if(!task.isSuccessful) {
            Log.d("GetToken", "NO SE PUDO RECUPERAR TOKEN")
            return@OnCompleteListener
        }
        val token = task.result
        Log.d("TOKEN RECUPERADO", token)
    } )
}

