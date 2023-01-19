package com.example.ejercicio0

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLanzar: Button= findViewById(R.id.miBoton)
         var ejemplo=1

        lanzarDado()// inicia aleatorio

         btnLanzar.setOnClickListener{
           tiempo()
             val mp= MediaPlayer.create(this, R.raw.sondado)
            mp.start()
            }



    }

    private fun lanzarDado(){
        val recibenum: Int=numeroAlea(6) //llama a la función aleatoria
        val textoMostrado: TextView=findViewById(R.id.textView)
        textoMostrado.text=recibenum.toString()

       val ladoDelDado= when(recibenum){

            1-> R.drawable.l1
            2-> R.drawable.l2
            3-> R.drawable.l3
            4-> R.drawable.l4
            5-> R.drawable.l5
            6-> R.drawable.l6
            else ->  R.drawable.l6

        }
        val imgDado: ImageView=findViewById(R.id.imgDados)
        imgDado.setImageResource(ladoDelDado)



    }

    private fun numeroAlea(max: Int): Int{

       return (1..max).random()

    }

    private fun tiempo() {

        object : CountDownTimer(2000, 80){
            override fun onTick(millisUntilFinished: Long) {
                lanzarDado()
            }

            override fun onFinish() {

            }


        }.start()

    }


}