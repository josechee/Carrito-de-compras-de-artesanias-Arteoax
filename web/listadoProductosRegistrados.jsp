<%-- 
    Document   : listadoProductosRegistrados
    Author     : PC
--%>

<%@page import="carritoArtesanias.bll.BLL_ListaProducto"%>
<%@page import="carritoArtesanias.el.Producto"%>
<%@page import="carritoArtesanias.bll.BLL_Producto"%>
<%@page import="carritoArtesanias.el.Carrito"%>
<%@page import="java.util.LinkedList"%>
<%@page import="carritoArtesanias.el.ListaCarrito"%>
<%@page import="carritoArtesanias.util.DbUtil"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
      /*Datos de la session*/
           HttpSession sesion = request.getSession(); // es un objeto           
           String tipo = (String) sesion.getAttribute("tipo");
           String correo = (String) sesion.getAttribute("correo");            
           
           Connection dbCon;
           dbCon = DbUtil.getInstance().getConnection();
           
         //  ListaCarrito lCarrito=new ListaCarrito();
           LinkedList<Producto> lista=new LinkedList<Producto>();
           BLL_ListaProducto bll_lista_producto=new BLL_ListaProducto();
           
           lista=bll_lista_producto.obtenerTodosLosProducto(dbCon);
           
           
           String filas = "";
        if (lista != null) {
            for (int i = 0; i < lista.size(); i++) {
                              
                filas = filas + "<tr>";
                filas = filas + "<td>" + lista.get(i).getNombre() + "</td>";
                filas = filas + "<td>" + lista.get(i).getRegion() + "</td>";
                filas = filas + "<td>" + lista.get(i).getDescripcion() + "</td>";
                filas = filas + "<td>" + lista.get(i).getCosto() + "</td>";
                filas = filas + "<td>" + lista.get(i).getExistencia() + "</td>";
                filas = filas + "</tr>";
            }
        } else {
            filas = filas + "<tr>";
            filas = filas + "<td>no</td>";
            filas = filas + "<td>hay</td>";
            filas = filas + "<td>productos</td>";
            filas = filas + "<td>Registrados</td>";
            filas = filas + "</tr>";
        }        
        out.print(filas);


%>
