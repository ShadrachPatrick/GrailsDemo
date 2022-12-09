package grailsdemo.fakultaeten

class Hochschule {
    String name
    String ort
    static hasMany=[fakultaeten:Fakultaet] // 1:n-Beziehung
    static constraints = {
        name nullable: false, blank: false
        ort nullable:false, blank:false
        fakultaeten nullable: true // Kann-Beziehung
    }
    String toString() { // Benötigt für Auswahlliste der Hochschule in Fakultäts-GSP
        "$name $ort"
    }
}
