package com.example.dictogram.ModelClasses

class Phonetics {
    private var text: String
    private var audio: String

    constructor(text: String, audio: String) {
        this.text = text
        this.audio = audio
    }

    public fun getText(): String = this.text
    public fun getAudio(): String = this.audio
}