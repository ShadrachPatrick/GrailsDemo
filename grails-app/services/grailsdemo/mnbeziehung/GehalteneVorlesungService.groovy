package grailsdemo.mnbeziehung

import grails.gorm.services.Service

@Service(GehalteneVorlesung)
interface GehalteneVorlesungService {

    GehalteneVorlesung get(Serializable id)

    List<GehalteneVorlesung> list(Map args)

    Long count()

    void delete(Serializable id)

    GehalteneVorlesung save(GehalteneVorlesung gehalteneVorlesung)

}