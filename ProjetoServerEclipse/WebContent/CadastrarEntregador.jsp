<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Entregador</title>
    </head>
    <body>
        <h2>Informe os dados do entregador</h2>
        <form method="POST" action="${pageContext.request.contextPath}/ServletEntregador?action=cadastrar">
            Login:<input type="text" name="login"/><br>
            Senha:<input type="text" name="senha"/><br>
                <input type="submit"/>
        </form>
    </body>
</html>