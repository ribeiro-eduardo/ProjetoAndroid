<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Entrega</title>
    </head>
    <body>
        <h2>Informe os dados da entrega</h2>
        <form method="POST" action="${pageContext.request.contextPath}/ServletEntrega?action=cadastrar" enctype="multiform/form-data">
            <table>
	            <tr>
	            	<td>
	            		Endereco:<input type="text" name="endereco"/>
	            		</td></tr>
	            <tr><td>Descrição:<textarea name="descricao"></textarea></td></tr>
	            <tr><td>Imagem:<input type="file" name="imagem"/></td></tr>
	            <tr><td>ID do entregador:<input type="text" name="entregador_id"/></td></tr>
	            <tr><td><input type="submit"/></td></tr>
             </table>
        </form>	
    </body>
</html>