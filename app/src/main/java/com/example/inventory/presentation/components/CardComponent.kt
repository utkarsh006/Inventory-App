package com.example.inventory.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.inventory.R
import com.example.inventory.data.dataClasses.Item

@Composable
fun CardComponent(item: Item) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .width(250.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                IconComponent(iconResId = R.drawable.ic_heart, tint = Color.Black, onClick = {})
            }

            Spacer(modifier = Modifier.height(8.dp))

            AsyncImage(
                model = item.icon,
                contentDescription = "",
                modifier = Modifier
                    .wrapContentWidth()
                    .height(80.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextComponent(value = item.name)

            Spacer(modifier = Modifier.height(5.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                TextComponent(value = item.price)
                Spacer(modifier = Modifier.weight(1f))
                IconComponent(iconResId = R.drawable.ic_add, tint = Color.Green, onClick = {})
            }

        }
    }
}

@Preview
@Composable
fun MyPreview() {
    CardComponent(
        item = Item(
            "https://cdn-icons-png.flaticon.com/128/2553/2553691.png",
            1,
            "Chips",
            20.00
        )
    )
}