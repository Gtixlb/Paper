<%--
  Created by IntelliJ IDEA.
  User: 滴滴
  Date: 2019/6/16
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>论文编号</th>
                    <th>论文名字</th>
                    <th>论文数量</th>
                    <th>论文详情</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>

                    <tr>
                        <td>${paper01.paperId}</td>
                        <td>${paper01.paperName}</td>
                        <td>${paper01.paperNum}</td>
                        <td>${paper01.paperDetail}</td>
                        <td>
                            <a href="${path}/paper/toUpdatePaper?id=${paper01.paperId}">更改</a> |
                            <a href="<%=appPath%>/paper/del/${paper01.paperId}">删除</a>
                        </td>

                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
