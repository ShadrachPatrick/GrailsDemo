package grailsdemo
import example.grails.User

class LoginController {

    def login() {
        if (request.method == 'POST') {
            def username = params.username
            def password = params.password

            if (username && password) {
                // Hier könnte man eine Überprüfung gegen eine Datenbank machen
                def user = User.findByUsernameAndPassword(username, password)
                if (user) {
                    session.user = user
                    println "user found"
                    redirect(action: 'welcome')
                } else {
                    println "user not found"
                    flash.message = 'Falscher Benutzername oder Passwort'
                    render view: '/index', model:[username:username, password:password]
                }
            }
            else {
                flash.message = 'Bitte Benutzername und Passwort eingeben'
                render view: '/index', model:[username:username, password:password]
            }
        }
    }

    def welcome() {
      if (!session.user) {
            println "user not found"
         redirect(action: 'welcome')
      }
   }

   def logout() {
      session.user = null
      redirect(action: 'index')
   }
}
