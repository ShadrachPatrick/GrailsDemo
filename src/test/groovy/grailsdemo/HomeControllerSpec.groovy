package grailsdemo

import grails.testing.web.controllers.ControllerUnitTest
import grailsdemo.example.grails.HomeController
import spock.lang.Specification

class HomeControllerSpec extends Specification implements ControllerUnitTest<HomeController> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
