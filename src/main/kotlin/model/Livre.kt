package org.example.model

import org.example.enum.Genre
import org.example.exception.DocumentDejaEmprunteException
import org.example.exception.DocumentNonEmprunteException
import org.example.interfaces.Consultable
import org.example.interfaces.Empruntable

class Livre(titre: String, anneePublication: Int, var auteur: String, var nbPages: Int, var genre: Genre):
    Document(titre, anneePublication), Empruntable, Consultable {
    constructor(titre: String, auteur: String, genre: Genre) :
            this(titre, 0, auteur, 100, genre )

    override fun afficherInfos() {
        println("Livre: $titre du genre $genre ecrit par $auteur en $anneePublication à $nbPages pages "  )
    }
    override var estEmprunte: Boolean = false

    override fun emprunter() {
        if (!estEmprunte) {
            estEmprunte = true
            println("Emprunt réussi !")
        } else {
            throw DocumentDejaEmprunteException("livre est deja emprunté")
        }
    }

    override fun rendre() {
        if (estEmprunte) {
            estEmprunte = false
            println("Le livre est maintenant disponible.")
        } else {
            throw DocumentNonEmprunteException("document pas emprunté")
        }
    }

}