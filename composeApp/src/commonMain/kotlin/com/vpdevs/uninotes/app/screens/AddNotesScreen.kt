package com.vpdevs.uninotes.app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import uninotes.composeapp.generated.resources.Res
import uninotes.composeapp.generated.resources.ic_back

@Composable
fun AddNotesScreen(
    onBackButtonClick: () -> Unit = {},
    onSavedButtonClick: () -> Unit = {}
) {

    var title by remember { mutableStateOf(TextFieldValue("")) }
    var content by remember { mutableStateOf(TextFieldValue("")) }
    val maxChar = 30
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(
                top = 48.dp,
                start = 8.dp,
                end = 8.dp,
                bottom = 16.dp
            )
    ) {
        IconButton(
            onClick = {
                onBackButtonClick()
            }
        ) {
            Image(
                modifier = Modifier.size(32.dp),
                painter = painterResource(Res.drawable.ic_back),
                contentDescription = "Back"
            )
        }
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 16.dp)
                .background(
                    color = Color.Transparent
                ),
            label = { Text(text = "Title") },
            value = title,
            onValueChange = { newText ->
                if (newText.text.length <= maxChar) title = newText
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                disabledIndicatorColor = Color.White
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Next)
                }
            ),
            maxLines = 1,
            textStyle = androidx.compose.ui.text.TextStyle(
                fontSize = 32.sp
            )
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(top = 16.dp)
                .background(
                    color = Color.Transparent
                ),
            label = { Text(text = "Content") },
            value = content,
            onValueChange = { newText ->
                content = newText
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                disabledIndicatorColor = Color.White
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    onSavedButtonClick()
                }
            ),
            textStyle = androidx.compose.ui.text.TextStyle(
                fontSize = 24.sp
            )
        )
    }

}