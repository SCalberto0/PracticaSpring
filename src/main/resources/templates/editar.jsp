<%-- 
    Document   : Editar
    Created on : 14/10/2021, 03:16:40 PM
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Editar</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

    </head>
    <body>
        <div class="container mt-4 col-lg-4">
            <div class="card-header bg-info">
                <h4>Editar Registro</h4>
            </div>
            <div class="card-body">
                <form method="POST">
                    <label>Nombre</label>
                    <input type="text" name="Nombre" id="Nombre" class="form-control" value="${lista[0].Nombre}">
                    <input type="submit" value="Actualizar" class="btn btn-success">
                </form>
                <a href="index.htm">Regresar</a>
            </div>
        </div>
    </body>
</html>
