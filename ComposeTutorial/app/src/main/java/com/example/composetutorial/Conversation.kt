package com.example.composetutorial

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

/** Ширина, начиная с которой экран считается планшетным. */
private val TabletWidth = 600.dp

/**
 * Список сообщений.
 * Телефон  — один столбец (LazyColumn).
 * Планшет  — несколько колонок (LazyVerticalGrid), чтобы не растягивать сообщения на весь экран.
 * Оба компонента отрисовывают только видимые элементы, поэтому эффективны для длинных списков.
 */
@Composable
fun Conversation(messages: List<Message>, modifier: Modifier = Modifier) {
    BoxWithConstraints(modifier = modifier) {
        if (maxWidth < TabletWidth) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(messages) { message ->
                    MessageCard(message)
                }
            }
        } else {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 360.dp),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(messages) { message ->
                    MessageCard(message)
                }
            }
        }
    }
}

@Preview(name = "Телефон (светлая)", widthDp = 360, heightDp = 640, showBackground = true)
@Preview(
    name = "Телефон (тёмная)",
    widthDp = 360,
    heightDp = 640,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Preview(name = "Планшет", widthDp = 900, heightDp = 600, showBackground = true)
@Composable
fun PreviewConversation() {
    ComposeTutorialTheme {
        Surface {
            Conversation(SampleData.conversationSample)
        }
    }
}
