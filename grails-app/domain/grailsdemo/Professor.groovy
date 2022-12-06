package grailsdemo

class Professor {

    String vorname
    String nachname
    String kuerzel
    String raum
    String telefondurchwahl
    String bemerkungen

    static constraints = {
        vorname(blank:false)
        nachname(blank:false)
        kuerzel(blank:true, nullable:true)
        raum(blank:true, nullable:true)
        telefondurchwahl(blank:true, nullable:true)
        bemerkungen(blank:true, nullable:true, maxSize:2000, widget:'textarea')
    }

    String toString() {
        return "$nachname, $vorname"
    }

}
