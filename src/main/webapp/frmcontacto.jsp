<%-- 
    Document   : frmcontacto
    Created on : 30 may. 2024, 17:17:52
    Author     : Diman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Contacto</title>
        <link rel="stylesheet" type="text/css" href="css/diman.css">
    </head>
    <body>
        <h1>Formulario de Contacto</h1>
        <form action="MainController" method="post">
            <input type="hidden" name="id" value="${contacto.id == null ? 0 : contacto.id}" />
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" id="nombre" value="${contacto.nombre}" required /><br />
            <label for="correo">Correo:</label>
            <input type="email" name="correo" id="correo" value="${contacto.correo}" required /><br />
            <label for="telefono">Teléfono:</label>
            <input type="text" name="telefono" id="telefono" value="${contacto.telefono}" required /><br />
            <input type="submit" value="Guardar" />
        </form>
        <a href="MainController" class="btn cancel-btn">Cancelar</a>
    </body>
</html>
