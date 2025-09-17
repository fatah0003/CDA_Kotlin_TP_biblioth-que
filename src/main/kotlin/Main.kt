package org.example

import org.example.enum.Genre
import org.example.exception.DocumentDejaEmprunteException
import org.example.exception.DocumentNonEmprunteException
import org.example.model.Document
import org.example.model.Livre
import org.example.model.Magazine
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val livre1 = Livre("Le seigneur des anneaux", "Tolkien", Genre.SCIENCE_FICTION)
    val mag1 = Magazine("Science & Vie", 2023, 12)

    val livre2 = Livre("le mont charge", "dard", Genre.ROMAN)
    val mag2 = Magazine("sport", 2000, 8)

   var mesdocs = mutableListOf<Document>()
    mesdocs.add(livre2)
    mesdocs.add(mag2)
    mesdocs.add(livre1)
    mesdocs.add(mag1)

    for (m in mesdocs) {
        m.afficherInfos()
    }

    livre1.consulter()
    mag1.consulter()
    try {
        livre2.emprunter()
    } catch (e: DocumentDejaEmprunteException) {
        println(e.message)
    }

    try {
        livre2.emprunter()
    } catch (e: DocumentDejaEmprunteException) {
        println(e.message)
    }

    try {
        livre1.rendre()
    } catch (e: DocumentNonEmprunteException) {
        println(e.message)
    }
    try {
        livre2.rendre()
    } catch (e: DocumentNonEmprunteException) {
        println(e.message)
    }
}