package grailsdemo

class LoginController {

    def index() { }

    // Nur eine Controller-Aktion definiert  ist Default Controller-Aktion
    def login(String user, String password) {
        if (user == "specht" && password == "specht") { // Login korrekt

            // Eingeloggten Benutzer merken
            session.user = user
            session.password = password

            // Navigationsherkunft abrufen und in Session-Variablen löschen
            def fromController = session.fromController
            def fromAction = session.fromAction
            def fromParams = session.fromParams
            session.fromController = null
            session.fromAction = null
            session.fromParams = null

            if (fromController && fromAction && fromParams) {
                redirect controller:fromController, action:fromAction, params:fromParams
            }
            else if (fromController && fromAction) {
                redirect controller:fromController, action:fromAction
            }
            else if (fromController) {
                redirect controller:fromController
            }
            else { // Über Controllerauswahlseite eingestiegen
                redirect uri: ""
            }
        } else {
            if (user || password) { // Falscher User / Passwort bereits eingetragen
                flash.message = "Login oder Passwort falsch!"
            }
            // login.gsp nochmal mit ggf. vorhandenen Eingaben rendern
            render view: 'login', model:[user:user, password:password]
        }
    }
}
