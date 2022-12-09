package grailsdemo.fakultaeten

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class FakultaetSpec extends Specification implements DomainUnitTest<Fakultaet> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
