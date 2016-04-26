<%-- 
    Document   : addbook
    Created on : Apr 24, 2016, 8:59:17 AM
    Author     : GIANGND-SVMC
--%>

<%@page import="entity.Book"%>
<%@page import="common.GetId"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="admin/css.jsp" %>
    </head>
    <body>
        <%@include file="admin/menu.jsp" %>
        <div class="container">
            <%@include file="admin/nofication.jsp" %>
            <%
                Book book = (Book) request.getAttribute(GetId.EDIT_BOOK);
                if (book != null) {%>
            <form action="UpdateBook" class="form-control" method="post">
                <input type="hidden" name="idbook" value="<%=book.getIdbook()%>">
                <div class="row">
                    <table class="table">
                        <tbody>
                            <tr>
                                <td>
                                    <label>Category</label>
                                    <select class="form-control"name="category">
                                        <option value="1">Truyện ngôn tình</option>
                                        <option value="2">Truyện tiểu thuyết</option>
                                        <option value="3">Truyện cười</option>
                                        <option value="4">Truyện cổ tích</option>
                                        <option value="5">Truyện ngắn</option>
                                        <option value="6">Truyện dài</option>
                                        <option value="7">Truyện dã sử</option>
                                        <option value="8">Truyện viễn tưởng</option>
                                        <option value="9">Truyện đời thường</option>
                                        <option value="10">Truyện thiếu nhi</option>
                                    </select>  
                                </td>
                                <td>
                                    <label>Bookset</label>
                                    <select class="form-control"name="bookset">
                                        <option value="1">Book set 1 cuốn</option>
                                        <option value="2">Book set 2 cuốn</option>
                                        <option value="3">Book set 3 cuốn</option>
                                        <option value="4">Book set 4 cuốn</option>
                                        <option value="5">Book set 5 cuốn</option>
                                        <option value="6">Book set 6 cuốn</option>
                                        <option value="7">Book set 7 cuốn</option>
                                        <option value="8">Book set 8 cuốn</option>
                                        <option value="9">Book set 9 cuốn</option>
                                        <option value="10"Book set 10 cuốn</option>
                                    </select>  
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Tên sách</label>
                                    <input type="text" class="form-control" name="title" value="<%=book.getTitle()%>">
                                </td>
                                <td>
                                    <label>Tác giả</label>
                                    <input type="text" class="form-control" name="author" value="<%= book.getAuthor()%>">
                                </td>
                                <td>
                                    <label>Nhà xuất bản</label>
                                    <input type="text" class="form-control" name="publisher" value="<%= book.getPublisher()%>">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Năm xuất bản</label>
                                    <select class="form-control"name="publisheryear">
                                        <% for (int i = 1900; i <= 2016; i++) {%>
                                        <option value="<%=i%>"><%=i%></option>
                                        <%}%>
                                    </select>  
                                </td>
                                <td>
                                    <label>Mô tả</label>
                                    <input type="text"class="form-control" name="description" value="<%= book.getDescription()%>">
                                </td>
                                <td>
                                    <label>Giá nhập</label>
                                    <input type="number"class="form-control" name="originalprice" value="<%= book.getOriginalPrice()%>">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Giá bán</label>
                                    <input type="number"class="form-control" name="saleprice" value="<%= book.getSalePrice()%>">
                                </td>
                                <td>
                                    <label>Số lượng nhập</label>
                                    <input type="number"class="form-control" name="quantity" value="<%=book.getQuantity()%>">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <button type="submit"class="btn btn-default" name="type" value="updatebook">Cập nhật</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>

                </div>

            </form>
            <%}%>                                    
        </div>
        <%@include file="admin/javascript.jsp" %>
    </body>
</html>
