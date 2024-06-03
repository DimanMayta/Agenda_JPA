<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : contactos
    Created on : 30 may. 2024, 17:13:57
    Author     : Diman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Contactos</title>
        <link rel="stylesheet" type="text/css" href="css/diman.css">
    </head>
    <body>
        <h1>Contactos</h1>
        <a href="MainController?action=nuevo" class="btn-nuv">Nuevo Contacto</a>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Correo</th>
                <th>Teléfono</th>
                <th colspan="2">Acciones</th>
            </tr>
            
            <c:forEach var="contacto" items="${contactos}">
                <tr>
                    <td>${contacto.id}</td>
                    <td>${contacto.nombre}</td>
                    <td>${contacto.correo}</td>
                    <td>${contacto.telefono}</td>
                    <td><a href="MainController?action=editar&id=${contacto.id}">Editar</a></td>
                    <td><a href="MainController?action=eliminar&id=${contacto.id}" onclick="return confirm('¿Está seguro de eliminar este producto?');" style="color: #CF726E">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
