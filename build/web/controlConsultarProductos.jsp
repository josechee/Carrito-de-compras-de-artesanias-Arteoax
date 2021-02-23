<%-- 
    Document   : controlConsultarProductos
    Created on : 23/01/2019, 10:14:41 PM
    Author     : PC
--%>

<%@page import="carritoArtesanias.el.Producto"%>
<%@page import="java.util.LinkedList"%>
<%@page import="carritoArtesanias.el.ListaProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
          <script>
            alert("hola:"+region);
        </script>
        <%
        String region=request.getParameter("region");
            
            /*Datos de la session*/
            HttpSession sesion = request.getSession(); // es un objeto           
            String tipo = (String) sesion.getAttribute("tipo");
            String correo = (String) sesion.getAttribute("correo");
            
            out.println("region:   "+region);
            
            ListaProducto productos=new ListaProducto();
              LinkedList<Producto> lista = productos.listaProductosPorRegion(region);
       
         String filas = "";
        if (lista != null) {
            for (int i = 0; i < lista.size(); i++) {
                filas = filas + "<tr>";
                filas = filas + "<td>" + lista.get(i).getNombre() + "</td>";
                filas = filas + "<td>" + lista.get(i).getDescripcion() + "</td>";
                filas = filas + "<td>" + lista.get(i).getCosto() + "</td>";
                filas = filas + "<td>" + lista.get(i).getExistencia() + "</td>";
                filas = filas + "<td>"
                        + "<input type=\"button\" onclick=\"comprar('" +  lista.get(i).getIdProducto()+ "')\" value='Agregar Al Carrito'>"                        
                        + "<input type=\"button\" value=\"Actualizar\"/> "
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
        out.print(filas);
        %>
        
        <script>
            alert("hola:"+region);
        </script>
    </body>
</html>
