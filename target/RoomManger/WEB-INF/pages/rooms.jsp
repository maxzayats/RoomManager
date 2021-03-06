<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
  <title>Books Page</title>

  <style type="text/css">
    .tg {
      border-collapse: collapse;
      border-spacing: 0;
      border-color: #ccc;
    }

    .tg td {
      font-family: Arial, sans-serif;
      font-size: 14px;
      padding: 10px 5px;
      border-style: solid;
      border-width: 1px;
      overflow: hidden;
      word-break: normal;
      border-color: #ccc;
      color: #333;
      background-color: #fff;
    }

    .tg th {
      font-family: Arial, sans-serif;
      font-size: 14px;
      font-weight: normal;
      padding: 10px 5px;
      border-style: solid;
      border-width: 1px;
      overflow: hidden;
      word-break: normal;
      border-color: #ccc;
      color: #333;
      background-color: #f0f0f0;
    }

    .tg .tg-4eph {
      background-color: #f9f9f9
    }
  </style>
</head>
<body>
<h1>Book List</h1>

<c:if test="${!empty getRooms}">
  <table class="tg">
    <tr>
      <th width="80">ID</th>
      <th width="120">Title</th>
      <th width="120">Author</th>
      <th width="120">Price</th>
      <th width="60">Edit</th>
      <th width="60">Delete</th>
    </tr>
    <c:forEach items="${getRooms}" var="room">
      <tr>
        <td>${room.id}</td>
        <td>${room.name}</td>
        <td>${room.size}</td>
        <td>${room.rentalPrice}</td>
        <td><a href="<c:url value='/edit/${room.id}'/>">Edit</a></td>
        <td><a href="<c:url value='/delete/${room.id}'/>">Delete</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>
<h1>Add a Book</h1>

<c:url var="addAction" value="/rooms/add"/>

<form:form action="${addAction}" commandName="room">
  <table>
    <c:if test="${!empty room.name}">
      <tr>
        <td>
          <form:label path="id">
            <spring:message text="ID"/>
          </form:label>
        </td>
        <td>
          <form:input path="id" readonly="true" size="8" disabled="true"/>
          <form:hidden path="id"/>
        </td>
      </tr>
    </c:if>
    <tr>
      <td>
        <form:label path="name">
          <spring:message text="name"/>
        </form:label>
      </td>
      <td>
        <form:input path="name"/>
      </td>
    </tr>
    <tr>
      <td>
        <form:label path="size">
          <spring:message text="sizer"/>
        </form:label>
      </td>
      <td>
        <form:input path="size"/>
      </td>
    </tr>
    <tr>
      <td>
        <form:label path="rentalPrice">
          <spring:message text="rentalPrice"/>
        </form:label>
      </td>
      <td>
        <form:input path="rentalPrice"/>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <c:if test="${!empty room.name}">
          <input type="submit"
                 value="<spring:message text="Edit Book"/>"/>
        </c:if>
        <c:if test="${empty room.name}">
          <input type="submit"
                 value="<spring:message text="Add Book"/>"/>
        </c:if>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>