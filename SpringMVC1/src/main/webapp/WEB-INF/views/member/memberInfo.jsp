<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<div class="panel-body">
	<table class="table">
		<tr>
			<td>아이디</td>
			<td>${vo.id}</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input name="pw" type="password" class="form-control" value="${vo.pw}" readonly></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${vo.email}</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<a href="${cp}/memberList.do" class="btn btn-primary btn-sm">목록</a>
			</td>
		</tr>
	</table> 
</div>
<%@ include file="../parts/footer.jsp"%>