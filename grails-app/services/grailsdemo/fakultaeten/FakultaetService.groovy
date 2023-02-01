package grailsdemo.fakultaeten

import grails.gorm.services.Service

@Service(Fakultaet)
interface FakultaetService {

    Fakultaet get(Serializable id)

    List<Fakultaet> list(Map args)

    Long count()

    void delete(Serializable id)

    Fakultaet save(Fakultaet fakultaet)

}