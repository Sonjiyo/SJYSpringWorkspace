<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Spring MVC</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
 
<div class="container">
  <h2>Spring MVC</h2>
  <div class="panel panel-default">
    <div class="panel-heading" style="display:flex;justify-content:space-between;align-items:center">
    	<a href="boardList.do" style="text-decoration:none;color:#222;">BOARD</a>
    	<div>
    	<c:if test="${log eq null}">
    	<button class="btn btn btn-info btn-sm" onClick="location.href='${cp}/login.do'">로그인</button>
    	<button class="btn btn btn-success btn-sm" onClick="location.href='${cp}/joinMember.do'">회원가입</button>
    	</c:if>
    	<c:if test="${log ne null}">
    	<button class="btn btn btn-danger btn-sm" onClick="location.href='${cp}/logout.do'">로그아웃</button>
    	<button class="btn btn btn-success btn-sm" onClick="location.href='${cp}/pwCheck.do'">내정보</button>
    	</c:if>
    	<button class="btn btn btn-warning btn-sm" onClick="location.href='${cp}/memberList.do'">회원목록</button>
    	</div>
    </div>