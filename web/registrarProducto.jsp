<%-- 
    Document   : registrarProducto
    Author     : PC
--%>

<%@page import="carritoArtesanias.el.Producto"%>
<%@page import="carritoArtesanias.bll.BLL_Producto"%>
<%@page import="carritoArtesanias.util.DbUtil"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
     // String region=request.getParameter("region");
            
            /*Datos de la session*/
            HttpSession sesion = request.getSession(); // es un objeto           
            String tipo = (String) sesion.getAttribute("tipo");
            String correo = (String) sesion.getAttribute("correo");
            
            //out.println("region:   "+region);
            
             Connection dbCon;
             dbCon = DbUtil.getInstance().getConnection();
            
            BLL_Producto bll_producto=new BLL_Producto();
            Producto producto=new Producto();
%>

<%
    String region=request.getParameter("JComboxRegiones");
    String nombre=request.getParameter("txtNombre");
    String descripcion=request.getParameter("txtDescripcion");
    String costo=request.getParameter("txtCosto");   
    String existencia=request.getParameter("txtExistencia"); 
    
    //crear producto
    producto.setRegion(region);
    producto.setNombre(nombre);
    producto.setDescripcion(descripcion);
    producto.setCosto(Double.parseDouble(costo));
    producto.setExistencia(Integer.parseInt(existencia));
    
    String respuesta="";
    respuesta=bll_producto.AddProductoToDataBase(dbCon, producto);
    
   if(respuesta!=""){
        %>
    
        <jsp:forward page="FrmPrincipalAdministrador.jsp"> 
          <jsp:param name="idusuario" value=" " />
        </jsp:forward> 
            
      
 <%
    }
    
    //String noHayError=Proyecto.registrar(id, nombre, responsable, Integer.parseInt(avance));
    //out.print(noHayError);
 %> 
