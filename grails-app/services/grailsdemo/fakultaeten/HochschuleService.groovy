package grailsdemo.fakultaeten

import grails.gorm.services.Service

@Service(Hochschule)
interface HochschuleService {

    Hochschule get(Serializable id)

    List<Hochschule> list(Map args)

    Long count()

    void delete(Serializable id)

    Hochschule save(Hochschule hochschule)

}