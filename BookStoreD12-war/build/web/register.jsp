<%-- 
    Document   : register
    Created on : Nov 3, 2015, 6:26:28 PM
    Author     : Administrator
--%>

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
                            <div class="form_subtitle">Tạo tài khoản mới</div>
                            <form name="register" action="Register" method="post">          
                                <div class="form_row">
                                    <label class="contact"><strong>Username</strong></label>
                                    <input type="text" class="contact_input" name="username"/>
                                </div>  


                                <div class="form_row">
                                    <label class="contact"><strong>Password</strong></label>
                                    <input type="password" class="contact_input" name="password" />
                                </div> 

                                <div class="form_row">
                                    <label class="contact"><strong>Fullname</strong></label>
                                    <input type="text" class="contact_input"  name="fullname"/>
                                </div> 
                                <div class="form_row">
                                    <label class="contact"><strong>Num</strong></label>
                                    <input type="text" class="contact_input"  name="num"/>
                                </div> 
                                <div class="form_row">
                                    <label class="contact"><strong>Ward</strong></label>
                                    <input type="text" class="contact_input"  name="ward"/>
                                </div> 
                                <div class="form_row">
                                    <label class="contact"><strong>Dictric</strong></label>
                                    <input type="text" class="contact_input"  name="dictric"/>
                                </div> 
                                <div class="form_row">
                                    <label class="contact"><strong>City</strong></label>
                                    <input type="text" class="contact_input"  name="city"/>
                                </div> 
                                <div class="form_row">
                                    <label class="contact"><strong>Phone</strong></label>
                                    <input type="text" class="contact_input"  name="phone"/>
                                </div> 
                                <div class="form_row">
                                    <label class="contact"><strong>Email</strong></label>
                                    <input type="email" class="contact_input"  name="email"/>
                                </div> 

                                <div class="form_row">
                                    <div class="terms">
                                        <input type="checkbox" name="terms" />
                                        Tôi đồng ý với  <a href="#">điều khoản</a>điều khoản</div>
                                </div> 


                                <div class="form_row">
                                    <input type="submit" class="register" value="Đăng ký" />
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
</html>