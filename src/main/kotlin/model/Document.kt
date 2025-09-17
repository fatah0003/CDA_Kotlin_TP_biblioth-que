package org.example.model

abstract class Document(var titre: String, var anneePublication: Int) {
    abstract fun afficherInfos();
}