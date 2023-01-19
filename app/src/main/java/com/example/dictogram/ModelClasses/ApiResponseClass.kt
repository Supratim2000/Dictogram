package com.example.dictogram.ModelClasses

class ApiResponseClass {
    private val word: String
    private val phonetic: String
    private val phonetics: ArrayList<Phonetics>
    private val origin: String
    private val meanings: ArrayList<Meanings>
}