package grailsdemo.mnbeziehung

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class BetaProfessorController {

    BetaProfessorService betaProfessorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond betaProfessorService.list(params), model:[betaProfessorCount: betaProfessorService.count()]
    }

    def show(Long id) {
        respond betaProfessorService.get(id)
    }

    def create() {
        respond new BetaProfessor(params)
    }

    def save(BetaProfessor betaProfessor) {
        if (betaProfessor == null) {
            notFound()
            return
        }

        try {
            betaProfessorService.save(betaProfessor)
        } catch (ValidationException e) {
            respond betaProfessor.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'betaProfessor.label', default: 'BetaProfessor'), betaProfessor.id])
                redirect betaProfessor
            }
            '*' { respond betaProfessor, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond betaProfessorService.get(id)
    }

    def update(BetaProfessor betaProfessor) {
        if (betaProfessor == null) {
            notFound()
            return
        }

        try {
            betaProfessorService.save(betaProfessor)
        } catch (ValidationException e) {
            respond betaProfessor.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'betaProfessor.label', default: 'BetaProfessor'), betaProfessor.id])
                redirect betaProfessor
            }
            '*'{ respond betaProfessor, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        betaProfessorService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'betaProfessor.label', default: 'BetaProfessor'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'betaProfessor.label', default: 'BetaProfessor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
