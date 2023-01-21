package com.example.dictogram.ModelClasses

class License {
    private var name: String
    private var url: String

    constructor(name: String, url: String) {
        this.name = name
        this.url = url
    }

    public fun getName(): String = this.name
    public fun getUrl(): String = this.url
}