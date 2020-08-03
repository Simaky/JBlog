<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">-->
    <title>Add post</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <style>
        <%@ include file="/css/addpost.css" %>
    </style>
</head>
<body>
<div class="form-post text-center">
    <form id="addblog" class="form-post" method="post" action="addblog">
        <h2>Add a new blog</h2>
        <p>Please fill in this form to add a new blog!</p>
        <hr>
        <div class="form-group">
            <input type="text" class="form-control" name="title" placeholder="Title"
                   required="required">
        </div>
        <div class="form-group">
            <label for="comment">Blog text:</label>
            <textarea required form="addblog" class="form-control" rows="5" id="text" name="text"></textarea>
        </div>
        <div class="form-group">
            <button class="btn btn-lg btn-primary btn-block" type="submit">Add a blog!</button>
        </div>
    </form>
    <div class="hint-text"><a href="http://localhost:8081">Click to go back</a></div>
</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
