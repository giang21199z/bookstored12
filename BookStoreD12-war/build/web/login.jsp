<%-- 
    Document   : register
    Created on : Nov 3, 2015, 6:26:28 PM
    Author     : Administrator
--%>

<%@page import="common.GetId"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Book store PTIT</title>
        <link href="templatemo_style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <!--  Free CSS Templates from www.templatemo.com -->
        <div id="templatemo_container">
            <%@include file="menu.jsp" %>

            <%@include file="header.jsp" %> <!-- end of header -->

            <div class="center_content">
                <div class="left_content">
                    <div class="feat_prod_box_details">
                        <div class="contact_form">
                            <div class="form_subtitle">Đăng nhập</div>
                            <form name="register" action="Login" method="post">          
                                <div class="form_row">
                                    <label class="contact"><strong>Username</strong></label>
                                    <input type="text" class="contact_input" name="username"/>
                                </div>  


                                <div class="form_row">
                                    <label class="contact"><strong>Password</strong></label>
                                    <input type="password" class="contact_input" name="password" />
                                </div> 
                                <div class="form_row">
                                    <input type="submit" class="register" value="Đăng nhập" />
                                </div>   
                            </form>     
                        </div>  

                    </div>	
                    <div class="clear"></div>
                </div><!--end of left content-->
                <div class="clear"></div>
            </div><!--end of center content-->
            <%@include file="footer.jsp" %>
            <!-- end of footer -->
            <!--  Free CSS Template www.templatemo.com -->
        </div> <!-- end of container -->
        <%
            Boolean checkLogin = (Boolean) request.getAttribute(GetId.LOGIN);
            if (checkLogin != null && checkLogin == false) {
        %>
        <script>
            alert("Đăng nhập thất bại. Vui lòng thử lại");
        </script>
        <%}%>
        <% String message = (String) request.getAttribute(GetId.MESSAGE_PAYMENT_LOGIN);
            if (message != null) {
        %>
        <script>
            alert("<%=message%>");
        </script>
        <%}%>
    </body>
</html>