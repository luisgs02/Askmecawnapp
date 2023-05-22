package com.askmecawnapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Se oculta la barra de estado en la parte superior de la pantalla y se obtienen los detalles del intent y se establecen en la interfaz de usuario.

        // Esta línea se utiliza para ocultar la barra de estado en la parte superior de la pantalla y ocupar todo el espacio disponible
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN


        val userName = intent.getStringExtra(Constants.USER_NAME) // Se obtiene el nombre del usuario del intent utilizando la constante USER_NAME definida en otra clase llamada Constants.
        tv_name.text = userName    //Se establece el nombre del usuario en el TextView

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)  //Se obtiene el número total de preguntas del intent utilizando la constante TOTAL_QUESTIONS
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)  //Se obtiene el número de respuestas correctas del intent utilizando la constante CORRECT_ANSWERS.

        tv_score.text = "Tu score es $correctAnswers de $totalQuestions."   //Se establece el texto del TextView tv_score con el puntaje del usuario.


        //Se configura un click listener para el botón "btn_finish". Cuando se hace clic en el botón, se inicia la actividad MainActivity.
        btn_finish.setOnClickListener {
            startActivity(Intent(this@ResultActivity, MainActivity::class.java))
        }
    }
}