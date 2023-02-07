package grailsdemo.fakultaeten

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class FakultaetServiceSpec extends Specification {

    FakultaetService fakultaetService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Fakultaet(...).save(flush: true, failOnError: true)
        //new Fakultaet(...).save(flush: true, failOnError: true)
        //Fakultaet fakultaet = new Fakultaet(...).save(flush: true, failOnError: true)
        //new Fakultaet(...).save(flush: true, failOnError: true)
        //new Fakultaet(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //fakultaet.id
    }

    void "test get"() {
        setupData()

        expect:
        fakultaetService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Fakultaet> fakultaetList = fakultaetService.list(max: 2, offset: 2)

        then:
        fakultaetList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        fakultaetService.count() == 5
    }

    void "test delete"() {
        Long fakultaetId = setupData()

        expect:
        fakultaetService.count() == 5

        when:
        fakultaetService.delete(fakultaetId)
        sessionFactory.currentSession.flush()

        then:
        fakultaetService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Fakultaet fakultaet = new Fakultaet()
        fakultaetService.save(fakultaet)

        then:
        fakultaet.id != null
    }
}
