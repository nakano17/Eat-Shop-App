<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飲食店管理システム</title>
<style type="text/css">
#login {
    box-shadow: 0 0 2px rgba(0, 0, 0, 0.2),
                0 1px 1px rgba(0, 0, 0, .2),
                0 3px 0 #fff,
                0 4px 0 rgba(0, 0, 0, .2),
                0 6px 0 #fff,
                0 7px 0 rgba(0, 0, 0, .2);
}

#login {
    position: absolute;
    z-index: 0;
}

#login:before {
    content: '';
    position: absolute;
    z-index: -1;
    border: 1px dashed #ccc;
    top: 5px;
    bottom: 5px;
    left: 5px;
    right: 5px;
    box-shadow: 0 0 0 1px #fff;
}

h1 {
    text-shadow: 0 1px 0 rgba(255, 255, 255, .7), 0px 2px 0 rgba(0, 0, 0, .5);
    text-transform: uppercase;
    text-align: center;
    color: #666;
    margin: 0 0 30px 0;
    letter-spacing: 4px;
    font: normal 26px/1 Verdana, Helvetica;
    position: relative;
}

body {background-color: #c4ffcd;}
</style>
</head>
<form action="/Jisyuseisaku/Login" method="post">
    <h1>ログイン</h1>
    <fieldset id="inputs">
        <input id="username" type="text" placeholder="Username" autofocus name="name" required><br>
        <input id="password" type="password" placeholder="Password" name="pass" required>
    </fieldset>
    <fieldset id="actions">
        <input type="submit" id="submit" value="ログイン">
    </fieldset>
</form>