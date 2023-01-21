package com.example.dictogram.ModelClasses

class Meanings {
    private var partOfSpeech: String
    private var definitions: List<Definitions>

    constructor(partOfSpeech: String, definitions: List<Definitions>) {
        this.partOfSpeech = partOfSpeech
        this.definitions = definitions
    }

    public fun getPartOfSpeech(): String = this.partOfSpeech
    public fun getDefinitions(): List<Definitions> = this.definitions
}