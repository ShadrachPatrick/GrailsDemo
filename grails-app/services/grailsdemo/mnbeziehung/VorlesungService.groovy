package grailsdemo.mnbeziehung

import grails.gorm.services.Service

@Service(Vorlesung)
interface VorlesungService {

    Vorlesung get(Serializable id)

    List<Vorlesung> list(Map args)

    Long count()

    void delete(Serializable id)

    Vorlesung save(Vorlesung vorlesung)

}