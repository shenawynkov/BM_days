package com.shenawynkov.bm_days

import Contact
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import coil.compose.AsyncImage
import com.shenawynkov.bm_days.ui.theme.DarkGReen
import kotlinx.coroutines.flow.StateFlow


@Composable
fun MainScreen(list: StateFlow<List<Contact>>) {
    val contacts by list.collectAsState()

    val context = LocalContext.current




    LazyColumn {
        items(contacts, key = { it.id })
        { contact ->
            ContactCard(contact) {
                val intent = Intent(Intent.ACTION_DIAL, "tel:${contact.phone}".toUri())
                context.startActivity(intent)
            }

        }

    }
}


@Composable
fun ContactCard(contact: Contact, onPhoneClicked: (String) -> Unit) {
    Row(modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)) {

        AsyncImage(
            contact.imageURL, modifier = Modifier
                .size(80.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )


        Column(modifier = Modifier.align(Alignment.CenterVertically)) {
            Text(text = contact.name, color = Color.Blue, fontSize = 16.sp)
            Text(text = contact.title, color = Color.Gray, fontSize = 12.sp)
        }
        Spacer(modifier = Modifier.weight(1f))

        IconButton(modifier = Modifier.align(Alignment.CenterVertically), onClick = {
            onPhoneClicked(contact.phone)
        }) {
            Icon(imageVector = Icons.Default.Call, null, tint = DarkGReen)
        }
    }
}

@Composable
fun TextCard(name: String) {


}

@Composable
fun Counter(count: Int, onButtonClicked: () -> Unit) {


    Button(onClick = { onButtonClicked() }) {
        Text("count is $count")
    }


}

@Composable
fun NameTextField(name: String, onValueChanged: (String) -> Unit) {

    TextField(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Magenta),
        value = name,
        onValueChange = onValueChanged
    )
}


@Preview
@Composable
fun PreviewTextCard() {
    TextCard("abdalla")
}