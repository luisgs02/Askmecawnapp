package com.askmecawnapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /***Android crea automáticamente esta función cuando se crea la clase de actividad*/
    override fun onCreate(savedInstanceState: Bundle?) {
        //Esta llama al constructor padre
        super.onCreate(savedInstanceState)

        //Esto se usa para alinear la vista xml a esta clase
        setContentView(R.layout.activity_main)

        // Para ocultar la barra de estado de hasta arriba.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        //Aquí se checa si nuestro EditText(et_name) está vacío, si es así, entonces manda mensaje que ingrese un nombre

        btn_start.setOnClickListener {
            if (et_name.text.toString().isEmpty()) {
                Toast.makeText(this@MainActivity, "Hey, introduce un nombre!", Toast.LENGTH_SHORT)
                    .show()
            } else {

                //En caso de que no este vacío el intent nos lleva a la siguiente Activity y cerramos la Main
                val intent = Intent(this@MainActivity, PreguntasActivity::class.java)

                //Pasa el nombre a través de la intención usando la variable constante que hemos creado.

                intent.putExtra(Constants.USER_NAME, et_name.text.toString())
                startActivity(intent) //Se inicia la actividad PreguntasActivity.
                finish() //Se finaliza la actividad actual (MainActivity) para que el usuario no pueda volver atrás utilizando el botón de retroceso.
            }
        }
    }
}