<%-- 
    Document   : nofication
    Created on : Apr 24, 2016, 9:44:46 AM
    Author     : GIANGND-SVMC
--%>

<%@page import="common.GetId"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
    <h3 style="color: green">
        <%
            Boolean result = (Boolean) request.getAttribute(GetId.ADD_BOOK);
            if (result != null) {
                if (result.equals(true)) {
        %>
        <%="Thêm sách thành công."%>
        <%} else {%>
        <%="Thêm sách thất bại."%>
        <%}
            }%>
    </h3>
</div>