<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Spring Security</title>
    <link rel="stylesheet" type="text/css" th:href="@{/css/form.css}" />
</head>

<body>
<form th:action="@{/registration}" method="get">
    <button  type="Submit">Go To Registration Page</button>
</form>

<div>
    <form th:action="@{/login}" method="POST" class="form-4">
        <h3 th:text="Welcome"></h3>
        <br/>

        <input type="text" id="userName" name="userName"  th:placeholder="Name"
               class="form-control" /> <br/>
        <input type="password"  th:placeholder="Password"
               id="password" name="password" class="form-control" /> <br />

        <div align="center" th:if="${param.error}">
            <p >Email or Password invalid, please verify</p>
        </div>
        <button name="Submit" value="Login" type="Submit" th:text="Login"></button>
    </form>
</div>
</body>
</html>
