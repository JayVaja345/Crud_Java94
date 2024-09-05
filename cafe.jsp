<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cafe insert details</title>
<style>

body{
background-color:sky;
text-align:center;
font-family:courier;
border: 5px black;
margin:50px;

}
input{
flex:1;
margin-left: 30px;
background-color:skyblue;
}
</style>
</head>
<body>

<form action="cafeinsert" method="post">
<h2>Cafe Details</h2>
<br>
<b>CafeName:</b><input type="text" name="name"><br><br>
<b>City:</b> <input type="text" name="city"><br><br>
<b>Price:</b> <input type="text" name="price"><br><br>
<b>Rating:</b><input type="text" name="rating"><br><br>
<input type="submit" name="submit"><br>

</form>
</body>
</html>