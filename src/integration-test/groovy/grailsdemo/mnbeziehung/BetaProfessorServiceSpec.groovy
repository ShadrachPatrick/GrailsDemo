package grailsdemo.mnbeziehung

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BetaProfessorServiceSpec extends Specification {

    BetaProfessorService betaProfessorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new BetaProfessor(...).save(flush: true, failOnError: true)
        //new BetaProfessor(...).save(flush: true, failOnError: true)
        //BetaProfessor betaProfessor = new BetaProfessor(...).save(flush: true, failOnError: true)
        //new BetaProfessor(...).save(flush: true, failOnError: true)
        //new BetaProfessor(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //betaProfessor.id
    }

    void "test get"() {
        setupData()

        expect:
        betaProfessorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<BetaProfessor> betaProfessorList = betaProfessorService.list(max: 2, offset: 2)

        then:
        betaProfessorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        betaProfessorService.count() == 5
    }

    void "test delete"() {
        Long betaProfessorId = setupData()

        expect:
        betaProfessorService.count() == 5

        when:
        betaProfessorService.delete(betaProfessorId)
        sessionFactory.currentSession.flush()

        then:
        betaProfessorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        BetaProfessor betaProfessor = new BetaProfessor()
        betaProfessorService.save(betaProfessor)

        then:
        betaProfessor.id != null
    }
}
