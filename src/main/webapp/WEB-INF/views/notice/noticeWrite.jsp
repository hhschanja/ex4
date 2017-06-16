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
<h1>WRITE FORM</h1>
<form action="./notice${path}" method="post">
<input type="hidden" name="num" value="${dto.num}"> <!-- write할때는 num이 null이 뜨기 때문에 제대로 변환을 못해줘, 그래서 DTO num을 integer로하면돼 -->
제목: <input type="text" name="title" value="${dto.title}">
작성자: <input type="text" name="writer" value="${dto.writer}">
내용: <textarea rows="" cols="" name="contents">${dto.contents}</textarea>
<p><button>작성하기</button></p>
</form>

</body>
</html>