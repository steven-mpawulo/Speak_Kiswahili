package com.example.speakkiswahili.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.speakkiswahili.data.repository.AudioRecorderRepository

const val TAG = "RecordingScreen"
@Composable
fun RecordingScreen(
) {
    val audioRecorderRepository = AudioRecorderRepository()
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = {
            audioRecorderRepository.startRecording()
            Log.d(TAG, "Start recording")
        }, modifier = Modifier
            .height(40.dp)
            .width(240.dp)
        ) {
            Text(text = "Start Recording")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            audioRecorderRepository.stopRecording()
            Log.d(TAG, "Stop recording")
        },
        modifier = Modifier
            .height(40.dp)
            .width(240.dp)
        ) {
            Text(text = "Stop Recording")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            audioRecorderRepository.startPlaying()
            Log.d(TAG, "Start playing")
        }, modifier = Modifier
            .height(40.dp)
            .width(240.dp)
        ) {
            Text(text = "Play audio")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            audioRecorderRepository.stopPlaying()
            Log.d(TAG, "Stop playing")
        }, modifier = Modifier
            .height(40.dp)
            .width(240.dp)
        ) {
            Text(text = "Stop playing")
        }
    }
}