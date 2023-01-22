package com.example.dictogram.ModelClasses

class Meanings {
    //Private Data Members
    private var partOfSpeech: String
    private var definitions: List<Definitions>

    //Parameterised Constructor
    constructor(partOfSpeech: String, definitions: List<Definitions>) {
        this.partOfSpeech = partOfSpeech
        this.definitions = definitions
    }

    //Getters
    public fun getPartOfSpeech(): String = this.partOfSpeech
    public fun getDefinitions(): List<Definitions> = this.definitions

    //Setters
    public fun setPartOfSpeech(partOfSpeech: String) {
        this.partOfSpeech = partOfSpeech
    }
    public fun setDefinitions(definitions: List<Definitions>) {
        this.definitions = definitions
    }
}