<%-- 
    Document   : edit
    Created on : Nov 8, 2023, 3:58:53 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Manga"%>
<%@page import="model.Account"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Edit Info</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>

        <div class="container mt-5">
            <h2>Edit Info</h2>
            <%
                            Manga m= (Manga) request.getAttribute("manga");
            %>
            <form action="edit" method="post">
                <div class="form-group">
                    <label>Name:</label>
                    <input type="number" class="form-control" readonly name="id" value="<%=m.getId()%>">
                </div>
                <div class="form-group">
                    <label>Name:</label>
                    <input type="text" class="form-control" name="name" value="<%=m.getName()%>">
                </div>
                <div class="form-group">
                    <label>Price</label>
                    <input type="number" name="price" class="form-control" step="0.01" value="<%=m.getPrice()%>">
                </div>
                <div class="form-group">
                    <label>Description:</label>
                    <input type="text" class="form-control" name="description" value="<%=m.getDescription()%>">
                </div>

                <div class="form-group">
                    <label>Author</label><br>
                    <input  type="radio" name="authorid" value="1">Tsugumi Ohba<br>
                    <input  type="radio" name="authorid" value="2">Hiromu Arakawa<br><!-- comment -->
                    <input  type="radio" name="authorid" value="3">Koyoharu Gotouge<br>
                    <input  type="radio" name="authorid" value="4">Tomohito Oda<br><!-- comment -->
                    <input  type="radio" name="authorid" value="5">Haruba Negi<br>                               
                </div>
                <div class="form-group">
                                <label>Category</label>
                                <select name="categoryid">
                                    <option value="1">Shounen</option>
                                    <option value="2">Shoujo</option>
                                    <option value="3">Seinen</option>
                                </select>

                            </div>
                <button type="submit" class="btn btn-primary">Save</button>
            </form>
            <%
                              
            %>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
