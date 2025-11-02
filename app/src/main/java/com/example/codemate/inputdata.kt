package com.example.codemate

class inputdata {

    companion object {
        val title = mutableListOf<String>()
        val language = mutableListOf<String>()

        public  fun addEntry(name: String, description: String, code: String, option: String) {
            title.add(name)
            language.add(option)
        }
    }
}
