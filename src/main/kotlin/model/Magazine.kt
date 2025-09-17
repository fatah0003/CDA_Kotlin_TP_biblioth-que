package org.example.model

import org.example.interfaces.Consultable

class Magazine(titre: String, anneePublication: Int, var numero: Int) : Document(titre, anneePublication), Consultable {
    override fun afficherInfos() {
        println("$titre publié en $anneePublication N° $numero")
    }
}