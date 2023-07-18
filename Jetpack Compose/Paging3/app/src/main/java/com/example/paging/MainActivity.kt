package com.example.paging

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.rememberAsyncImagePainter
import com.example.paging.model.UsersInfo
import com.example.paging.ui.theme.PagingTheme
import com.example.paging.viewmodel.UsersViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: UsersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PagingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UserListPageView(
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}

@Composable
fun UserListPageView(viewModel: UsersViewModel) {
    val usersList : LazyPagingItems<UsersInfo> = viewModel.users.collectAsLazyPagingItems()
    LazyColumn{
        items(count = usersList.itemCount) { index ->
            if(usersList[index] != null){
                usersList[index]?.let {
                    println(it.first_name)
                    UserCardView(
                        user = it
                    )
                }
            }
        }
    }
}

@Composable
fun UserCardView(user: UsersInfo) {
    Card(
        modifier = Modifier
            .padding(start = 10.dp, top = 5.dp, end = 10.dp, bottom = 5.dp)
            .fillMaxWidth(),
        elevation = 4.dp,
        shape = RoundedCornerShape(10.dp)

    ){
        Row (
            modifier = Modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(8.dp))
        ){
            Surface(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp))
            ){
                Image(
                    painter = rememberAsyncImagePainter(user.avatar),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .align(Alignment.CenterVertically)
            ){
                Text(
                    text = user.first_name + user.last_name
                )

                Text(
                    text = user.email
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PagingTheme {

    }
}