<%-- 
    Document   : FrmPrincipal
    Created on : 23/01/2019, 01:20:26 AM
    Author     : PC
--%>

<%@page import="carritoArtesanias.el.Producto"%>
<%@page import="java.util.LinkedList"%>
<%@page import="carritoArtesanias.el.ListaProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/frmUsuariosPrincipal.css" type="text/css" rel="stylesheet">
        <script src="js/js.js" type="text/javascript" > </script>
        <title>Productos</title>
    </head>
    <body>
        
        
        <%
            String usuarioHTML=request.getParameter("idUsuario");
            
            /*Datos de la session*/
            HttpSession sesion = request.getSession(); // es un objeto           
            String tipo = (String) sesion.getAttribute("tipo");
            String correo = (String) sesion.getAttribute("correo");
            
            
           String opcion=request.getParameter("JComboxRegiones");
           out.println("opcion:  "+opcion);
       

        %>
        
        
        
        <%
        if(tipo!=null){
        %>
        <div id="formulario">
            <br/>
            <h3 id="mensajeBienvenida">    <% out.print("Bienvenido(a):  "+correo);%> </h3>
           <a href="comprasDelUsuario.jsp" id="comprasUsuario" class="opciones">Compras Realizadas</a>
           <a href="index.jsp" id="cerrarSesion" class="opciones">Cerrar Sesion</a>
         
             
                    <form id="frmRegiones" action="FrmUsuariosPrincipal.jsp" method="post">
                           
                           <br/>
                           <p>   <label><h3 id="mensajeSeleccionRegion">Seleccione la Region de los productos a buscar:</h3> </label> </p><br/>
                           <p>   <label><h4 id="mensajeRegiones">Region:</h3> </label> </p><br/>
                        <select id="JcomboxRegiones" name="JComboxRegiones">
                            <option value="CANIADA">CANIADA</option>
                            <option value="COSTA">COSTA</option>
                            <option value="ISTMO">ISTMO</option>
                            <option value="MIXTECA"> MIXTECA</option>
                            <option value="PAPALOAPAN">PAPALOAPAN</option>
                            <option value="SIERRA NORTE">SIERRA NORTE</option>
                            <option value="SIERRA SUR">SIERRA SUR</option>
                            <option value="VALLES CENTRALES">VALLES CENTRALES</option>
                        </select>
                        <input    type="submit" id="botonMostrarProductos" value="Mostrar Productos" class="botones" >  
                        
                    </form>
         </div> 
        <%    if(opcion!=null){  
              ListaProducto productos=new ListaProducto();
              LinkedList<Producto> lista = productos.listaProductosPorRegion(opcion);
               String filas = "";
               String ii="i";
        if (lista != null) {
            for (int i = 0; i < lista.size(); i++) {
                filas = filas + "<tr>";
                filas = filas + "<td>" + lista.get(i).getNombre() + "</td>";
                filas = filas + "<td>" + lista.get(i).getDescripcion() + "</td>";
                filas = filas + "<td>" + lista.get(i).getCosto() + "</td>";
                filas = filas + "<td>" + "<input type='text' id='txtCantidad"+i+"' name=\"txtCantidad\" >"+ "</td>";
                filas = filas + "<td>"
                            + "<input type=\"button\" class='botones' onclick=\"Agregar('" +  lista.get(i).getIdProducto()+"','"+ "txtCantidad"+i+"')\" value='Agregar Al Carrito'>" 
                        + "</td>";
                filas = filas + "</tr>";
            }
        } else {
            filas = filas + "<tr>";
            filas = filas + "<td>no</td>";
            filas = filas + "<td>hay</td>";
            filas = filas + "<td>Productos</td>";
            filas = filas + "<td>registrados</td>";
            filas = filas + "</tr>";
        }    
        
       //out.print(filas);
      
        %>
        
        <div id="listaProductos">
             <div id="respuesta"> </div>
                <table id="tblLista" > 
                    <thead>
                        <tr>
                        <td>Nombre del producto</td>
                        <td>Descripcion</td>
                        <td>Costo</td>                    
                        <td>Cantidad</td>
                        <td>Opcion</td>
                        </tr>
                    </thead>
                   <tbody id="filas">
                       <h1>Productos Disponibles De La Region: <%=opcion%></h1>
                       <%out.print(filas);%>
                   
                    </tbody>
                </table>
            
        </div>
        
        
        <div id="carrito">
            <img id="imagenCarrito" src="imgs/carrito_.png" id="img">
         
                <table id="tblCarrito" > 
                    
                    <thead>
                        <tr>
                        <td>Nombre Del Producto</td>
                        <td>Region</td>
                        <td>Costo</td>                    
                        <td>Cantidad</td>
                        </tr>
                    </thead>
                   <tbody id="carritos">                        
                    </tbody>
                </table>
            
             
                 

            <div id="respuestaCompra"> </div>
            <br/>
            <br/>
            <input  id="botonFinalizarCompra"  type="button"  value="Finalizar Compra"  onclick="realizarCompra();" class="botones">
        </div>
        
        <%  }
        
        
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
