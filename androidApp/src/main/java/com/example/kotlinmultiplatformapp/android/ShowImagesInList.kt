package com.example.kotlinmultiplatformapp.android

import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore.Images
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

class ShowImagesInList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ShowImagesInLIstView()
                }
            }
        }
    }
}

@Composable
fun ShowImagesInLIstView(){
    var selectImages by remember { mutableStateOf(listOf<Uri>()) }

    val multiplePhotoPickerLauncher = rememberLauncherForActivityResult(
        //lets the user select up to 5 media files
        //contract = ActivityResultContracts.PickMultipleVisualMedia(5),
        contract = ActivityResultContracts.PickMultipleVisualMedia(),
        onResult = { uris -> selectImages = uris }
    )
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Button(
            onClick = {  multiplePhotoPickerLauncher.launch(
                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
            ) },
            modifier = Modifier
                .wrapContentSize()
                .padding(10.dp)
        ) {
            Text(text = "Pick Image From Gallery and Show in List")
        }
        //Images shown in vertical scrolling way
       LazyColumn(){
           items(selectImages) {  uri ->
               Image(
                   painter = rememberImagePainter(uri),
                   contentScale = ContentScale.FillWidth,
                   contentDescription = null,
                   modifier = Modifier
                       .padding(16.dp, 8.dp)
                       .size(100.dp)
                       .clickable {

                       }
               )
           }
       }
//Images shown in horizontal scrolling way
//        LazyRow(){
//            items(selectImages) {  uri ->
//                Image(
//                    painter = rememberImagePainter(uri),
//                    contentScale = ContentScale.FillWidth,
//                    contentDescription = null,
//                    modifier = Modifier
//                        .padding(16.dp, 8.dp)
//                        .size(100.dp)
//                        .clickable {
//
//                        }
//                )
//            }
//        }
    }
}