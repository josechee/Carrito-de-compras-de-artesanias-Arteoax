<%-- 
    Document   : listadoVentas
    Author     : PC
--%>

<%@page import="carritoArtesanias.util.DbUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="carritoArtesanias.bll.BLL_ListaVenta"%>
<%@page import="carritoArtesanias.el.ListaUsuarios"%>
<%@page import="carritoArtesanias.el.Venta"%>
<%@page import="java.util.LinkedList"%>
<%@page import="carritoArtesanias.el.ListaVentas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/frmAdministrador.css" type="text/css" rel="stylesheet">
        <title>Ventas</title>
    </head>
    <body>
        <h1>Ventas Realizadas:</h1>
    </body>
    <%
         //   String usuarioHTML=request.getParameter("idUsuario");
            
            /*Datos de la session*/
            HttpSession sesion = request.getSession(); // es un objeto           
            String tipo = (String) sesion.getAttribute("tipo");
            String correo = (String) sesion.getAttribute("correo");
            
           if(tipo!=null){
            
            Connection dbCon;
           dbCon = DbUtil.getInstance().getConnection();         
        %>
            

<%//   if(idUsuario!=""){ 
              BLL_ListaVenta ventas=new BLL_ListaVenta();
              LinkedList<Venta> lista = ventas.obtenerTodasLasVentas(dbCon);
               String filas = "";
               if(lista.isEmpty()==false){
                   out.println("lista<1>:   "+lista.get(0).getProducto());
                for (int i = 0; i < lista.size(); i++) {
                filas = filas + "<tr>";
                filas = filas + "<td>" + lista.get(i).getProducto() + "</td>";
                filas = filas + "<td>" + lista.get(i).getRegion() + "</td>";
                filas = filas + "<td>" + lista.get(i).getPrecio()+ "</td>";
                filas = filas + "<td>" + lista.get(i).getCantidadProoducto() + "</td>";
                filas = filas + "<td>" + lista.get(i).getPrecioTotal() + "</td>";
                filas = filas + "<td>" + lista.get(i).getFecha() + "</td>";
                filas = filas + "</tr>";
            }   ///out.println(filas);
               }else {
            filas = filas + "<tr>";
            filas = filas + "<td>no</td>";
            filas = filas + "<td>hay</td>";
            filas = filas + "<td>ninguna</td>";
            filas = filas + "<td>venta</td>";
            filas = filas + "<td>realizada</td>";
            filas = filas + "<td>aun</td>";
            filas = filas + "</tr>";
        } 
        %>
            
        <div id="listaVentas">
             <div id="respuesta"> </div>
                <table id="tblVentas" > 
                    <thead>
                        <tr>
                        <td>Nombre Producto</td>
                        <td>Region</td>
                        <td>Precio</td>                    
                        <td>Productos Comprados</td>
                        <td>Precio total</td>
                        <td>Fecha De Compra</td>
                        </tr>
                    </thead>
                   <tbody id="filasVentas">
                     <%out.print(filas);%>
                   
                    </tbody>
                </table>
            
        </div>
                     
   <a href="FrmPrincipalAdministrador.jsp" id="listadoVentas" >Regresar</a>
   
    
    <%
    }else{
    %>
     <jsp:forward page="index.jsp"> 
             <jsp:param name="mensaje" value="Lo Sentimos, NO HA INICIADO LA SESION" />
             </jsp:forward>    
   
   <%
    }
    
    %>
</html>
