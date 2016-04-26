<%-- 
    Document   : menu
    Created on : Feb 16, 2016, 6:30:32 PM
    Author     : GIANGND-SVMC
--%>


<%@page import="entity.CustomerMember"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="templatemo_menu">
    <ul>
        <li><a href="index.jsp" class="current">Trang chủ</a></li>
        <li><a href="cart.jsp">Giỏ hàng 
                <b style="color: red">
                    0
                </b>
            </a>
        </li>
        <%
            CustomerMember cm = (CustomerMember) session.getAttribute("CUSTOMERMEMBER");
            if (cm != null) {%>
        <li>
            <a href="#">
                Xin chào <%=cm.getUsername()%>
            </a>
        </li>
        <li><a href="Logout">Đăng xuất</a></li>
            <%} else {%>
        <li><a href="login.jsp">Đăng nhập</a></li>
        <li><a href="register.jsp">Đăng ký</a></li>
            <%}%>
    </ul>
</div> <!-- end of menu -->