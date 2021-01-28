package com.example.dexbank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dexbank.ui.theme.DexBankTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DexBankTheme {
                Surface(color = Color.Transparent) {
                    DexMainCard()
                }
            }
        }
    }
}

@Composable
fun DexMainCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .preferredHeight(168.dp)
            .padding(8.dp)
            .clickable(onClick = { /*TODO*/ })
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row {
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    modifier = Modifier.preferredSize(32.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Cartão de Crédito",
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            Surface(modifier = Modifier.padding(top = 8.dp)) {
                Text(text = "Fatura atual")
            }
            Surface(modifier = Modifier.padding(top = 12.dp)) {
                Text(text = "R$ 756,98")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DexBankTheme {
        DexMainCard()
    }
}
