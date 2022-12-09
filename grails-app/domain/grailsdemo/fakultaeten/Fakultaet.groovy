package grailsdemo.fakultaeten

class Fakultaet {
    String name
    String kuerzel
    static belongsTo=[hochschule:Hochschule] // n:1-Beziehung
    static constraints = {
        name nullable:false, blank:false
        kuerzel nullable:false, blank: false
        hochschule nullable:false // Muss-Beziehung
    }
    String toString() {
        name
    }
}
