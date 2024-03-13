<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
    <div class="panel-body">
       <table class="table table-bordered table-hover">
          <tr>
            <td>번호</td>
            <td>아이디</td>
            <td>비밀번호</td>
            <td>이메일</td>
          </tr>
          <c:forEach var="vo" items="${list}">
           <tr>
            <td>${vo.num}</td>
            <td><a href="memberInfo.do/${vo.num}">${vo.id}</a></td>
            <td>${vo.pw}</td>
            <td>${vo.email}</td>
           </tr>
          </c:forEach>
       </table>    
    </div>
<%@ include file="../parts/footer.jsp"%>