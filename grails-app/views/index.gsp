<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails Workshop</title>
</head>
<body>
<content tag="nav">
</content>

<div id="content" role="main">
    <div class="d-flex justify-content-center">
            <h1>Welcome to Grails Workshop</h1>
    </div>

    <div class="container">

        <section class="row colset-2-its">
            <div id="controllers" role="navigation">
                <h2>Available Controllers:</h2>
                <ul>
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                        <li class="controller">
                            <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>
                        </li>
                    </g:each>
                </ul>
            </div>
        </section>
    </div>
</div>

</body>
</html>
