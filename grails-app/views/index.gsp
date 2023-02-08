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
            <h1>Welcome to the Grails Workshop</h1>
    </div>

    <div class="container">

        <section class="row colset-2-its">
            <div id="controllers" role="navigation">
                <h2>Controller:</h2>
                <ul>
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                        <button class="controller">
                            <g:link controller="${c.logicalPropertyName}">${c.name}</g:link>
                        </button>
                    </g:each>
                </ul>
            </div>
        </section>
    </div>
</div>

</body>
</html>
