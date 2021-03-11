package com.example.dexbank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dexbank.ui.theme.DexBankTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DexBankTheme {
                DexBankHome()
            }
        }
    }
}

@Composable
private fun DexBankHome() {
    var showValues by remember { mutableStateOf(true) }
    Scaffold(
        backgroundColor = MaterialTheme.colors.primary,
        topBar = {
            DexToolbar(
                showValues = showValues,
                onShowClick = { showValues = !showValues })
        },
        content = {
            val list = CardType.values().toList()
            DexMainList(cardList = list, showValues = showValues)
        },
        bottomBar = {
            val list = BottomCardType.values().toList()
            DexBottomBar(list)
        }
    )
}

@Composable
fun DexToolbar(showValues: Boolean, onShowClick: () -> Unit) {
    TopAppBar(modifier = Modifier.height(100.dp)) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Olá, Guilda",
                style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.weight(5f)
            )
            DexToolbarButton(
                modifier = Modifier.weight(1f),
                imageVector = Icons.Outlined.Face,
                onClick = {})
            Spacer(modifier = Modifier.width(16.dp))
            DexToolbarTwoStateButton(
                modifier = Modifier.weight(1f),
                showValues = showValues,
                onShowClick = onShowClick,
                assetIdle = Icons.Outlined.Lock,
                assetSelected = Icons.Filled.Lock,
            )
        }
    }
}

@Composable
fun DexMainList(cardList: List<CardType>, showValues: Boolean) {
    LazyColumn(modifier = Modifier.padding(end = 16.dp, start = 16.dp, bottom = 140.dp)) {
        items(
            items = cardList, itemContent = { card ->
                DexMainCard(cardType = card, showValues = showValues)
            }
        )
    }
}

@Composable
fun DexBottomBar(list: List<BottomCardType>) {
    LazyRow(
        contentPadding = PaddingValues(start = 8.dp, end = 8.dp)
    ) {
        items(
            items = list, itemContent = { card ->
                DexBottomCard(cardType = card)
            }
        )
    }
}

@Composable
fun DexMainCard(cardType: CardType, showValues: Boolean) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(168.dp)
            .padding(vertical = 8.dp)
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
            if (showValues) {
                Text(
                    text = cardType.value,
                    style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(top = 12.dp)
                )
            } else {
                Spacer(
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth()
                        .height(34.dp)
                        .background(Color.Gray)
                )
            }
        }
    }
}

@Composable
fun DexBottomCard(cardType: BottomCardType) {
    Card(
        backgroundColor = MaterialTheme.colors.primaryVariant,
        modifier = Modifier
            .size(128.dp)
            .padding(8.dp)
            .clickable { }
    ) {
        Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.SpaceAround) {
            Icon(imageVector = cardType.icon, contentDescription = "card icon")
            Text(
                text = stringResource(id = cardType.cardTitle),
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Composable
fun DexToolbarButton(modifier: Modifier, imageVector: ImageVector, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(56.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colors.primaryVariant)
            .aspectRatio(1f)
            .clickable { onClick() }
    ) {
        IconButton(onClick = onClick) {
            Icon(imageVector = imageVector, contentDescription = "Action button")
        }
    }
}

@Composable
private fun DexToolbarTwoStateButton(
    modifier: Modifier = Modifier,
    showValues: Boolean,
    onShowClick: () -> Unit,
    assetIdle: ImageVector,
    assetSelected: ImageVector
) {
    val asset = if (showValues) assetSelected else assetIdle

    DexToolbarButton(
        modifier = modifier,
        imageVector = asset,
        onClick = onShowClick
    )
}

@Preview(showBackground = true)
@Composable
fun MainCardPreview() {
    DexBankTheme {
        DexMainCard(cardType = CardType.Account, showValues = true)
    }
}

@Preview(showBackground = true)
@Composable
fun ToolbarPreview() {
    DexBankTheme {
        DexToolbar(showValues = false, onShowClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun BottomCardPreview() {
    DexBankTheme {
        DexBottomCard(cardType = BottomCardType.Pix)
    }
}
