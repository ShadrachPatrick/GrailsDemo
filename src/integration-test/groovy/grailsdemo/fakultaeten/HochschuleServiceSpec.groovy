package grailsdemo.fakultaeten

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class HochschuleServiceSpec extends Specification {

    HochschuleService hochschuleService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Hochschule(...).save(flush: true, failOnError: true)
        //new Hochschule(...).save(flush: true, failOnError: true)
        //Hochschule hochschule = new Hochschule(...).save(flush: true, failOnError: true)
        //new Hochschule(...).save(flush: true, failOnError: true)
        //new Hochschule(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //hochschule.id
    }

    void "test get"() {
        setupData()

        expect:
        hochschuleService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Hochschule> hochschuleList = hochschuleService.list(max: 2, offset: 2)

        then:
        hochschuleList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        hochschuleService.count() == 5
    }

    void "test delete"() {
        Long hochschuleId = setupData()

        expect:
        hochschuleService.count() == 5

        when:
        hochschuleService.delete(hochschuleId)
        sessionFactory.currentSession.flush()

        then:
        hochschuleService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Hochschule hochschule = new Hochschule()
        hochschuleService.save(hochschule)

        then:
        hochschule.id != null
    }
}
