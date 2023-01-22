package com.example.dictogram.ModelClasses

class License {
    //Private Data Members
    private var name: String
    private var url: String

    //Parameterised Constructor
    constructor(name: String, url: String) {
        this.name = name
        this.url = url
    }

    //Getters
    public fun getName(): String = this.name
    public fun getUrl(): String = this.url

    //Setters
    public fun setName(name: String) {
        this.name = name
    }
    public fun setUrl(url: String) {
        this.url = url
    }
}