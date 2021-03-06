<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Serviço de Entregas</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
	<div class="container-fluid tudo"> 
            <div class="row meio">
		<div class=" col-md-12 col-lg-12 col-sm-12 conteudo">
                    <section class="panel-consulta">
                        <h1>Lista de Entregas</h1>
                        <div class="panel-body">
                            <div class="list-content">
                                <ul class="list-group">
                                    <c:if test="${lista == null}">
                                        <jsp:forward page="Nutricionista?action=buscatpingrediente" />
                                    </c:if>
                                    <!-- INICIO REPETICAO TIPO ITENS -->
                                    <c:forEach var="lista" items="${lista}" varStatus="loop">
                                    <li class="list-group-item clearfix">
                                        <div class="task-title">
                                            <span>
                                            <c:out value="${lista.id}"/> | 
                                            <c:out value="${lista.endereco}"/> |
                                            <c:out value="${lista.descricao}"/> |
                                            <c:out value="${lista.entregador_id}"/> |
                                            <c:out value="${lista.status}"/>
                                            </span>
                                        </div>
                                    </li>
                                    </c:forEach>
									<!-- FIM REPETICAO TIPO ITENS -->
                                </ul>
                            </div>
                        </div>
                    </section>    
		</div>
            </div>
	</div>
    </body>
</html>