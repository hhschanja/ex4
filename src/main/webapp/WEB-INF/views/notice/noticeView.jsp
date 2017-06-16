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
<h1>NOTICE VIEW</h1>

제목: ${dto.title }
작성자: ${dto.writer }
내용: ${dto.contents}
히트: ${dto.hit}
날짜: ${dto.reg_date}

<a href="./noticeUpdate?num=${dto.num}">UPDATE</a>
<a href="./noticeDelete?num=${dto.num}">DELETE</a>

</body>
</html>