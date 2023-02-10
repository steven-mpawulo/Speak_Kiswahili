package com.example.speakkiswahili.data.repository

import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Build
import android.os.Environment
import android.util.Log
import androidx.annotation.RequiresApi
import java.io.File
import java.io.IOException
const val TAG = "AudioRecorderRepository"
class AudioRecorderRepository{
    private var recording : Boolean = false
    private var playing : Boolean = false
    private lateinit var error: IOException
    private val recorder = MediaRecorder()
    private val player = MediaPlayer()
    private fun getFilePath():String{
        val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC), "recording.mp3")
        return file.absolutePath
    }

    fun startRecording(){
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC)
        recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
        recorder.setOutputFile(getFilePath())
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
        if(!recording){
           try{
               recorder.prepare()
               recorder.start()
               recording = true

           }catch (e: IOException){
               Log.e(TAG, "prepare() Failed", e)
           }
        }
    }
    fun stopRecording(){
        if(recording){
            recorder.stop()
            recorder.release()
            recording = false
        }
    }
    fun startPlaying(){
        if(!playing){
            try {
                player.setDataSource(getFilePath())
                player.prepare()
                player.start()
                playing = true
            }catch(e : IOException){
                Log.e(TAG, "prepare() Failed", e)
            }
        }

    }
    fun stopPlaying(){
        if(playing){
            player.stop()
            player.release()
            playing = false
        }


    }
}