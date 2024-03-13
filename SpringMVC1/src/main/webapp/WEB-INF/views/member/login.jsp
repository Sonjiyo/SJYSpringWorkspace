<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<div class="panel-body">
	<form action="loginPro.do" method="post">
		<table class="table" style="width:60%;margin:0 auto;">
         <tr>
           <td>아이디</td>
           <td><input type="text" name="id" class="form-control"/></td>
         </tr>
         <tr>
           <td>비밀번호</td>
           <td><input type="password" name="pw" class="form-control"/></td>
         </tr>
         <tr>
           <td colspan="2" align="center">
               <input type="button" class="btn btn-info btn-sm" onClick="loginCheck(form)") value="로그인">
           </td>
         </tr>
      </table>
	</form>
</div>
<%@ include file="../parts/footer.jsp"%>
<script>
	function loginCheck(form){
		if(!form.id.value.trim()){
			alert('아이디를 입력해주세요');
			return false;
		}
		if(!form.pw.value.trim()){
			alert('비밀번호를 입력해주세요');
			return false;
		}
		
		form.submit();
	}
</script>