package com.mp.todocompose.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mp.todocompose.R
import com.mp.todocompose.data.db.TodoEntity
import com.mp.todocompose.ui.screen.home.components.ItemCard
import com.mp.todocompose.ui.theme.ToDoComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavAddItem: () -> Unit,
    onNavToItem: () -> Unit
) {
    val viewModel: HomeScreenViewModel = viewModel(factory = HomeScreenViewModel.Factory)
    val state by viewModel.homeUiState.collectAsState()

    Scaffold(
        floatingActionButton = {
            NewItemFab(onNew = onNavAddItem) // Nav addItem
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { paddingValues ->
        PrincipalList(
            onDel = { viewModel.deleteItem(it) },
            onNav = onNavToItem,
            itemList = state.todoList,
            modifier = modifier.padding(paddingValues)
        )
    }
}

@Composable // TEST
fun PrincipalList(
    modifier: Modifier = Modifier,
    onDel: (TodoEntity) -> Unit,
    onNav: () -> Unit,
    itemList: List<TodoEntity>
) {
    LazyColumn(
        modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(itemList) {todo ->
            ItemCard(
                todo = todo,
                onDelete = { onDel(todo) },
                onNavigate = onNav // Nav toItem
            )
            Divider(thickness = 2.dp)
        }
    }
}

@Composable
fun NewItemFab(
    modifier: Modifier = Modifier,
    onNew: () -> Unit // Navigation
) {
    ExtendedFloatingActionButton(
        modifier = modifier.padding(all = 8.dp),
        onClick = onNew,
        elevation = FloatingActionButtonDefaults.elevation(4.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = stringResource(id = R.string.new_todo))
    }
}

@Preview
@Composable
fun FabButtonPrev() {
    ToDoComposeTheme {
        NewItemFab(onNew = {})
    }
}
