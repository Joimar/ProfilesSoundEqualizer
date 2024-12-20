package com.example.profilessoundequalizer

import android.R.attr.minLevel
import android.media.audiofx.Equalizer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.ui.AppBarConfiguration


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //val appBarConfiguration = AppBarConfiguration(navController.graph)
        var button1:Button = findViewById(R.id.button1)
        var button2:Button = findViewById(R.id.button2)

        var equalizer: Equalizer = Equalizer(0,0)

        var numberOfBands:Short = equalizer.numberOfBands
        var freqRange = equalizer.bandLevelRange
        Log.e("TESTE Debug", "Number of Bands $numberOfBands");
        //equalizer.setBa

//        for (i in numberOfBands - 3 until numberOfBands) {
//            equalizer.setBandLevel(i.toShort(), minLevel.toShort())
//        }
        Log.e("Intensidade do som Mínima", freqRange[0].toString())
        Log.e("Intensidade do som Máxima", freqRange[1].toString())

        button1.setOnClickListener {
            for(i in 0 until numberOfBands){
                equalizer.setBandLevel(i.toShort(), freqRange[0])
                equalizer.setEnabled(true)
            }
        }

        button2.setOnClickListener {
            for(i in 0 until numberOfBands){
                equalizer.setBandLevel(i.toShort(), (freqRange[1]/2).toShort())
                equalizer.setEnabled(true)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}