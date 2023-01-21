package com.example.dictogram.ModelClasses

class Definitions {
    private var definition: String
    private var example: String

    constructor(definition: String, example: String) {
        this.definition = definition
        this.example = example
    }

    public fun getDefinition(): String = this.definition
    public fun getExample(): String = this.example
}