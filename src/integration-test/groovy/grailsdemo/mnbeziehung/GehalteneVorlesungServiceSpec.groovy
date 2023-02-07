package grailsdemo.mnbeziehung

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class GehalteneVorlesungServiceSpec extends Specification {

    GehalteneVorlesungService gehalteneVorlesungService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new GehalteneVorlesung(...).save(flush: true, failOnError: true)
        //new GehalteneVorlesung(...).save(flush: true, failOnError: true)
        //GehalteneVorlesung gehalteneVorlesung = new GehalteneVorlesung(...).save(flush: true, failOnError: true)
        //new GehalteneVorlesung(...).save(flush: true, failOnError: true)
        //new GehalteneVorlesung(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //gehalteneVorlesung.id
    }

    void "test get"() {
        setupData()

        expect:
        gehalteneVorlesungService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<GehalteneVorlesung> gehalteneVorlesungList = gehalteneVorlesungService.list(max: 2, offset: 2)

        then:
        gehalteneVorlesungList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        gehalteneVorlesungService.count() == 5
    }

    void "test delete"() {
        Long gehalteneVorlesungId = setupData()

        expect:
        gehalteneVorlesungService.count() == 5

        when:
        gehalteneVorlesungService.delete(gehalteneVorlesungId)
        sessionFactory.currentSession.flush()

        then:
        gehalteneVorlesungService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        GehalteneVorlesung gehalteneVorlesung = new GehalteneVorlesung()
        gehalteneVorlesungService.save(gehalteneVorlesung)

        then:
        gehalteneVorlesung.id != null
    }
}
