package grailsdemo.mnbeziehung

import grails.gorm.services.Service

@Service(BetaProfessor)
interface BetaProfessorService {

    BetaProfessor get(Serializable id)

    List<BetaProfessor> list(Map args)

    Long count()

    void delete(Serializable id)

    BetaProfessor save(BetaProfessor betaProfessor)

}