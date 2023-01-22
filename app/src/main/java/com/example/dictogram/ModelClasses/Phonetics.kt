package com.example.dictogram.ModelClasses

class Phonetics {
    //Private Data Members
    private var text: String
    private var audio: String

    //Parameterised Constructor
    constructor(text: String, audio: String) {
        this.text = text
        this.audio = audio
    }

    //Getters
    public fun getText(): String = this.text
    public fun getAudio(): String = this.audio

    //Setters
    public fun setText(text: String) {
        this.text = text
    }
    public fun setAudio(audio: String) {
        this.audio = audio
    }
}