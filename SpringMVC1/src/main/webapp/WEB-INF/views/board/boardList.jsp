<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
    <div class="panel-body">
       <table class="table table-bordered table-hover">
          <tr>
            <td>번호</td>
            <td>제목</td>
            <td>작성자</td>
            <td>작성일</td>
            <td>조회수</td>
          </tr>
          <c:forEach var="vo" items="${list}">
           <tr>
            <td>${vo.idx}</td>
            <td><a href="boardContent.do?idx=${vo.idx}">${vo.title}</a></td>
            <td>${vo.writer}</td>
            <td>${fn:split(vo.indate," ")[0]}</td>
            <td>${vo.count}</td>
           </tr>
          </c:forEach>
       </table>    
       <a href="boardForm.do" class="btn btn-primary btn-sm">글쓰기</a>
    </div>
<%@ include file="../parts/footer.jsp"%>