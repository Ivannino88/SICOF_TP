 <%@taglib uri="/struts-tags" prefix="s" %>
<div>
<jsp:include page="/jsp/reportes/xdemo.jsp"></jsp:include>
<s:property value="cadena"/>
<br>
<h5>____________________________________</h5>
<h5>__________RESULTADOS_____________</h5>
<a href="${pageContext.request.contextPath}/jsp/reportes/xdemo.jsp">limpiar</a>
</div>