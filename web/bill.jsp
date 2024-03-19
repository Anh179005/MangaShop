<%-- 
    Document   : shopcart
    Created on : Nov 7, 2023, 11:36:14 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Manga"%>
<%@page import="model.Account"%>
<%@page import="model.Cart"%>
<%@page import="model.Another_Cart"%>
<%@page import="model.Item"%>
<!DOCTYPE html>
<!--
        ustora by freshdesignweb.com
        Twitter: https://twitter.com/freshdesignweb
        URL: https://www.freshdesignweb.com/ustora/
-->
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bill Page</title>

        <!-- Google Fonts -->
        <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>

        <!-- Bootstrap -->
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <!-- Font Awesome -->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="css/responsive.css">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>

        <% 
                    if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")){                
        %>


        <jsp:include page="header.jsp"></jsp:include>  

            <div class="product-big-title-area">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="product-bit-title text-center">
                                <h2>Bill</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div> <!-- End Page title area -->


            <div class="single-product-area">
                <div class="zigzag-bottom"></div>
                <div class="container">
                    <div class="row">


                        <div>
                            <div class="product-content-right">
                                <div class="woocommerce">

                                    <table cellspacing="0" class="shop_table cart">
                                        <thead>
                                            <tr>
                                                <th class="product-name">Name</th>
                                                <th class="product-quantity">Quantity</th>
                                                <th class="product-price">Price</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <%
                                                                Account acc= (Account) session.getAttribute("acc");
                                                                double budget = acc.getBudget();  
                                                                if(request.getAttribute("bill")!=null){
                                                                
                                                                Another_Cart a_cart=(Another_Cart) request.getAttribute("bill");
                                                                double tongtien=a_cart.getTotalMoney();
                                                                  
                                                                for(int i=0;i<a_cart.getItems().size();i++){
                                        %>

                                        <tr class="cart_item">
                                            <td class="product-name">
                                                <a href="single-product.html"><%=a_cart.getItems().get(i).getManga().getName()%></a> 
                                            </td>
                                            <td class="product-quantity">
                                                <span class="amount"><%= a_cart.getItems().get(i).getSo_luong()%></span>

                                            </td>

                                            <td class="product-price">
                                                <span class="amount"><%= a_cart.getItems().get(i).getSo_luong() * a_cart.getItems().get(i).getManga().getPrice() %> VND</span> 
                                            </td>



                                            
                                        </tr>
                                        <%
                                            }
                                        %>





                                        <tr>
                                                    <td colspan="2">
                                                        <div style="text-align: center;">
                                                            <span style="font-size: 16px;">Total:</span>
                                                        </div>
                                                    </td>
                                            <td class="product-subtotal" style="text-align: center;">
                                                <span class="amount" style="font-size: 16px; font-weight: bold;"><%=a_cart.getTotalMoney()%></span> 
                                            </td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>


                                <div class="cart-collaterals">

                                </div>                        
                            </div>                    
                        </div>
                    </div>
                </div>
            </div>


            <jsp:include page="footer.jsp"></jsp:include>  
            <%
            }else { 
                        // Nếu chưa đăng nhập, hiển thị "access denied"
                        response.sendRedirect("login");
                } 
            %>



            <!-- Latest jQuery form server -->
            <script src="https://code.jquery.com/jquery.min.js"></script>

            <!-- Bootstrap JS form CDN -->
            <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

            <!-- jQuery sticky menu -->
            <script src="js/owl.carousel.min.js"></script>
            <script src="js/jquery.sticky.js"></script>

            <!-- jQuery easing -->
            <script src="js/jquery.easing.1.3.min.js"></script>

            <!-- Main Script -->
            <script src="js/main.js"></script>
    </body>
</html>
