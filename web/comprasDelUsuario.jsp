<%-- 
    Document   : comprasDelUsuario
    Created on : 25/01/2019, 03:21:19 AM
    Author     : PC
--%>

<%@page import="carritoArtesanias.util.DbUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="carritoArtesanias.bll.BLL_ListaVenta"%>
<%@page import="carritoArtesanias.el.Venta"%>
<%@page import="java.util.LinkedList"%>
<%@page import="carritoArtesanias.el.ListaVentas"%>
<%@page import="carritoArtesanias.el.ListaUsuarios"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/comprasDelUsuario.css" type="text/css" rel="stylesheet">
       
        <title>Compras realizadas</title>
    </head>
    <body>
              
        <a href="FrmUsuariosPrincipal.jsp" id="botonRegresar" class="opciones">Regresar</a>   
<%
         //   String usuarioHTML=request.getParameter("idUsuario");
            
            /*Datos de la session*/
            HttpSession sesion = request.getSession(); // es un objeto           
            String tipo = (String) sesion.getAttribute("tipo");
            String correo = (String) sesion.getAttribute("correo");
            
            if(tipo!=null){
            
           ListaUsuarios lUsuarios=new ListaUsuarios();
           
           //////
           Connection dbCon;
        dbCon = DbUtil.getInstance().getConnection();
           BLL_ListaVenta bll_listaVenta=new BLL_ListaVenta();
           
           
           
           String idUsuario="" ;
           idUsuario=lUsuarios.obtenerID_USuario(correo);
           //out.println(correo);

        %>
        <h1 id="mensajeComprasRealizadas">Tus compras: <%out.println(correo);%> </h1>
        

<%//   if(idUsuario!=""){ 
              ListaVentas ventas=new ListaVentas();
              Venta venta=new Venta();
              venta.setIdUsuario(idUsuario);
              LinkedList<Venta> lista = bll_listaVenta.obtenerVentasDelUsuario(dbCon, venta);
               String filas = "";
               if(lista.isEmpty()==false){
                   //out.println("lista<1>:   "+lista.get(0).getProducto());
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
            filas = filas + "<td>tienes</td>";
            filas = filas + "<td>ninguna</td>";
            filas = filas + "<td>compra</td>";
            filas = filas + "<td>realizada</td>";
            filas = filas + "<td>aun</td>";
            filas = filas + "</tr>";
        }    
               
        %>
            
        
       <br/>
       
       <div id="listaCompras">
             <div id="respuesta"> </div>
                <table id="tblLista" > 
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
                   <tbody id="filasCompras">
                     <%out.print(filas);%>
                   
                    </tbody>
                </table>
            
        </div>
                     
     <%
     }else{
     %>    
        <jsp:forward page="index.jsp"> 
    <jsp:param name="mensaje" value="No ha Iniciado la Sesion" />
    </jsp:forward> 
     
     
     <%
     }
     
     %>
    </body>
</html>
