package com.vpdevs.uninotes.app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import uninotes.composeapp.generated.resources.Res
import uninotes.composeapp.generated.resources.ic_add
import uninotes.composeapp.generated.resources.ic_logo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onAddNoteButtonClick: () -> Unit = {}
) {

    Scaffold(
        contentWindowInsets = WindowInsets(
            left = 0.dp
        ),
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Row (
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ){
                        Icon(
                            modifier = Modifier.size(32.dp),
                            painter = painterResource(Res.drawable.ic_logo),
                            contentDescription = "UniNotes"
                        )
                        Text(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            text = "UniNotes",
                            color = Color.Black
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onAddNoteButtonClick()
                }
            ) {
                Icon(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(Res.drawable.ic_add),
                    contentDescription = "Add Notes"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    )
    {innerpadding->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerpadding).padding(8.dp)
        ) {
            HorizontalDivider(

                thickness = 1.dp,
                color = Color.Black
            )
            Text(
                text = "Home Screen",
                style = MaterialTheme.typography.titleLarge
            )
        }
    }


}