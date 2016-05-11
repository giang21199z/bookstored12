<%-- 
    Document   : homepage
    Created on : Apr 23, 2016, 11:16:54 AM
    Author     : GIANGND-SVMC
--%>
<%@page import="entity.Book"%>
<%@page import="java.util.List"%>
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
                                <a href="#">Cataloge1</a>
                            </li>
                            <li>
                                <a href="#">Cataloge2</a>    
                            </li>
                            <li>
                                <a href="#">Cataloge3</a>
                            </li>
                            <li>
                                <a href="#">Cataloge4</a>
                            </li>
                        </ul>
                    </div>
                    <div class="templatemo_content_left_section">
                        <h1>BookSet</h1>
                        <ul>

                            <li>
                                <a href="#">Bookset1</a>
                            </li>
                            <li><a href="#">Bookset2</a></li>
                            <li><a href="#">Bookset3</a></li>
                            <li><a href="#">Bookset4</a></li>
                        </ul>
                    </div>

                    <div class="templatemo_content_left_section">                
                        <a href="#"><img style="border:0;width:88px;height:31px" src="images/facebook.png" alt="Valid XHTML 1.0 Transitional" width="88" height="31" vspace="8" border="0" /></a>
                        <a href="#"><img style="border:0;width:88px;height:31px" src="images/glus.png" alt="Valid XHTML 1.0 Transitional" width="88" height="31" vspace="8" border="0" /></a>
                    </div>
                </div> <!-- end of content left -->

                <div id="templatemo_content_right">
                    <form method="post">
                        <select name="typeSuggest">
                            <option value="price">Gợi ý theo giá</option>
                            <option value="quantity">Gợi ý theo số lượng</option>
                        </select>
                        <input type="submit" value="Gợi ý">
                    </form>

                    <%
                        List<Book> list = (List<Book>) request.getAttribute("LISTBOOK");
                        if (list != null)
                            for (int i = 0; i < list.size(); i++) {%>  
                    <div class="templatemo_product_box">
                        <h1><%=list.get(i).getTitle()%></h1>
                        <img src="images/<%=list.get(i).getImage()%>" alt="image" />
                        <div class="product_info">
                            <h4>Tác giả: <%=list.get(i).getAuthor()%></h4>
                            <h4>NXB: <%=list.get(i).getPublisherYear()%></h4>
                            <h3><%=list.get(i).getSalePrice()%>00 VNĐ</h3>
                            <form action="DetailBook" method="post">
                                <div class="buy_now_button">
                                    <input type="hidden" value="<%=list.get(i).getIdbook()%>" name="id"></input>
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
                                            text-decoration: none;"
                                            type="submit">Chi tiết</button>
                                </div>
                            </form>
                        </div>
                        <div class="cleaner">&nbsp;</div>
                    </div>
                    <%if (i % 2 == 0) {%>                            
                    <div class="cleaner_with_width">&nbsp;</div>
                    <%} else {%>
                    <div class="cleaner_with_height">&nbsp;</div>
                    <%}

                        }%>

                    <a href="subpage.html"><img src="images/templatemo_ads.jpg" alt="ads" /></a>
                </div> <!-- end of content right -->

                <div class="cleaner_with_height">&nbsp;</div>
            </div> <!-- end of content -->

            <%@include file="footer.jsp" %>
            <!-- end of footer -->
            <!--  Free CSS Template www.templatemo.com -->
        </div> <!-- end of container -->
    </body>
</html>
