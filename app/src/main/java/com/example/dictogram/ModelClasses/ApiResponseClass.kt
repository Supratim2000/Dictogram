package com.example.dictogram.ModelClasses

class ApiResponseClass {
    //Private Data Members
    private var word: String
    private var phonetics: List<Phonetics>
    private var meanings: List<Meanings>
    private var license: License
    private var sourceUrls: List<String>


    //Parameterised Constructor
    constructor(word: String, phonetics: List<Phonetics>, meanings: List<Meanings>, license: License, sourceUrls: List<String>) {
        this.word = word
        this.phonetics = phonetics
        this.meanings = meanings
        this.license = license
        this.sourceUrls = sourceUrls
    }

    //Getters
    public fun getWord(): String = this.word
    public fun getPhonetics(): List<Phonetics> = this.phonetics
    public fun getMeanings(): List<Meanings> = this.meanings
    public fun getLicense(): License = this.license
    public fun getSourceUrls(): List<String> = this.sourceUrls

    //Setters
    public fun setWord(word: String){
        this.word = word
    }
    public fun setPhonetics(phonetics: List<Phonetics>) {
        this.phonetics = phonetics
    }
    public fun setMeanings(meanings: List<Meanings>) {
        this.meanings = meanings
    }
    public fun setLicense(license: License) {
        this.license = license
    }
    public fun setSourceUrls(sourceUrls: List<String>) {
        this.sourceUrls = sourceUrls
    }
}