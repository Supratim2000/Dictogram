package com.example.dictogram.ModelClasses

class Definitions {
    //Private Data Members
    private var definition: String
    private var example: String

    //Parameterised Constructor
    constructor(definition: String, example: String) {
        this.definition = definition
        this.example = example
    }

    //Getters
    public fun getDefinition(): String = this.definition
    public fun getExample(): String = this.example

    //Setters
    public fun setDefinition(definition: String) {
        this.definition = definition
    }
    public fun getExample(example: String) {
        this.example = example
    }
}