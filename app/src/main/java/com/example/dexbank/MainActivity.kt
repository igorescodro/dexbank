package com.example.dexbank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dexbank.ui.theme.DexBankTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DexBankTheme {
                Scaffold(
                    backgroundColor = MaterialTheme.colors.primary,
                    topBar = { DexToolbar() },
                    content = {
                        val list = CardType.values().toList()
                        DexMainList(cardList = list)
                    }
                )
            }
        }
    }
}

@Composable
fun DexMainList(cardList: List<CardType>) {
    LazyColumn {
        items(
            items = cardList, itemContent = { card ->
                DexMainCard(cardType = card)
            }
        )
    }
}

@Composable
fun DexMainCard(cardType: CardType) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(168.dp)
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
                    imageVector = cardType.icon,
                    contentDescription = "Card",
                    modifier = Modifier.size(32.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = cardType.title,
                    modifier = Modifier.align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.body1
                )
            }
            Text(
                text = cardType.body,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = cardType.value,
                style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(top = 12.dp)
            )
        }
    }
}

@Composable
fun DexToolbar() {
    TopAppBar(modifier = Modifier.height(100.dp)) {
        Row(
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Olá, Guilda",
                style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold)
            )
            DexToolbarButton()
            DexToolbarButton()
        }
    }
}

@Composable
fun DexToolbarButton() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(56.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colors.primaryVariant)
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "Action button")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainCardPreview() {
    DexBankTheme {
        DexMainCard(CardType.Account)
    }
}

@Preview(showBackground = true)
@Composable
fun ToolbarPreview() {
    DexBankTheme {
        DexToolbar()
    }
}
