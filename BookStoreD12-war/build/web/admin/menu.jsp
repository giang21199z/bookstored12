<%-- 
    Document   : menu
    Created on : Apr 24, 2016, 8:54:53 AM
    Author     : GIANGND-SVMC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <!-- Fixed navbar -->
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="admin.jsp">Quản trị web site</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <li class="active"><a href="#">Trang chủ</a></li>
                            <li><a href="#about">Thông báo</a></li>
                            <li><a href="#contact">Kế hoạch bán hàng</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">QL Sách <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="GetAllBook">Danh sách sách</a></li>
                                    <li><a href="addbook.jsp">Thêm sách</a></li>
                                    <li><a href="#">...</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">...</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">QL Tài khoản <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Thống kê tài khoản</a></li>
                                    <li><a href="#">...</a></li>
                                    <li><a href="#">...</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">...</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Quản lý đơn hàng <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Thống kê</a></li>
                                    <li><a href="#">...</a></li>
                                    <li><a href="#">...</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">...</a></li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="nav pull-right">              
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Tài khoản<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#"><i class="icon-info-sign"></i> Thông tin</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#"><i class="icon-refresh"></i> Đổi mật khẩu</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#"><i class="icon-arrow-right"></i> Thoát</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>