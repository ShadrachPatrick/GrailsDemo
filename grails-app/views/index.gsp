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
      <div id="list-professor" class="content" >
      <section class="row colset-2-its">
        <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:form controller="login" action="login" method="post">
                <table>
                <tr>
                    <td>Username:</td>
                    <td>
                        <g:textField name="user" value="${user}"></g:textField>
                    </td>
                </tr>
                <tr>
                    <td>Passwort:</td>
                    <td>
                        <g:passwordField name="password" value="${password}"></g:passwordField>
                    </td>
                </tr>
                </table>
                <fieldset class="buttons">
                <g:submitButton name="Login" value="Login" />
                </fieldset>
            </g:form>
      </section>
      </div>
   </body>
</html>