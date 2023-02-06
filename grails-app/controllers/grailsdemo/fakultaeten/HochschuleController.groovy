package grailsdemo.fakultaeten

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class HochschuleController {

    HochschuleService hochschuleService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond hochschuleService.list(params), model:[hochschuleCount: hochschuleService.count()]
    }

    def show(Long id) {
        respond hochschuleService.get(id)
    }

    def create() {
        respond new Hochschule(params)
    }

    def save(Hochschule hochschule) {
        if (hochschule == null) {
            notFound()
            return
        }

        try {
            hochschuleService.save(hochschule)
        } catch (ValidationException e) {
            respond hochschule.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'hochschule.label', default: 'Hochschule'), hochschule.id])
                redirect hochschule
            }
            '*' { respond hochschule, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond hochschuleService.get(id)
    }

    def update(Hochschule hochschule) {
        if (hochschule == null) {
            notFound()
            return
        }

        try {
            hochschuleService.save(hochschule)
        } catch (ValidationException e) {
            respond hochschule.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'hochschule.label', default: 'Hochschule'), hochschule.id])
                redirect hochschule
            }
            '*'{ respond hochschule, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        hochschuleService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'hochschule.label', default: 'Hochschule'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'hochschule.label', default: 'Hochschule'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
