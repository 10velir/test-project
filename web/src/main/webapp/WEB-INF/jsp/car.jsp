<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cr_zy
  Date: 01.05.2019
  Time: 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SearchPage</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <style>input[type="text"] {
        font-size: 24px;
        height: 30px;
        width: 500px;
    }</style>
    </head>
<body>
        <p align="center">
            Hey <%--${requestScope.users.getName()} ! ur id is ${requestScope.users.getId()}--%>
        </p>

        <div class="container text-center col-sm-4">
            <form class="form-group col-md-18">
                <label/> Model </label>
                <input class="form-control col-md-6" type="text" size="10000px" name="model" maxlength="30" placeholder="audi"/>
                <br/>
                <label/> Supplier </label>
                <input class="form-control" type="text" name="supplier" maxlength="30" placeholder="tt"/>
                <br/>   <br/>
                <div class="col-md-12">
                    <div class="col-md-4"></div>
                    <input type="submit" class="btn btn-success col-md-4"  align="center" value="search"/>
                </div>
            </form>
            <br/>
            <br/>
            <br/>
            <br/>
        </div>

        <table class="table table-hover col-md-20">
            <tr>
                <th class="col-md-2">Supplier</th>
                <th class="col-md-2">Model</th>
                <th class="col-md-2">Max Speed</th>
                <th class="col-md-2">Price</th>
            </tr>
            <c:forEach var="car" items="#{requestScope.cars}">
                <tr class="info" >
                    <td class="col-md-2">${car.getSupplier()}</td>
                    <td class="col-md-2">${car.getModel()}</td>
                    <td class="col-md-2">${car.getMaxSpeed()}</td>
                    <td class="col-md-2">${car.getPrice()}</td>
                </tr>
            </c:forEach>
        </table>
</body>
</html>
