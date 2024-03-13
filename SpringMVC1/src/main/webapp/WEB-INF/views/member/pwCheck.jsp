<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<div class="panel-body">
	<form action="pwCheckPro.do" method="post">
	<input type="hidden" name="id" value="${log}">
		<table class="table">
			<tr>
				<td>비밀번호 입력</td>
				<td><input name="pw" type="password" class="form-control"></td>
			</tr>
			<tr>
				<td colspan="2"  align="center">
					<button onClick="location.href='${cp}/memberInfo.do'" class="btn btn-info btn-sm">입력</button>
				</td>
			</tr>
		</table>	
	</form>
</div>
<%@ include file="../parts/footer.jsp"%>