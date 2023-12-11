package com.example.constraintviewpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.voice.VoiceInteractionSession.ActivityId
import android.widget.Button
import java.lang.Math.random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonToGo:Button = findViewById(R.id.buttonToGo)
        val randomNumber = (0..100).random()
        buttonToGo.setOnClickListener{
            val intent:Intent = Intent(this,MainActivity2::class.java)
            intent.putExtra("randomNumber",randomNumber)
            startActivity(intent)
        }




    }
}