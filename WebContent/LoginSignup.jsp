<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="login.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
	<%-- <script src="https://code.jquery.com/jquery-latest.js"></script>
	<script>
		$(document).ready(function(){
			<%
			if(session.getAttribute("sessionMessage") != null){
				%>
				var message = '<%=session.getAttribute("sessionMessage")%>';
				alert(message);
				<%
				session.setAttribute("sessionMessage", null);
			}
			%>
		});
		function signupfunction(event){
			event.preventDefault();
			var gender1 = "";
			if (document.getElementById('fem').checked) {
		    	  gender1 = "Female";
		    } else{
		    	gender1 = "Male";
		    }
			var params = {
				    firstName: document.getElementById('firstName').value,
				    lastName: document.getElementById('lastName').value,
				    email: document.getElementById('email').value,
				    password: document.getElementById('password').value,
				    dobDay: document.getElementById('dobDay').value,
				    dobMonth: document.getElementById('dobMonth').value,
				    dobYear: document.getElementById('dobYear').value,
				    gender: gender1
				};
			$.post("Signup", $.param(params), function(response) {
				if(response == 'ok'){
					window.location.assign("index.jsp?userEmail=" + document.getElementById('email').value);
					document.getElementById('signuperror').innerHTML="";
				} else if(response == 'not'){
					document.getElementById('signuperror').innerHTML="Email already exists!";
				}
			});
		}
		function loginfunction(event){
			event.preventDefault;
			var params = {
					email: document.getElementById('loginemail').value,
					password: document.getElementById('loginpassword').value
			};
			$.post("Login", $.param(params), function(response) {
				if(response == 'ok'){
					window.location.assign("index.jsp?userEmail=" + document.getElementById('loginemail').value);
				} else if(response == 'not'){
					alert("Invalid email and password");
				}
			});
		}
	</script>
<body>

 --%>
<%--  <%
if(session.getAttribute("sessionEmail") != null){
	response.sendRedirect("index.jsp?userEmail=" + session.getAttribute("sessionEmail").toString());
	return;
}
%> --%>

<div id="navwrapper" style="">
  <div id="navbar"> <table class="tablewrapper">
    <tr>
      <td class="row1">Email or Phone</td>
      <td class="row1">Password</td>
    </tr>
    <tr>
    		<form method="post" action="login">
      				<td><input id="loginemail" name="loginemail" type="email" class="inputtext"></td>
      				<td><input id="loginpassword" name="password" type="password" class="inputtext"></td>
      				<td><input type="submit" id="button" class="btn btn-primary" value="Login"></td>
            </form>
    </tr>
    <tr>
      <td><div  class="row2"><input type="checkbox" checked>Keep me logged in</div></td>
      <td class="row2 h"><a href="forgotpassword.jsp">Forgot your password?</a></td>
  </table>
    
    <h1 class="logowrapper">CodeBook</h1>
    
     <%--  <p><%= request.getParameter("msg")%></p>  --%>
        
   
  </div>
  </div>

  <div id="contentwrapper">
    <div id="content">
      
      <div id="leftbod">
        
        <div class="connect bolder">
          Connect with friends and the
          programmers around you on Facebook.</div>
        
        <div class="leftbar">
          <img src="https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-xap1/t39.2365-6/851565_602269956474188_918638970_n.png" alt="" class="iconwrap fb1"/>
          <div class="fb1">
            <span class="rowtext">See photos and updates</span>
            <span class="rowtext2 fb1">from friends in News Feed</span>
          </div>
        </div> 
          
          <div class="leftbar">
          <img src="https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-xap1/t39.2365-6/851585_216271631855613_2121533625_n.png" alt="" class="iconwrap fb1"/>
          <div class="fb1">
            <span class="rowtext">Share what's new</span>
            <span class="rowtext2 fb1">in your life on your timeline</span>
            </div>
          </div>
             
            <div class="leftbar">
          <img src="https://fbcdn-dragon-a.akamaihd.net/hphotos-ak-xap1/t39.2365-6/851558_160351450817973_1678868765_n.png " alt="" class="iconwrap fb1"/>
          <div class="fb1">
            <span class="rowtext">Find more</span>
            <span class="rowtext2 fb1">of what you're looking for with graph search</span>
        </div> 
        </div> 
       
            
      </div>
       
      <div id="rightbod">
        <div class="signup bolder">Sign Up</div>
      <%   if(request.getParameter("msg")!=null){%>
        <p><strong><%= request.getParameter("msg")%></strong></p>  
    <%}
      else{ %>
    			<p></p>
    			<%} %>
    
        
        <div class="free bolder">It's free and always will be</div>
        <p id="signuperror" style="color:red"></p>
        <form action="signup" method="post">
        <div class="formbox">
        <input type="text" id="firstName" name="firstName" class="inputbody in1" placeholder="First name" required="required">
        <input type="text" id="lastName" name="lastName" class="inputbody in1 fr" placeholder="Last name" required="required">
        </div>
        <div class="formbox">
        <input type="email" id="email"  name="email" class="inputbody in2" placeholder="Email" required="required">
        </div>
       <!--  <div class="formbox">
        <input type="email" name="emailcnf" class="inputbody in2" placeholder="Re-enter email" required="required">
        </div> -->
        <div class="formbox">
        <input type="password" id="password" name="password" class="inputbody in2" placeholder="password" required="required">
        </div>
        <div class="formbox">
          <div class="bday">Birthday</div>
        </div>
        <div class="formbox">
          
            <span>
              <select id="dobMonth" name="dobMonth" required="required" title="Month" class="selectbody"><option value="0">Month</option><option value="1">Jan</option><option value="2">Feb</option><option value="3">Mar</option><option value="4">Apr</option><option value="5">May</option><option value="6">Jun</option><option value="7">Jul</option><option value="8">Aug</option><option value="9">Sep</option><option value="10">Oct</option><option value="11">Nov</option><option value="12">Dec</option></select>
              <select id="dobDay" name="dobDay" required="required" title="Day" class="selectbody fl"><option value="0" >Day</option><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option><option value="25">25</option><option value="26">26</option><option value="27">27</option><option value="28">28</option><option value="29">29</option><option value="30">30</option><option value="31">31</option></select>
              <select id="dobYear" name="dobYear" required="required" title="Year" class="selectbody fl"><option value="0" >Year</option><option value="2015">2015</option><option value="2014">2014</option><option value="2013">2013</option><option value="2012">2012</option><option value="2011">2011</option><option value="2010">2010</option><option value="2009">2009</option><option value="2008">2008</option><option value="2007">2007</option><option value="2006">2006</option><option value="2005">2005</option><option value="2004">2004</option><option value="2003">2003</option><option value="2002">2002</option><option value="2001">2001</option><option value="2000">2000</option><option value="1999">1999</option><option value="1998">1998</option><option value="1997">1997</option><option value="1996">1996</option><option value="1995">1995</option><option value="1994">1994</option><option value="1993">1993</option><option value="1992">1992</option><option value="1991">1991</option><option value="1990">1990</option><option value="1989">1989</option><option value="1988">1988</option><option value="1987">1987</option><option value="1986">1986</option><option value="1985">1985</option><option value="1984">1984</option><option value="1983">1983</option><option value="1982">1982</option><option value="1981">1981</option><option value="1980">1980</option><option value="1979">1979</option><option value="1978">1978</option><option value="1977">1977</option><option value="1976">1976</option><option value="1975">1975</option><option value="1974">1974</option><option value="1973">1973</option><option value="1972">1972</option><option value="1971">1971</option><option value="1970">1970</option><option value="1969">1969</option><option value="1968">1968</option><option value="1967">1967</option><option value="1966">1966</option><option value="1965">1965</option><option value="1964">1964</option><option value="1963">1963</option><option value="1962">1962</option><option value="1961">1961</option><option value="1960">1960</option><option value="1959">1959</option><option value="1958">1958</option><option value="1957">1957</option><option value="1956">1956</option><option value="1955">1955</option><option value="1954">1954</option><option value="1953">1953</option><option value="1952">1952</option><option value="1951">1951</option><option value="1950">1950</option><option value="1949">1949</option><option value="1948">1948</option><option value="1947">1947</option><option value="1946">1946</option><option value="1945">1945</option><option value="1944">1944</option><option value="1943">1943</option><option value="1942">1942</option><option value="1941">1941</option><option value="1940">1940</option><option value="1939">1939</option><option value="1938">1938</option><option value="1937">1937</option><option value="1936">1936</option><option value="1935">1935</option><option value="1934">1934</option><option value="1933">1933</option><option value="1932">1932</option><option value="1931">1931</option><option value="1930">1930</option><option value="1929">1929</option><option value="1928">1928</option><option value="1927">1927</option><option value="1926">1926</option><option value="1925">1925</option><option value="1924">1924</option><option value="1923">1923</option><option value="1922">1922</option><option value="1921">1921</option><option value="1920">1920</option><option value="1919">1919</option><option value="1918">1918</option><option value="1917">1917</option><option value="1916">1916</option><option value="1915">1915</option><option value="1914">1914</option><option value="1913">1913</option><option value="1912">1912</option><option value="1911">1911</option><option value="1910">1910</option><option value="1909">1909</option><option value="1908">1908</option><option value="1907">1907</option><option value="1906">1906</option><option value="1905">1905</option></select>
            </span>
            <div class="fb1 why h">Why do I need to provide my birthday?</div></div>
            <div class="formbox mt1">
              <span data-type="radio" class="spanpad">
                <input  name="gender" value="Female" type="radio" id="fem" class="m0">
                <label for="fem" class="gender">Female
                </label>
                <input  name="gender" value="Male" type="radio" id="male" class="m0">
                <label for="male" class="gender">Male
                </label>
              </span>
            </div>
            <div class="formbox">
              <div class="agree">
                By clicking Sign Up, you agree to our <div class="link">Terms</div> and that you have read our <div class="link">Data Use Policy</div>, including our <div class="link">Cookie Use</div>.
              </div>  
            </div>
            <div class="formbox">
              <input type="submit" class="signbut bolder" value="Signup">
            </div>
            </form>
          <div class="formbox">
            <div class="create"><div class="link h">Create a Page</div> for a celebrity, band or business.</div>
          </div>
      </div>
     </div>
    </div>

</body>
</html>