package grailsdemo.student

import datatypes.Adresse

class Student {
    String vorname
    String nachname
    Adresse adresse // 0..1:1-Beziehung
    static constraints = {
        vorname nullable:false, blank: false
        nachname nullable: false, blank: false
        adresse nullable:false // Muss-Beziehung
    }

    static embedded = ['adresse']

    String toString() {
        "$vorname $nachname"
    }
}