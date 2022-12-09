package grailsdemo.mnbeziehung

class GehalteneVorlesung {
    String semester
    static belongsTo = [professor: Professor, vorlesung: Vorlesung]
    static constraints = {
        professor nullable: false
        vorlesung nullable: false
        semester nullable: true, blank: true
    }

    String toString() {
        "$vorlesung im $semester bei $professor"
    }
}
