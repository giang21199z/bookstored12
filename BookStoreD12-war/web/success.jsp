<%-- 
    Document   : success
    Created on : Apr 23, 2016, 3:12:49 PM
    Author     : GIANGND-SVMC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success</title>
    </head>
    <body>
        <%
            if (request.getAttribute("REGISTER") != null && request.getAttribute("REGISTER").equals(true)) {
        %>
        <script type="text/javascript">
            (function () {
                var timeLeft = 3,
                        cinterval;

                var timeDec = function () {
                    timeLeft--;
                    document.getElementById('countdown').innerHTML = timeLeft;
                    if (timeLeft === 0) {
                        clearInterval(cinterval);
                        location.replace("/BookStoreDemo-war");
                    }
                };
                cinterval = setInterval(timeDec, 1000);
            })();
        </script>
        Register success. Welcome to bookstore <span id="countdown">3</span>.
        <%
            }%>
    </body>
</html>
