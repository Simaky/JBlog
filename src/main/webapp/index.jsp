<%@ page import="repository.BlogsRepository" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.BlogsEntity" %>
<%@ page import="repository.UsersRepository" %>
<%@ page import="util.Auth" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>JBlog</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <style>
        <%@ include file="/css/blog-home.css" %>
    </style>

</head>

<body>
<!-- Modal Login -->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Login</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form class="form-signin" method="post" action="login">
                    <label for="inputEmail" class="sr-only">Email address</label>
                    <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address"
                           required
                           autofocus>
                    <label for="inputPassword" class="sr-only">Password</label>
                    <input type="password" name="password" id="inputPassword" class="form-control"
                           placeholder="Password" required>
                    <div class="checkbox mb-3">
                        <label>
                            <input type="checkbox" value="remember-me"> Remember me
                        </label>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                </form>
            </div>
        </div>
    </div>
</div>


<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">JBlog</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>

                <%
                    if (Auth.isAuthorized(request)) {
                        out.println("<li class=\"nav-item\">\n" +
                                "                    <a class=\"nav-link\" href=\"addblog\">Add blog</a>\n" +
                                "                </li>\n" +
                                "                <li class=\"nav-item\">\n" +
                                "                    <a class=\"nav-link\" href=\"logout\">Log-out</a>\n" +
                                "                </li>");
                    } else {
                        out.println("<li class=\"nav-item\">\n" +
                                "                    <a class=\"nav-link\" data-toggle=\"modal\" data-target=\"#myModal\">Login</a>\n" +
                                "                </li>\n" +
                                "                <li class=\"nav-item\">\n" +
                                "                    <a class=\"nav-link\" href=\"registration\">Sign-up</a>\n" +
                                "                </li>");
                    }
                %>


            </ul>
        </div>
    </div>
</nav>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <!-- Blog Entries Column -->
        <div class="col-md-8" id="main-block">

            <%
                int limit = 1;
                BlogsRepository blogsRepository = new BlogsRepository();
                UsersRepository usersRepository = new UsersRepository();

                String plimit = request.getParameter("limit");
                if (plimit != null && !plimit.isEmpty()) {
                    limit = Integer.parseInt(plimit);
                }

                ArrayList<BlogsEntity> allBlogs = blogsRepository.getLimited(limit);


                for (BlogsEntity blog : allBlogs) {
                    out.println(String.format("<div class=\"card mb-4\">\n" +
                            "                    <h2 class=\"card-title\">%s</h2>\n" +
                            "                <div class=\"card-body\">\n" +
                            "                    <p class=\"card-text\">%s</p>\n" +
                            "                </div>\n" +
                            "                <div class=\"card-footer text-muted\">\n" +
                            "                    Posted on %s by\n" +
                            "                    <a href=\"#\">%s</a>\n" +
                            "                </div>\n" +
                            "            </div>", blog.getTitle(), blog.getBody(), blog.getCreatedAt(), usersRepository.findByID(blog.getAuthorId()).getLogin()));

                }
            %>

            <ul class="pagination justify-content-center mb-4">
                <li class="page-item">
                    <a class="page-link"
                       href="?limit=<% limit = limit*2;out.println(limit);%>">Load more...</a>
                </li>
            </ul>

        </div>

        <!-- Sidebar Widgets Column -->
        <div class="col-md-4">

            <!-- Search Widget -->
            <div class="card my-4">
                <h5 class="card-header">Search</h5>
                <div class="card-body">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search for...">
                        <span class="input-group-append">
                <button class="btn btn-secondary" type="button">Go!</button>
              </span>
                    </div>
                </div>
            </div>

        </div>

    </div>
    <!-- /.row -->

</div>
<!-- /.container -->

<!-- Footer -->
<footer class="footer fixed-bottom bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; JBlog 2020</p>
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>

</body>

</html>
