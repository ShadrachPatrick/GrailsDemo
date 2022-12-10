package grailsdemo.mnbeziehung

class BetaProfessor {

    String vorname
    String nachname
    static hasMany = [vorlesung:Vorlesung]

    static constraints = {
        vorname nullable: false, blank: false
        nachname nullable: false, blank: false
    }
    String toString() {
        "$vorname $nachname"
    }
}
