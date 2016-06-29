<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cadastrar entregador</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h3>Informe os Dados do Entregador</h3>
        <form method="POST" action="${pageContext.request.contextPath}/ServletEntregador?action=cadastrar">
            Login:<input type="text" name="login"/><br>
            Senha:<input type="text" name="senha"/><br>
                <input type="submit"/>
        </form>
    </body>
</html>