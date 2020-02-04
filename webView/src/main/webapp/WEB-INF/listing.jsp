<!-- Les fichiers enregistré dans WEB-INF sont seulement accessible par les servlets -->

<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Utilisateurs</title>
    </head>

    <body>
        <h1>Mes utilisateurs</h1>
        <ul>
            <c:forEach items="${users}" var="element">
                <li>
                    ${element.firstName} ${element.lastName}
                </li>
            </c:forEach>
        </ul>
    </body>
</html>