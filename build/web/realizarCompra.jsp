<%-- 
    Document   : realizarCompra
    Author     : PC
--%>

<%@page import="carritoArtesanias.el.Carrito"%>
<%@page import="carritoArtesanias.util.DbUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="carritoArtesanias.bll.BLL_Carrito"%>
<%@page import="carritoArtesanias.el.ListaVentas"%>
<%@page import="carritoArtesanias.el.ListaUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%         /*Datos de la session*/
            HttpSession sesion = request.getSession(); // es un objeto           
            String tipo = (String) sesion.getAttribute("tipo");
            String correo = (String) sesion.getAttribute("correo");
           
%>
<%
    
     Connection dbCon;
        dbCon = DbUtil.getInstance().getConnection();
        ListaVentas lVentas=new ListaVentas();
        boolean respuesta;
        BLL_Carrito bll_carrito=new BLL_Carrito();
        respuesta=lVentas.insertartodasLasCompras(correo);
      
        
         ListaUsuarios usuarios=new ListaUsuarios();
    
         String idUsuario="";
         idUsuario=usuarios.obtenerID_USuario(correo);
       Carrito carrito=new Carrito();
        carrito.setIdUsuario(idUsuario);
       
        if(respuesta==true){
             out.print("Compra Realizada Exitosamente");
             bll_carrito.EliminarCarritoDataBase(dbCon, carrito);//para mandar a elmininar ese carrito
        }else{
            out.print("Error, No Fue Posible Realizar La compra");
        }


%>