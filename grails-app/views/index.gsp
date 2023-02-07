<!DOCTYPE html>
<html>
   <head>
      <meta name="layout" content="main">
      <title>Login</title>
   </head>
   <body>
      <div class="nav" >
         <ul>
            <li>
               <a class="home" href="${createLink(uri: '/')}">
                  <g:message code="default.home.label"/>
               </a>
            </li>
         </ul>
      </div>
      <div id="list-professor" class="content mt-5 px-lg-5" >
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
        <div class="col-lg-5 col-md-6">
            <g:form controller="login" action="login" method="post">
                <!-- Email input -->
                <div class="form-outline mb-4">
                    <g:textField name="username" value="${username}"></g:textField>
                    <label class="form-label" for="form2Example1">Username</label>
                </div>

                <!-- Password input -->
                <div class="form-outline mb-4">
                    <g:passwordField name="password" value="${password}"></g:passwordField>
                    <label class="form-label" for="form2Example2">Password</label>
                </div>

                <!-- 2 column grid layout for inline styling -->
                <div class="row mb-4">
                    <div class="col d-flex justify-content-center">
                    <!-- Checkbox -->
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked />
                        <label class="form-check-label" for="form2Example31"> Remember me </label>
                    </div>
                    </div>

                    <div class="col">
                    <!-- Simple link -->
                    <a href="#!">Forgot password?</a>
                    </div>
                </div>

                <!-- Submit button -->
                <g:submitButton name="Sign in" class="btn btn-dark btn-block mb-4"/>

                <!-- Register buttons -->
                <div class="text-center">
                    <p>Not a member? <a href="#!">Register</a></p>
                </div>
         </g:form>
        </div>
      </div>
   </body>
</html>