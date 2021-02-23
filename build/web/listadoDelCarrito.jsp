<%-- 
    Document   : listadoDelCarrito
    Created on : 24/01/2019, 03:38:15 AM
    Author     : PC
--%>

<%@page import="carritoArtesanias.util.DbUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="carritoArtesanias.el.Producto"%>
<%@page import="carritoArtesanias.bll.BLL_Producto"%>
<%@page import="java.util.LinkedList"%>
<%@page import="carritoArtesanias.el.Carrito"%>
<%@page import="carritoArtesanias.el.ListaCarrito"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    /*Datos de la session*/
    HttpSession sesion = request.getSession(); // es un objeto           
    String tipo = (String) sesion.getAttribute("tipo");
    String correo = (String) sesion.getAttribute("correo");

    Connection dbCon;
    dbCon = DbUtil.getInstance().getConnection();

    ListaCarrito lCarrito = new ListaCarrito();
    LinkedList<Carrito> lista = new LinkedList<Carrito>();
    BLL_Producto bll_producto = new BLL_Producto();

    lista = lCarrito.listaCarritosEnSession(correo);

    String filas = "";
    if (lista != null) {
        for (int i = 0; i < lista.size(); i++) {
            Producto producto = new Producto();
            producto.setIdProducto(lista.get(i).getIdProducto());
            producto = bll_producto.QueryProductoDataBase(dbCon, producto);

            filas = filas + "<tr>";
            filas = filas + "<td>" + producto.getNombre() + "</td>";
            filas = filas + "<td>" + producto.getRegion() + "</td>";
            filas = filas + "<td>" + producto.getCosto() + "</td>";
            filas = filas + "<td>" + lista.get(i).getCantidadProducto() + "</td>";

            filas = filas + "</tr>";
        }
    } else {
        filas = filas + "<tr>";
        filas = filas + "<td>no</td>";
        filas = filas + "<td>hay</td>";
        filas = filas + "<td>productos</td>";
        filas = filas + "<td>en el carrito</td>";
        filas = filas + "</tr>";
    }
    out.print(filas);


%>


<%
%>