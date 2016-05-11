<%-- 
    Document   : detail
    Created on : Feb 16, 2016, 11:34:03 PM
    Author     : GIANGND-SVMC
--%>
<%@page import="common.GetId"%>
<%@page import="entity.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="templatemo_style.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
        <!--  Free CSS Templates from www.templatemo.com -->
        <div id="templatemo_container">
            <%@include file="menu.jsp" %>

            <%@include file="header.jsp" %> <!-- end of header -->

            <div id="templatemo_content">

                <form action="SearchBook" method="post">
                    <input type="text" name="keyword">
                    <input type="submit" value="Search">
                </form>
                
                <div id="templatemo_content_left">
                    <div class="templatemo_content_left_section">
                        <h1>Categories</h1>
                        <ul>
                            <li>
                                <a href="#">Category1</a>
                            </li>
                            <li>
                                <a href="#">Category2</a>
                            </li>
                            <li>
                                <a href="#">Category3</a>
                            </li>
                            <li>
                                <a href="#">Category4</a>
                            </li>

                        </ul>
                    </div>
                    <div class="templatemo_content_left_section">
                        <h1>BookSet</h1>
                        <ul>

                            <li>
                                <a href="#">BookSet1</a>
                            </li>

                            <li>
                                <a href="#">BookSet2</a>
                            </li>

                            <li>
                                <a href="#">BookSet3</a>
                            </li>
                            <li>
                                <a href="#">BookSet4</a>
                            </li>

                        </ul>
                    </div>

                    <div class="templatemo_content_left_section">                
                        <a href="#"><img style="border:0;width:88px;height:31px" src="images/facebook.png" alt="Valid XHTML 1.0 Transitional" width="88" height="31" vspace="8" border="0" /></a>
                        <a href="#"><img style="border:0;width:88px;height:31px" src="images/glus.png" alt="Valid XHTML 1.0 Transitional" width="88" height="31" vspace="8" border="0" /></a>
                    </div>
                </div> <!-- end of content left -->

                <div id="templatemo_content_right">
                    <% Book book = (Book) request.getAttribute(GetId.DETAIL_BOOK);
                        if (book != null) {
                    %>
                    <h1><%=book.getTitle()%></h1>
                    <div class="image_panel"><img src="images/<%=book.getImage()%>" alt="CSS Template" width="100" height="150" /></div>
                    <h2>Tác giả: <span><%=book.getAuthor()%></span></h2>
                    <ul>
                        <li>Nhà xuất bản <a href="#"><%=book.getPublisher()%></a></li>
                        <li><%=book.getPublisherYear()%></li>
                        <li><b>Giá bán: <%=book.getSalePrice()%>00 VNĐ</b></li>
                        <li>
                            <form action="Order" method="post">
                                <div class="buy_now_button">
                                    <input type="hidden" value="<%=book.getIdbook()%>" name="idbook">
                                    Số lượng: <input style="width: 50px" type="number" value="1" name="quantity">
                                    <button style="clear: both;
                                            text-align: center;
                                            display: block;
                                            width: 100px;
                                            padding: 4px 0 5px 0;
                                            margin-bottom: 10px; 
                                            background: url(images/templatemo_btn_02.jpg) no-repeat;
                                            color: #FFFFFF;
                                            border: 0px;
                                            font-weight: bold;
                                            margin-top: 20px;
                                            margin-left: 100px;
                                            text-decoration: none;"
                                            type="submit">
                                        Thêm vào giỏ</button>
                                </div>
                            </form>
                        </li>
                    </ul>

                    <p><%=book.getDescription()%> ...</p>
                    <%}%>
                    <div class="cleaner_with_height">&nbsp;</div>

                    <a href="index.html"><img src="images/templatemo_ads.jpg" alt="css template ad" /></a>

                </div> <!-- end of content right -->

                <div class="cleaner_with_height">&nbsp;</div>
            </div> <!-- end of content -->

            <%@include file="footer.jsp" %>
            <!-- end of footer -->
            <!--  Free CSS Template www.templatemo.com -->
        </div> <!-- end of container -->
        <% String message = (String) request.getAttribute(GetId.MESSAGE_ORDER);
            if (message != null) {
        %>
        <script>
            alert("<%=message%>");
        </script>
        <%}%>
    </body>
</html>
