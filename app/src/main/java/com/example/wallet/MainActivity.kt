package com.example.wallet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wallet.ui.theme.WalletTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WalletTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WalletScreen("Android")
                }
            }
        }
    }
}

@Composable
fun WalletScreen(
    name: String,
    viewModel: WalletViewModel = viewModel()
) {
    val walletResult by viewModel.walletResult.observeAsState(0)

    LaunchedEffect(walletResult){
        if(walletResult > 0){
            // trigger positive response notification
        }else if(walletResult < 0){
            // trigger negative response notification
        }
        // reset the value back to neutral
        // viewModel.walletResult.postVlue(0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Hello $name!")
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Pay")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WalletTheme {
        WalletScreen("Android")
    }
}