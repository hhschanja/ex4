<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${board}</h1>
<form action="./${board}${path}" method="post">
<input type="hidden" name="num" value="${dto.num}"> <!-- write할때는 num이 null이 뜨기 때문에 제대로 변환을 못해줘, 그래서 DTO num을 integer로하면돼 -->
<p>제목: <input type="text" name="title" value="${dto.title}"></p>
<p>작성자: <input type="text" name="writer" value="${dto.writer}"></p>
<p>내용: <textarea rows="" cols="" name="contents">${dto.contents}</textarea></p>
<p><button>확인</button></p>
</form>
</body>
</html>