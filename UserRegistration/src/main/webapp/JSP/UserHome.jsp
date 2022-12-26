<html>
<head>
<title>User Home</title>
<script>
function ChkPass()
{
password = document.getElementById("password");
confirm_password = document.getElementByID("confirm_password");

if(password.value != confirm_password.value)
	{
	document.getElementByID("res").innerHTML="Password Not Matched";
	document.getElementByID("res").style.color="red";
	return false;
	}
else
	{
	return true;
	}
}
</script>
</head>
<body>
<div align="center">
<br>
<br>
<form method="post" action="ChangePass" onsubmit="return chkPass()">
<table>
<caption><h1>Change Password</h1></caption>
<tr>
<br>
<td>Current Password
<td><input type="password" name="cpsw" required>
</tr>

<tr>
<td>New Password
<td><input type="password" id="password" name="psw" required>
</tr>

<tr>
<td>confirm New Password
<td><input type="password" id="confirm_password" name="npsw" required>
</tr>
</table>
<br>
<br>
<tr>
<td><input type="submit" value="Submit">
<td><h2 id="res">
</tr>
</form>
<br>
<a href="index.html">Home</a>
</body>
</html>