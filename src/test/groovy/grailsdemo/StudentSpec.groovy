package grailsdemo

import grails.testing.gorm.DomainUnitTest
import grailsdemo.student.Student
import spock.lang.Specification

class StudentSpec extends Specification implements DomainUnitTest<Student> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
