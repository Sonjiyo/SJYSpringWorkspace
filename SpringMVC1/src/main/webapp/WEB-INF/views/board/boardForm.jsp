<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
    <div class="panel-body">
     <form action="boardInsert.do" method="post">
      <table class="table">
         <tr>
           <td>제목</td>
           <td><input type="text" name="title" class="form-control"/></td>
         </tr>
         <tr>
           <td>내용</td>
           <td><textarea rows="7" class="form-control" name="content"></textarea> </td>
         </tr>
         <tr>
           <td>작성자</td>
           <td><input type="text" name="writer" class="form-control"/></td>
         </tr>
         <tr>
           <td colspan="2" align="center">
               <button type="submit" class="btn btn-success btn-sm">등록</button>
               <div class="btn btn-warning btn-sm" onclick="location.href='${cp}/boardList.do'" style="cursor:pointer">취소</div>
           </td>
         </tr>
      </table>
     </form>
    </div>
<%@ include file="../parts/footer.jsp"%>