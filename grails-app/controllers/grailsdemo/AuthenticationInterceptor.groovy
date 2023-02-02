package grailsdemo


class AuthenticationInterceptor {

    AuthenticationInterceptor(){
        match controller:~/([Ll]ogin)?+.+/, action:~/(login)?+.+/
    }

    boolean before() {
        println "Controllername: ${controllerName}"
        println "Action-Name: ${actionName}"
        println "Before-Interceptor"
        if (!session.user) {
            session.fromController = controllerName
            session.fromAction = actionName
            session.fromParams = this.params
            redirect controller:'Login', action: 'login'
        }
        true
    }

    boolean after() {
        println "After-Interceptor"
        true
    }

    void afterView() {
        // no-op
    }
}
