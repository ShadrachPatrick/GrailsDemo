package grailsdemo

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class ProfessorServiceSpec extends Specification implements ServiceUnitTest<ProfessorService>{

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
