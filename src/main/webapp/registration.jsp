<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sign-up</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <style>
        <%@ include file="/css/registration.css" %>
    </style>
</head>
<body>
<div class="form-signup text-center">
    <form class="form-signup" method="post" action="registration">
        <h2>Sign Up</h2>
        <p>Please fill in this form to create an account!</p>
        <hr>
        <div class="form-group">
            <input type="text" class="form-control" name="login" placeholder="Login (nickname)"
                   required="required">
        </div>
        <div class="form-group">
            <input type="email" class="form-control" name="email" placeholder="Email" required="required">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="Password" required="required">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="confirm_password" placeholder="Confirm Password"
                   required="required">
        </div>
        <div class="form-group">
            <label class="checkbox-inline"><input type="checkbox" required="required"> I accept the <a href="#">Terms of
                Use</a> &amp; <a href="#">Privacy Policy</a></label>
        </div>
        <div class="form-group">
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
        </div>
    </form>
    <div class="hint-text">Already have an account? <a href="http://localhost:8081">Login here</a></div>
</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
