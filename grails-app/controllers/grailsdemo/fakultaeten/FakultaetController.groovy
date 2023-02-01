package grailsdemo.fakultaeten

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class FakultaetController {

    FakultaetService fakultaetService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond fakultaetService.list(params), model:[fakultaetCount: fakultaetService.count()]
    }

    def show(Long id) {
        respond fakultaetService.get(id)
    }

    def create() {
        respond new Fakultaet(params)
    }

    def save(Fakultaet fakultaet) {
        if (fakultaet == null) {
            notFound()
            return
        }

        try {
            fakultaetService.save(fakultaet)
        } catch (ValidationException e) {
            respond fakultaet.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'fakultaet.label', default: 'Fakultaet'), fakultaet.id])
                redirect fakultaet
            }
            '*' { respond fakultaet, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond fakultaetService.get(id)
    }

    def update(Fakultaet fakultaet) {
        if (fakultaet == null) {
            notFound()
            return
        }

        try {
            fakultaetService.save(fakultaet)
        } catch (ValidationException e) {
            respond fakultaet.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'fakultaet.label', default: 'Fakultaet'), fakultaet.id])
                redirect fakultaet
            }
            '*'{ respond fakultaet, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        fakultaetService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'fakultaet.label', default: 'Fakultaet'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'fakultaet.label', default: 'Fakultaet'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
