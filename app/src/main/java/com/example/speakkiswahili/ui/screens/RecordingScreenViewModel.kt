package com.example.speakkiswahili.ui.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.speakkiswahili.data.repository.AudioRecorderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecordingScreenViewModel @Inject constructor(): ViewModel(){
    private val audioRecorderRepository = AudioRecorderRepository()
    private var recording = false
    private var playing = false

    fun startRecording(){
        if(!recording){
            audioRecorderRepository.startRecording()
            recording = true

        }
    }
    fun stopRecording(){
        if(recording){
            audioRecorderRepository.stopRecording()
            recording = false
        }
    }
    fun playRecording(){
        if(!playing){
            audioRecorderRepository.startPlaying()
            playing = true
        }
    }
    fun stopPlaying(){
        if(playing){
            audioRecorderRepository.stopPlaying()
            playing = false
        }
    }
}