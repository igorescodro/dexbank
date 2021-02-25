package com.example.dexbank

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomCardType(
    val icon: ImageVector,
    @StringRes val cardTitle: Int
) {
    Pix(Icons.Outlined.Place, R.string.main_bottom_card_title_pix),
    Payment(Icons.Outlined.Send, R.string.main_bottom_card_title_payment),
    Share(Icons.Outlined.Share, R.string.main_bottom_card_title_share),
    Transfer(Icons.Outlined.Warning, R.string.main_bottom_card_title_transfer),
    Deposit(Icons.Outlined.PlayArrow, R.string.main_bottom_card_title_deposit),
    Loan(Icons.Outlined.LocationOn, R.string.main_bottom_card_title_loan),
    DigitalCard(Icons.Outlined.Phone, R.string.main_bottom_card_title_digital_card)
}
