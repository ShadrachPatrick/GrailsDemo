package grailsdemo.mnbeziehung

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VorlesungServiceSpec extends Specification {

    VorlesungService vorlesungService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Vorlesung(...).save(flush: true, failOnError: true)
        //new Vorlesung(...).save(flush: true, failOnError: true)
        //Vorlesung vorlesung = new Vorlesung(...).save(flush: true, failOnError: true)
        //new Vorlesung(...).save(flush: true, failOnError: true)
        //new Vorlesung(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vorlesung.id
    }

    void "test get"() {
        setupData()

        expect:
        vorlesungService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Vorlesung> vorlesungList = vorlesungService.list(max: 2, offset: 2)

        then:
        vorlesungList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vorlesungService.count() == 5
    }

    void "test delete"() {
        Long vorlesungId = setupData()

        expect:
        vorlesungService.count() == 5

        when:
        vorlesungService.delete(vorlesungId)
        sessionFactory.currentSession.flush()

        then:
        vorlesungService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Vorlesung vorlesung = new Vorlesung()
        vorlesungService.save(vorlesung)

        then:
        vorlesung.id != null
    }
}
