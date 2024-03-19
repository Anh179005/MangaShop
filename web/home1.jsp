<%-- 
    Document   : home1
    Created on : Nov 5, 2023, 4:44:07 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Manga"%>
<%@page import="model.Account"%>

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
        <title>Product Page - Ustora Demo</title>

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
                    Account acc= (Account) session.getAttribute("acc");
                    
    
        %>
        
        <jsp:include page="header.jsp"></jsp:include>  

        

        <div class="product-big-title-area">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="product-bit-title text-center">
                            <h2>Shop</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>




        <div class="single-product-area">
            <div class="zigzag-bottom"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <div class="single-sidebar">
                            <div style="color:white;font-size: 24px;" class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list" style="display: inline;"></i> <a style="color:white; display: inline;" href="home">Categories</a></div>
                            <ul style="color:red;font-size: 20px; margin: 1px;text-align: center;" class="list-group category_block">
                                <li class="list-group-item text-white ${tag == "1" ? "active":""}"><a style='color:red' class='${tag == "1" ? "active":""}'  href="category?cid=1">Shounen</a></li>
                                <li class="list-group-item text-white ${tag == "2" ? "active":""}"><a style='color:red' class='${tag == "2" ? "active":""}'  href="category?cid=2">Shoujo</a></li>
                                <li class="list-group-item text-white ${tag == "3" ? "active":""}"><a style='color:red' class='${tag == "3" ? "active":""}'  href="category?cid=3">Seinen</a></li>
                            </ul> 
                            <br>
                            <div style="border: 2px solid #000;padding: 10px; ">
                                <form  action="search" method="post">
                                    <input style="display: inline;" type="text" placeholder="Search manga..." name="search_name">                            
                                    <input style="display: inline;"  type="submit" value="Search">
                                </form>
                            </div>
                        </div>


                        <div class="single-sidebar">
                            <h2 class="sidebar-title">Recent Products</h2>

                            <%
                            ArrayList<Manga> list_1= (ArrayList<Manga>) request.getAttribute("list_1");
                            for(int i=list_1.size()-4;i<list_1.size();i++){
                            %>

                            <div class="thubmnail-recent">
                                <img src="<%=list_1.get(i).getImage()%>" class="recent-thumb" alt="">
                                <h2><a href="detail?mid=<%=list_1.get(i).getId()%>"><%=list_1.get(i).getName()%></a></h2>
                                <div class="product-sidebar-price">
                                    <ins><%=list_1.get(i).getPrice()%> VND</ins>
                                </div>                             
                            </div>

                            <%
                                  }
                            %>  


                        </div>


                    </div>

                    <div class="col-md-9">


                        <div class="single-product-area">
                            <div class="zigzag-bottom"></div>
                            <div class="container">


                                <%
                        ArrayList<Manga> list= (ArrayList<Manga>) request.getAttribute("list_manga");
                        for(int i=0;i<list.size();i++){
                                %>

                                <div class="col-md-3 col-sm-6">
                                    <div class="single-shop-product">
                                        <div width="120" height="200"  class="product-upper">
                                            <img width="120" height="200" src="<%=list.get(i).getImage()%>" alt="">
                                        </div>
                                        <h2><a href="detail?mid=<%=list.get(i).getId()%>"><%=list.get(i).getName()%></a></h2>
                                        <div class="product-carousel-price">
                                            <ins><%=list.get(i).getPrice()%> VND</ins>
                                        </div>  

                                        <div class="product-option-shop">
                                            <a class="add_to_cart_button" data-quantity="1" data-product_sku="" data-product_id="70" rel="nofollow" href="addnewcart?id=<%=list.get(i).getId()%>">Add to cart</a>
                                        </div>                       
                                    </div>
                                </div>

                                <%
                                    }
                                %>




                            </div>
                        </div>

                    </div>

                </div>
            </div>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>                        
        <%
            } else { 
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
