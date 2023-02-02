package datatypes

class Adresse {
    String strasse
    String hausnummer
    String plz
    String ort

    static constraints = {
        strasse nullable: true
        hausnummer nullable: true
        plz nullable: true
        ort nullable: false
    }
}
