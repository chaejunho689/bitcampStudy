<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="../js/common.js" defer></script>
<style type="text/css">
</style>
<head>
  <!-- Bootstrap CSS 불러오기 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-5">
  <div class="card shadow-lg p-3 mb-5 bg-body rounded">
    <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
      <img src="../image/ompangi.gif" width="70" height="70" alt="홈" onclick="location.href='../index.jsp'" style="cursor: pointer;">
      <h2 class="card-title mb-0">글 작성하기</h2>
    </div>
    <div class="card-body">
      <form id="" method="post" action="../board/boardWrite.jsp" onsubmit="return boardSubmitCheck(this)">
        <div class="mb-3">
          <label for="title" class="form-label">제목</label>
          <input type="text" class="form-control" id="subject" name="subject" placeholder="제목 입력">
          <div id="subjectDiv"> </div>
        </div>
        <div class="mb-3">
          <label for="content" class="form-label">내용</label>
          <textarea class="form-control" id="content" name="content" rows="5" placeholder="내용 입력"></textarea>
          <div id="contentDiv"> </div>
        </div>
        <div class="d-flex justify-content-between">
          <button type="submit" class="btn btn-success" id="boardWriteBtn">작성 완료</button>
          <button type="reset" class="btn btn-secondary">다시 제출</button>
        </div>
      </form>
    </div>
  </div>
</div>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/boardWrite.js">
$(function() {
	
});
</script>
</body>
</html>