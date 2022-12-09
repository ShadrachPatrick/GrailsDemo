package grailsdemo.mnbeziehung

class Vorlesung {

    String name
    String kuerzel
    static hasMany = [gehalteneVorlesung:GehalteneVorlesung]
    static constraints = {
        name nullable: false, blank: false
        kuerzel nullable: false, blank: false
        gehalteneVorlesung nullable: true
    }
    String toString() {
        name
    }
}
