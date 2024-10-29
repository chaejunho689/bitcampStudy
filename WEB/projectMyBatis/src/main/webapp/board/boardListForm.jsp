<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<head>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

</head>
<body>

<div class="container mt-5">
    <div class="card shadow-lg p-3 mb-5 bg-body rounded">
        <div class="card-header bg-primary text-white">
            <h2 class="text-center">게시판 목록</h2>
        </div>
        <div class="card-body">
            <table class="table table-hover text-center">
                <thead class="table-dark">
                    <tr>
                        <th scope="col">번호</th>
                        <th scope="col">제목</th>
                        <th scope="col">작성자</th>
                        <th scope="col">이메일</th>
                        <th scope="col">조회수</th>
                        <th scope="col">작성일</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- 반복적으로 게시글 데이터가 들어갑니다 -->
                    <tr>
                        <th scope="row">1</th>
                        <td><a href="boardDetail.jsp?seq=1" class="text-decoration-none text-dark">게시글 제목</a></td>
                        <td>작성자1</td>
                        <td>example1@gmail.com</td>
                        <td>120</td>
                        <td>2024-09-06</td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td><a href="boardDetail.jsp?seq=2" class="text-decoration-none text-dark">게시글 제목</a></td>
                        <td>작성자2</td>
                        <td>example2@gmail.com</td>
                        <td>85</td>
                        <td>2024-09-05</td>
                    </tr>
                    <!-- 추가 게시글들이 여기에 들어갑니다 -->
                </tbody>
            </table>
            <div class="d-flex justify-content-between">
                <button class="btn btn-primary" onclick="location.href='boardWrite.jsp'">글 작성하기</button>
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li class="page-item"><a class="page-link" href="#">이전</a></li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item"><a class="page-link" href="#">다음</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>

</body>
</html>