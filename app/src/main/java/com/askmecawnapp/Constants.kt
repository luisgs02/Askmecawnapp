package com.askmecawnapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"


    //Esta es la función que me va regresar todos las valores
    fun getQuestions(): ArrayList<Pregunta> {

        //Aquí se crea una variable questionsList tipo ArrayList que inicialmente está vacio pero que en cada pregunta se va llenando y al final lo retorna
        val questionsList = ArrayList<Pregunta>()

        // Pregunta numero 1
        val que1 = Pregunta(
            1,
            "¿A qué país pertenece esta bandera?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            1
        )
        questionsList.add(que1)

        // Pregunto numero 2
        val que2 = Pregunta(
            2,
            "¿A qué país pertenece esta bandera??",
            R.drawable.ic_flag_of_australia,
            "Angola",
            "Austria",
            "Australia",
            "Armenia",
            3
        )
        questionsList.add(que2)

        // 3
        val que3 = Pregunta(
            3,
            "¿A qué país pertenece esta bandera??",
            R.drawable.ic_flag_of_brazil,
            "Belarus",
            "Belize",
            "Brunei",
            "Brazil",
            4
        )

        questionsList.add(que3)

        // Pregunta numero 4
        val que4 = Pregunta(
            4,
            "¿A qué país pertenece esta bandera??",
            R.drawable.ic_flag_of_belgium,
            "Bahamas",
            "Belgium",
            "Barbados",
            "Belize",
            2
        )

        questionsList.add(que4)

        // Pregunta numero 5
        val que5 = Pregunta(
            5,
            "¿A qué país pertenece esta bandera??",
            R.drawable.ic_flag_of_fiji,
            "Gabon",
            "France",
            "Fiji",
            "Finland",
            3
        )

        questionsList.add(que5)

        // Pregunta numero 6
        val que6 = Pregunta(
            6,
            "¿A qué país pertenece esta bandera??",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "Georgia",
            "Greece",
            "none of these",
            1
        )

        questionsList.add(que6)

       // Pregunta numero 7
        val que7 = Pregunta(
            7,
            "¿A qué país pertenece esta bandera??",
            R.drawable.ic_flag_of_denmark,
            "Dominica",
            "Egypt",
            "Denmark",
            "Ethiopia",
            3
        )

        questionsList.add(que7)

        // Pregunta numero 8
        val que8 = Pregunta(
            8,
            "¿A qué país pertenece esta bandera??",
            R.drawable.ic_flag_of_india,
            "Ireland",
            "Iran",
            "Hungary",
            "India",
            4
        )

        questionsList.add(que8)

        // Pregunta numero 9
        val que9 = Pregunta(
            9,
            "¿A qué país pertenece esta bandera?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia",
            "New Zealand",
            "Tuvalu",
            "United States of America",
            2
        )

        questionsList.add(que9)

        // Pregunta numero 10
        val que10 = Pregunta(
            10,
            "¿A qué país pertenece esta bandera?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait",
            "Jordan",
            "Sudan",
            "Palestine",
            1
        )
        questionsList.add(que10)

        return questionsList
    }
}