<%-- 
    Document   : agregarAlCarrito
    Created on : 24/01/2019, 05:15:49 AM
    Author     : PC
--%>

<%@page import="carritoArtesanias.util.DbUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="carritoArtesanias.bll.BLL_Carrito"%>
<%@page import="carritoArtesanias.el.Carrito"%>
<%@page import="carritoArtesanias.el.ListaUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%          
                 //obntener todos los usuarios de la base de datos
        Connection dbCon;
        dbCon = DbUtil.getInstance().getConnection();
        
        
            /*String usuarioHTML=request.getParameter("idUsuario");*/
            
            /*Datos de la session*/
            HttpSession sesion = request.getSession(); // es un objeto           
            String tipo = (String) sesion.getAttribute("tipo");
            String correo = (String) sesion.getAttribute("correo");
            
            
            String idProducto=request.getParameter("txtIdProducto");
            int totalProducto=Integer.parseInt(request.getParameter("txtCantidad"));
            
            ListaUsuarios usuarios=new ListaUsuarios();
            String idUSuario="";
            
            idUSuario=usuarios.obtenerID_USuario(correo);    
            Carrito carrito=new Carrito();
            BLL_Carrito bll_carrito=new BLL_Carrito();
            
            
            
            carrito.setIdUsuario(idUSuario);
            carrito.setIdProducto(idProducto);
            carrito.setCantidadProducto(totalProducto);
            
            String idCarrito="";
            idCarrito=bll_carrito.AddCarritoToDataBase(dbCon, carrito);
            if(idCarrito!=""){
               Carrito carritoAux=new Carrito();
               carritoAux.setIdUsuario(idUSuario);
               out.print("Se Agrego en tu carrito");
              
            }else{
                out.print("No se pudo agregar en tu carrito");
            }
  %>
  
