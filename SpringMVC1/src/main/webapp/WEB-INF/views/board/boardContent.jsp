<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<div class="panel-body">
       <table class="table">
          <tr>
            <td>제목</td>
            <td>${vo.title}</td>
          </tr>
          <tr>
            <td>내용</td>
            <td>${vo.content}</td>
            <!--  <td>${fn:replace(vo.content,newLineChar,"<br/>")}</td>-->
          </tr>
          <tr>
            <td>작성자</td>
            <td>${vo.writer}</td>
          </tr>
          <tr>
            <td>작성일</td>
            <td>${fn:split(vo.indate," ")[0]}</td>
          </tr>
          <tr>
           <td colspan="2" align="center">
             <a href="boardUpdateForm.do/${vo.idx}" class="btn btn-primary btn-sm">수정화면</a>
             <a href="boardDelete.do/${vo.idx}" class="btn btn-warning btn-sm">삭제</a>
             <a href="boardList.do" class="btn btn-info btn-sm">목록</a>
           </td>
          </tr>
       </table>    
    </div>
<%@ include file="../parts/footer.jsp"%>