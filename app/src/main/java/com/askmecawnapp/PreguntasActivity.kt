package com.askmecawnapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class PreguntasActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1 // Default y la posicion de la primera pregunta,  Esta variable se utiliza para realizar un seguimiento de la posición actual de la pregunta.
    private var mQuestionsList: ArrayList<Pregunta>? = null  //Se inicializa como nula y se asignará más adelante.

    private var mSelectedOptionPosition: Int = 0 //Esta variable se utiliza para realizar un seguimiento de la opción seleccionada por el usuario.
    private var mCorrectAnswers: Int = 0 //Esta variable se utiliza para realizar un seguimiento del número de respuestas correctas del usuario.


    // Se obtiene el nombre del intent
    private var mUserName: String? = null  //Esta variable se utiliza para almacenar el nombre del usuario.

    /**
     * This function is auto created by Android when the Activity Class is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        //Esta llama al constructor de la clase padre AppCompatActivity para realizar las inicializaciones necesarias.
        super.onCreate(savedInstanceState)

        //Se establece el diseño de la actividad utilizando el archivo XML "activity_quiz_questions".
        setContentView(R.layout.activity_quiz_questions)


        // Se obtiene el nombre del usuario de los datos enviados a través del intent y se asigna a la variable mUserName.
        mUserName = intent.getStringExtra(Constants.USER_NAME)

        //Se llama al método getQuestions() de la clase Constants para obtener la lista de preguntas y se asigna a la variable mQuestionsList.
        mQuestionsList = Constants.getQuestions()

        setQuestion()  //Se llama al método setQuestion() para establecer la primera pregunta en la interfaz de usuario.


        // Se asigna el listener this a los elementos de la interfaz de usuario (opciones de respuesta y botón de envío) para capturar los eventos de clic.
        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {   //Se sobrescribe el método onClick de la interfaz View.OnClickListener, que se ejecuta cuando se hace clic en un elemento de la interfaz de usuario.


        //Dentro del bloque when, se manejan diferentes casos según el ID del elemento de la interfaz de usuario que se haya hecho clic. Se realizan acciones específicas según el caso, como seleccionar una opción de respuesta, enviar una respuesta y avanzar a la siguiente pregunta.
        when (v?.id) {

            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }

            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }

            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }

            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four, 4)
            }

            R.id.btn_submit -> {

                if (mSelectedOptionPosition == 0) {

                    mCurrentPosition++

                    when {

                        mCurrentPosition <= mQuestionsList!!.size -> {

                            setQuestion()
                        }
                        else -> {

                            // TODO (STEP 5: Now remove the toast message and launch the result screen which we have created and also pass the user name and score details to it.)
                            // START
                            val intent =
                                    Intent(this@PreguntasActivity, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                            // END
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    // Aquí checa si la pregunta contestada estuvo mal
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    else {
                        mCorrectAnswers++
                    }

                    // This is for correct answer
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList!!.size) {
                        btn_submit.text = "FINISH"
                    } else {
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    /**
     * A function for setting the question to UI components.
     */
    private fun setQuestion() {  //Se define una función llamada setQuestion() para establecer la pregunta actual en los componentes de la interfaz de usuario.

        // Se obtiene la pregunta actual de la lista de preguntas y se establece en los componentes de la interfaz de usuario (texto de la pregunta, imagen y opciones de respuesta). También se actualiza el texto del botón de envío según la posición actual.
        val question = mQuestionsList!!.get(mCurrentPosition - 1) // Obtener la pregunta de la lista con la ayuda de la posición actual.

        defaultOptionsView()

        if (mCurrentPosition == mQuestionsList!!.size) {
            btn_submit.text = "TERMINAR"
        } else {
            btn_submit.text = "ENVIAR"
        }

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.getMax()

        tv_question.text = question.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }

    //Se define la función selectedOptionView() que se utiliza para resaltar la opción seleccionada por el usuario en la interfaz de usuario.
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#363A43")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
                this@PreguntasActivity,
                R.drawable.selected_option_border_bg
        )
    }


    // Se define la función defaultOptionsView() que se utiliza para restablecer las opciones de respuesta a su apariencia predeterminada cuando se carga una nueva pregunta o cuando se vuelve a seleccionar una respuesta.
    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                    this@PreguntasActivity,
                    R.drawable.default_option_border_bg
            )
        }
    }

  // Se define la función answerView() que se utiliza para resaltar la respuesta correcta o incorrecta en la interfaz de usuario.
    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {

            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(
                        this@PreguntasActivity,
                        drawableView
                )
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(
                        this@PreguntasActivity,
                        drawableView
                )
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(
                        this@PreguntasActivity,
                        drawableView
                )
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(
                        this@PreguntasActivity,
                        drawableView
                )
            }
        }
    }
}