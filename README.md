# Trust In Me

Its a Stock Trading Project. This project is to create a website/App to Trade and Invest in stocks online seamlessly.
Some of our products include Cash trading, Margin Product etc...

# Requirements.
1. Create an Account(User) page.
2. User Login Page 

# Use Cases.

## I. Create an account

### 1. Brief Description
      This Use Case describes how a User Sign-Up into the Trust In Me form.
      
 ### 2.Flow Of Events
      The Use Case begins when the User types her/his First Name, Last Name, City, State, Email, 
      Mobile, Pincode, Pan No and Password on the Sign-Up form.
      
   #### 2.1 Basic Flow - SignUP
      The System receives the User Input fields and takes user details into DataBase, and 
      takes User in to Login Page.
      
   #### 2.2 Alternative Flow - SignUP
      User Already Exist. 
      If the User ID is already exists in the Basic flow Signup, the system shows User already exist 
      try another UserID/MailID/Phonenumber.
      
  ## II.User Login
 
 ### 1.Brief Description
      This Use Case describes how a User Sign-In into the Trust in Me Web Application.
      
 ### 2.Flow Of Events
      The Use Case begins when the User types her/his Userid/mail/phonenumber and Password      
      on the Login form.
      
   #### 2.1 Basic Flow - Login
      The System validates the user_id and password and logs him/her into the Application
      
   #### 2.2 Alternative Flow - Login
      Invalid Username / Password. 
      If the Userid/mail/phonenumber and Password is incorrect in the Basic flow Signin, the system shows Invalid 
      Credentials and takes him/her into Login page again.
# Design.

#Tables
1.Users Table - Structure

|Id| First_Name   | Last_Name   | City      |    State      |     Email_Id           |   Mobile  | PinCode  |   Pan_No     |Password|
|-| -------------  |-------------| ----------|-------------- |----------------------  |-----------|----------|------------  |--------  |
|1|  Thrinath      |  seella     |  Nandyal  |Andhra Pradesh |thrinath@gmail.com      |9581436061 |  518501  |              |abc@123   |
|2|  Poornima      |  Thota      |   Tenali  |Andhra Pradesh |poornima4dwbi@gmail.com |9666163164 |  522201  |  AMCPT5127D  |test@123  |
|3|  Sai           |  Dharshan   |  Chennai  |Tamilnadu      |saidharshan21@gmail.com |8056028700 |  600034  |  507DDFG56D  |master@123|
# Test Cases.
