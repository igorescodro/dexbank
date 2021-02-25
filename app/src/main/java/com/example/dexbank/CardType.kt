package com.example.dexbank

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

enum class CardType(
    val icon: ImageVector,
    val title: String,
    val body: String,
    val value: String
) {
    CreditCard(
        icon = Icons.Outlined.ShoppingCart,
        title = "Cartão de Crédito",
        body = "Fatura atual",
        value = "R$ 756,46"
    ),
    Account(
        icon = Icons.Outlined.Info,
        title = "Conta corrente",
        body = "Saldo disponível",
        value = "R$ 88.000,98"
    ),
    Loan(
        icon = Icons.Outlined.CheckCircle,
        title = "Empréstimo",
        body = "Valor dispnonível",
        value = "R$ 200.000,00"
    ),
    Insurance(
        icon = Icons.Outlined.KeyboardArrowUp,
        title = "Seguro",
        body = "Valor assegurado",
        value = "R$ 100.000,00"
    )
}
