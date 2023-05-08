package com.example.kotlinmultiplatformapp.android

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

class PickImageFromGalleryInJetpackCompose : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme() {
                var selectedImages by remember { mutableStateOf(listOf<Uri>()) }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    pickImageFromGalleryInJetpackCompose()
                }
            }
        }
    }
}

@Composable
fun pickImageFromGalleryInJetpackCompose(){

    //var selectedImages by remember { mutableStateOf<Uri?>(null) }
    var selectedImages by remember { mutableStateOf(listOf<Uri?>(null)) }

    val multiplePhotoPickerLauncher = rememberLauncherForActivityResult(
        //lets the user select up to 5 media files
        // contract = ActivityResultContracts.PickMultipleVisualMedia(5),
        contract = ActivityResultContracts.PickMultipleVisualMedia(),
        onResult = { uris -> selectedImages = uris })

    MainContent(selectedImages) {
        multiplePhotoPickerLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }
}

@Composable
private fun MainContent(
    selectedImages: List<Uri?> ,
    onImageClick: () -> Unit)
{
Scaffold() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(it),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
            OutlinedButton(onClick = onImageClick) {
                Text(text = stringResource(id = R.string.select_photos))
            }
        LazyColumn(){
            items(selectedImages) {  uri ->
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
    }
}
}