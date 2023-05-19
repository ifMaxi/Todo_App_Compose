package com.mp.todocompose.ui.screen.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mp.todocompose.data.db.TodoEntity
import com.mp.todocompose.ui.theme.ToDoComposeTheme

@Composable
fun ItemCard(
    modifier: Modifier = Modifier,
    todo: TodoEntity,
    onDelete: () -> Unit
) {
    val checkedState = rememberSaveable { mutableStateOf(false) }

    ElevatedCard(
        modifier = modifier
            .padding(all = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it }
            )
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(text = todo.todoText)
            }
            IconButton(onClick = onDelete) {
                Icon(
                    imageVector = Icons.Filled.Clear,
                    contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
fun ItemPrev() {
    ToDoComposeTheme {
        ItemCard(
            todo = TodoEntity(id = 1522, todoText = "Testing", isComplete = false),
            onDelete = {}
        )
    }
}
