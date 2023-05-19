package com.mp.todocompose.ui.screen.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mp.todocompose.R
import com.mp.todocompose.ui.theme.ToDoComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemDialog(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit
) {
    val viewModel: DialogViewModel = viewModel(factory = DialogViewModel.Factory)

    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = viewModel.textChange.value,
            onValueChange = { viewModel.onTextChange(it) },
            singleLine = true,
            label = {
                Text(text = stringResource(id = R.string.write_some))
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(30.dp))
        ActionButtons(
            onCancel = onNavigateBack,
            onSave = {
                viewModel.saveItem()
                onNavigateBack()
            }
        )
    }
}

@Composable
fun ActionButtons(
    modifier: Modifier = Modifier,
    onCancel: () -> Unit,
    onSave: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 6.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
            onClick = onCancel // NavBack
        ) {
            Icon(
                imageVector = Icons.Filled.Cancel,
                contentDescription = null
            )
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = stringResource(id = R.string.cancel))
        }
        Button(
            contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
            onClick = onSave
        ) {
            Icon(
                imageVector = Icons.Filled.Save,
                contentDescription = null
            )
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = stringResource(id = R.string.save))
        }
    }
}

@Preview(showSystemUi = false)
@Composable
fun ButtonPrev() {
    ToDoComposeTheme {
        ActionButtons(onCancel = {}, onSave = {})
    }
}
