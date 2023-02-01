package grailsdemo.mnbeziehung

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class VorlesungController {

    VorlesungService vorlesungService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vorlesungService.list(params), model:[vorlesungCount: vorlesungService.count()]
    }

    def show(Long id) {
        respond vorlesungService.get(id)
    }

    def create() {
        respond new Vorlesung(params)
    }

    def save(Vorlesung vorlesung) {
        if (vorlesung == null) {
            notFound()
            return
        }

        try {
            vorlesungService.save(vorlesung)
        } catch (ValidationException e) {
            respond vorlesung.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vorlesung.label', default: 'Vorlesung'), vorlesung.id])
                redirect vorlesung
            }
            '*' { respond vorlesung, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vorlesungService.get(id)
    }

    def update(Vorlesung vorlesung) {
        if (vorlesung == null) {
            notFound()
            return
        }

        try {
            vorlesungService.save(vorlesung)
        } catch (ValidationException e) {
            respond vorlesung.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vorlesung.label', default: 'Vorlesung'), vorlesung.id])
                redirect vorlesung
            }
            '*'{ respond vorlesung, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vorlesungService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vorlesung.label', default: 'Vorlesung'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vorlesung.label', default: 'Vorlesung'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
