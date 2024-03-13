<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<div class="panel-body">
	<form action="updateMember.do" method="post">
	<input name="id" type="hidden" value="${vo.id}">
		<table class="table">
          	<tr>
				<td>아이디</td>
	            <td>${vo.id}</td>
			</tr>
			<tr>
	            <td>비밀번호</td>
	            <td><input name="pw" type="password" class="form-control" value="${vo.pw}"></td>
			</tr>
			<tr>
	            <td>이메일</td>
	            <td><input name="email" type="email" class="form-control" value="${vo.email}"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
		             <button class="btn btn-primary btn-sm">수정</button>
		             <a href="removeMember.do" class="btn btn-warning btn-sm">회원탈퇴</a>
		             <input type="reset" class="btn btn-info btn-sm" value="초기화"/>
				</td>
			</tr>
		</table>
	</form>    
</div>
<%@ include file="../parts/footer.jsp"%>