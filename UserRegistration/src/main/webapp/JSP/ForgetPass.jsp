<html>
<head>
<title>Login</title>
</head>
<body bgcolor="red">
<br>
<br>
<br>
<div align="center">
<h2>Enter the details!</h2>
<br>
<form method="post" action="Forget">
<table>
<tr>
<td>User ID
<td>
<input type="text"
pattern="[a-zA-Z0-9!#$%&amp;'*+V=?^_`{\}~.-]+@[a-zA-Z0-9]+(\.[a-zA-Z0-9-]+)*"
required name="email" placeholder="email">
</tr>
<tr>
<td>Date of Birth
<td>
<input type="text" name="dob" pattern="\d{4}-\d{1,2}-\d{1,2}"
name="date" required placeholder="YYYY/MM/DD">
</tr>
</table>
<br>
<td>
<input type="submit" value="Submit">
</form>
<br>
<a href="../index.html">Home</a>
</div>
</body>
</html>