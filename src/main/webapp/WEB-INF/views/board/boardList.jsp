<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
<style type="text/css">

span{

cursor: pointer;

}

</style>
<script type="text/javascript">
$(function(){ //지금 파라미터랑 
	
	$('.go').click(function() {

		document.frm.curPage.value=$(this).attr("title");
		document.frm.search.value= '${listInfo.search}';
		document.frm.kind.value= '${listInfo.kind}';
		
		document.frm.submit();
		
	});
	
	
	
});
</script>
</head>
<body>

<h1>${board}</h1>

<div>
<form action="${board}List" name="frm">
<input type="hidden" name="curPage">
<select name="kind">
<option value="title">title</option>
<option value="writer">writer</option>
<option value="contents">contents</option>
</select>
<input type="text" name="search" value="${listInfo.search}">
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

<c:if test="${listInfo.curBlock > 1 }">
<span class="go" title="${listInfo.startNum-1}">[이전]</span>
</c:if>
<c:forEach begin="${listInfo.startNum}" end="${listInfo.lastNum }" var="i">
<span class="go" title="${i}">${i}</span>
</c:forEach>
<c:if test="${listInfo.curBlock < listInfo.totalBlock}">
<span class="go" title="${listInfo.lastNum+1}">[다음]</span>
</c:if>

<a href="./${board}Write">WRITE</a>


</body>
</html>