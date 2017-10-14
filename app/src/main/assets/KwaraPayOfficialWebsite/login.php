<!DOCTYPE html PUBLIC "-//W3C//DTD
XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/
xhtml-transitional.dtd">
 <html xmlns="http://www.w3.org/1999/
xhtml" xml:lang="en" lang="en">
 <head>
 <meta http-equiv="Content-Type"
content="text/html; charset=utf-8" />
 <title>Form Feedback</title>
 </head>
 <body>
 <?php # Script 2.2 - login.php

// the form data:
 
 $email_name = $_REQUEST['email_name'];
 

 // Print the submitted information:
 echo "<p>Welcome. You are currently logged in as <b>$email_name</b>. please proceed to your transaction."
 

 ?>
 </body>
 </html>