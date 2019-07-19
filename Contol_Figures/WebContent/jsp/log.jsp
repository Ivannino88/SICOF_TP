
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>log</title>
  </head>
  <body>
  

 <!--#04B431-->
 <table border="0">
 

 
  <tr><td align="right">Java Version:</td><td align="left"><%= System.getProperty("java.version")%></td></tr>
  <tr><td align="right">Java Home:</td><td align="left"><%= System.getProperty("java.home")%></td></tr>
  <tr><td align="right">java.vendor:</td><td align="left"><%= System.getProperty("java.vendor")%></td></tr>
  <tr><td align="right">java.vendor.url:</td><td align="left"><%= System.getProperty("java.vendor.url")%></td></tr>
  
  <tr><td align="right">os.arch:</td><td align="left"><%= System.getProperty("os.arch")%></td></tr>
  <tr><td align="right">os.name:</td><td align="left"><%= System.getProperty("os.name")%></td></tr>
  <tr><td align="right">os.version:</td><td align="left"><%= System.getProperty("os.version")%></td></tr>
  <tr><td align="right">user.dir:</td><td align="left"><%= System.getProperty("user.dir")%></td></tr>
  <tr><td align="right">user.home:</td><td align="left"><%= System.getProperty("user.home")%></td></tr>
  <tr><td align="right">user.name:</td><td align="left"><%= System.getProperty("user.name")%></td></tr>
  
  
  
  
 <tr><td align="right">request.getRemoteAddr():</td><td align="left"><%=request.getRemoteAddr()%></td></tr>
 <tr><td align="right">request.getRemoteHost():</td><td  align="left"><%=request.getRemoteHost()%>
 <tr><td align="right">request.getContextPath():</td><td  align="left">${pageContext.servletContext.contextPath}
 <tr><td align="right">request.getLocalAddr():</td><td  align="left"><%=request.getLocalAddr()%>
 <tr><td align="right">request.getLocalName():</td><td  align="left"><%=request.getLocalName()%>
 <tr><td align="right">request.getLocalPort():</td><td  align="left"><%=request.getLocalPort()%>
 <tr><td align="right">request.getServletPath():</td><td  align="left"><%=request.getServletPath()%>
 <tr><td align="right">request.getHeader("x-forwarded-for"):</td><td  align="left"><%=(request.getHeader("x-forwarded-for")!=null)?request.getHeader("x-forwarded-for"):""%>
 <tr><td colspan="2" align="center"><a href="${pageContext.servletContext.contextPath}/jsp/descargalog.jsp">    cifrasControl.log</a></td></tr>
 

 
 
   
 </table>
  
  </body>
</html>


