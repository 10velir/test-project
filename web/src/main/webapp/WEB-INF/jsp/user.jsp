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
        <p>
            Hey! You won the car: ${requestScope.car.getId()}
        </p>

        <form id="searchForm">
            <div class="form-row">
                <div class="form-row">

                    <div class="form-group col-md-7">
                        <label for="inputModel">Email</label>
                        <input type="email" class="form-control" id="inputModel" placeholder="Model">
                    </div>

                    <div class="form-group col-md-7">
                        <label for="inputSupplier">Email</label>
                        <input type="email" class="form-control" id="inputSupplier" placeholder="Supplier">
                    </div>

                    <div class="form-group col-md-7">
                        <label for="inputColor">Email</label>
                        <input type="email" class="form-control" id="inputColor" placeholder="Color">
                    </div>

                </div>
            </div>
            <br>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>

</body>
</html>
