package com.askmecawnapp


//Se hace un data class con las diferentes 4 opciones de respuesta
data class Pregunta(
    val id: Int,
    val question: String,
    val image: Int,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int
)