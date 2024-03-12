<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
    <div class="panel-body">
       <form action="../boardUpdate.do" method="post">
         <input type="hidden" name="idx" value="${vo.idx}"/>
        <table class="table table-bordered">       
          <tr>
           <td>제목</td>
           <td><input type="text" name="title" class="form-control" value="${vo.title}"/></td>
          </tr>
          <tr>
           <td>내용</td>
           <td><textarea rows="7" class="form-control" name="content">${vo.content}</textarea> </td>
          </tr>
          <tr>
           <td>작성자</td>
           <td><input type="text" class="form-control" value="${vo.writer}" readonly="readonly"/></td>
          </tr>
          <tr>
            <td colspan="2" align="center">
               <button type="submit" class="btn btn-primary btn-sm">수정</button>
               <button type="reset" class="btn btn-warning btn-sm">취소</button>
               <button type="button" class="btn btn-info btn-sm" onclick="location.href='../boardList.do'">목록</button>
            </td>
          </tr>
        </table>    
       </form>
    </div>
<%@ include file="../parts/footer.jsp"%>