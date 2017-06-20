<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>${board}</h1>

<div>
<form action="${board}List">
<select>
<option value="title">title</option>
<option value="writer">writer</option>
<option value="contents">contents</option>
</select>
<input type="text" name="find">
<input type="submit" value="SEARCH">
</form>

</div>



<table>
<tr>
<td>NUM</td>
<td>title</td>
<td>Writer</td>
<td>DATE</td>
<td>hit</td>
</tr>

<c:forEach items="${list}" var="dto">
<tr>
<td>${dto.num}</td>
<td>
<c:catch>
<c:forEach begin="1" end="${dto.depth}">
&emsp;&emsp;
</c:forEach>
</c:catch>
<a href="./${board}View?num=${dto.num}">${dto.title}</a>
</td>
<td>${dto.writer}</td>
<td>${dto.reg_date}</td>
<td>${dto.hit}</td>
</tr>

</c:forEach>


</table>


<a href="./${board}Write">WRITE</a>


</body>
</html>