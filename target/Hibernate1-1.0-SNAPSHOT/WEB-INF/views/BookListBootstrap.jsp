<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base/Header.jsp"%>

<div class="card mb-3">
    <div class="card-header">
        <i class="fa fa-table"></i> Data Table Example</div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Rating</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Rating</th>
                    <th>Actions</th>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.title}</td>
                    <td>
                        <c:forEach items="${book.authors}" var="author">
                            <li>${author.firstName} ${author.lastName}</li>
                        </c:forEach>
                    </td>
                    <td>${book.rating}</td>
                    <td><a href="/book/edit/${book.id}">Edit book </a>
                        <a href="/book/delete/${book.id}"> Delete book</a>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
</div>

<%@include file="base/Footer.jsp"%>