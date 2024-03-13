<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<div class="panel-body">
     <form action="joinMemberPro.do" method="post">
      <table class="table">
         <tr>
           <td>아이디</td>
           <td><input type="text" name="id" class="form-control"/></td>
         </tr>
         <tr>
           <td>비밀번호</td>
           <td><input type="password" name="pw" class="form-control"/></td>
         </tr>
         <tr>
           <td>이메일</td>
           <td><input type="email" name="email" class="form-control"/></td>
         </tr>
         <tr>
           <td colspan="2" align="center">
               <button type="submit" class="btn btn-success btn-sm">회원가입</button>
               <div class="btn btn-warning btn-sm" onclick="location.href='${cp}/login.do'" style="cursor:pointer">취소</div>
           </td>
         </tr>
      </table>
     </form>
</div>
<%@ include file="../parts/footer.jsp"%>