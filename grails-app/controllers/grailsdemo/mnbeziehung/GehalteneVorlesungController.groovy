package grailsdemo.mnbeziehung

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class GehalteneVorlesungController {

    GehalteneVorlesungService gehalteneVorlesungService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond gehalteneVorlesungService.list(params), model:[gehalteneVorlesungCount: gehalteneVorlesungService.count()]
    }

    def show(Long id) {
        respond gehalteneVorlesungService.get(id)
    }

    def create() {
        respond new GehalteneVorlesung(params)
    }

    def save(GehalteneVorlesung gehalteneVorlesung) {
        if (gehalteneVorlesung == null) {
            notFound()
            return
        }

        try {
            gehalteneVorlesungService.save(gehalteneVorlesung)
        } catch (ValidationException e) {
            respond gehalteneVorlesung.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'gehalteneVorlesung.label', default: 'GehalteneVorlesung'), gehalteneVorlesung.id])
                redirect gehalteneVorlesung
            }
            '*' { respond gehalteneVorlesung, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond gehalteneVorlesungService.get(id)
    }

    def update(GehalteneVorlesung gehalteneVorlesung) {
        if (gehalteneVorlesung == null) {
            notFound()
            return
        }

        try {
            gehalteneVorlesungService.save(gehalteneVorlesung)
        } catch (ValidationException e) {
            respond gehalteneVorlesung.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'gehalteneVorlesung.label', default: 'GehalteneVorlesung'), gehalteneVorlesung.id])
                redirect gehalteneVorlesung
            }
            '*'{ respond gehalteneVorlesung, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        gehalteneVorlesungService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'gehalteneVorlesung.label', default: 'GehalteneVorlesung'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'gehalteneVorlesung.label', default: 'GehalteneVorlesung'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
