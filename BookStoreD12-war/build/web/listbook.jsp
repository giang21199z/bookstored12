<%-- 
    Document   : listbook
    Created on : Apr 24, 2016, 10:23:36 AM
    Author     : GIANGND-SVMC
--%>

<%@page import="common.GetId"%>
<%@page import="entity.Book"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List book</title>
        <%@include file="admin/css.jsp" %>
    </head>
    <body>
        <%@include file="admin/menu.jsp" %>
        <table class="table table-condensed">
            <thead>
                <tr>
                    <th style="width: 5%">ID Book</th>
                    <th style="width: 10%">Tên sách</th>
                    <th style="width: 10%">Tác giả</th>
                    <th style="width: 10%">Nhà xuất bản</th>
                    <th style="width: 10%">Năm xuất bản</th>
                    <th style="width: 30%">Miêu tả</th>
                    <th style="width: 5%">Giá nhập</th>
                    <th style="width: 5%">Giá bán</th>
                    <th style="width: 5%">Số lượng</th>
                    <th style="width: 20%">Thao tác</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Book> listBook = (List<Book>) request.getAttribute(GetId.GET_ALL_BOOK);
                    if (listBook != null) {
                        for (Book book : listBook) {
                %>
            <form action="UpdateBook" method="post">
                <input type="hidden" value="<%=book.getIdbook()%>" name="idbook">
                <tr>
                    <td ><%=book.getIdbook()%></td>
                    <td><%=book.getTitle()%></td>
                    <td><%=book.getAuthor()%></td>
                    <td><%=book.getPublisher()%></td>
                    <td><%=book.getPublisherYear()%></td>
                    <td><%=book.getDescription()%></td>
                    <td><%=book.getOriginalPrice()%></td>
                    <td><%=book.getSalePrice()%></td>
                    <td><%=book.getQuantity()%></td>
                    <td>
                        <button type="submit"class="btn btn-info" name="type" value="edit">Sửa</button>
                        <button type="submit"class="btn btn-danger" name="type" value="del">Xóa</button>
                    </td>
                </tr>
            </form>
            <%}
                }%>
        </tbody>
    </table>
    <%@include file="admin/javascript.jsp" %>
</body>
</html>
