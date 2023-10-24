<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.*" %>
<%@page import="model.TblAuto" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestionar Auto</title>
</head>
<body bgcolor="#c5dec9">

<h1 align="center">Gestionar auto</h1>

<form action="ControladorServlet" method="post">

<table align="center">

<tr>
<td>Color</td>
<td><input type="text" name="color"></td>
</tr>

<tr>
<td>Modelo</td>
<td><input type="text" name="modelo"></td>
</tr>

<tr>
<td>Motor</td>
<td><input type="text" name="motor"></td>
</tr>

<tr>
<td>Precio</td>
<td><input type="text" name="precio"></td>
</tr>

<tr>
<td>Marca</td>
<td><input type="text" name="marca"></td>
</tr>

<tr>
<td>A�o Fabricacion</td>
<td><input type="text" name="fabricacion"></td>
</tr>

<tr>
<td colspan="2"><input type="submit" value="Registrar Auto"></td>
</tr>

</table>

</form>

<!-- ----------------------------------------------------------------------------------------- -->

<h1 align="center">Listado de Autos</h1>

<table align="center" border="2">

<tr>
<th>Codigo</th>
<th>Color</th>
<th>Modelo</th>
<th>Motor</th>
<th>Precio</th>
<th>Marca</th>
<th>Fabricacion</th>
</tr>

<%
List<TblAuto> ListadoAuto=(List<TblAuto>)request.getAttribute("listado");
if(ListadoAuto != null){
	for(TblAuto lis:ListadoAuto){
%>

<tr>

<td>
<%=lis.getIdauto()%>
</td>

<td>
<%=lis.getColor()%>
</td>

<td>
<%=lis.getModelo()%>
</td>

<td>
<%=lis.getMotor()%>
</td>

<td>
<%=lis.getPrecio()%>
</td>

<td>
<%=lis.getMarca() %>
</td>

<td>
<%=lis.getFabricacion() %>
</td>

</tr>

<%
	}
}
%>

</table>

</body>
</html>