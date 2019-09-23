<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <title>${pageTitle}</title>
</head>
<body>
    <spring:url value="/" var="urlHome" />
    <spring:url value="/users/add" var="urlAddUser" />
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark  ">
        <a class="navbar-brand" href="/home">User Management System</a>
    </nav>