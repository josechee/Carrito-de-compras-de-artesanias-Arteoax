<%-- 
    Document   : control_Registro
    Created on : 23/01/2019, 02:10:21 PM
    Author     : PC
--%>

<%@page import="carritoArtesanias.bll.BLL_Usuario"%>
<%@page import="carritoArtesanias.util.DbUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="carritoArtesanias.el.Usuario"%>
<%@page import="carritoArtesanias.el.ListaUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>control de resgistro!</h1>
        
        
        
        <%
        //obtener todos los datos del login
        String usuarioHTML=request.getParameter("txtUsuario");
        String contraseniaHTML=request.getParameter("txtContrasenia");
        %>
        
        
        
        
        
        <%
             //obntener todos los usuarios de la base de datos
            Connection dbCon;
            dbCon = DbUtil.getInstance().getConnection();
            
            
            ListaUsuarios lUsuarios=new ListaUsuarios();
            Usuario usuarioJSP=new Usuario();
            BLL_Usuario bll_usuario=new BLL_Usuario();
            
            if(lUsuarios.existeUsuario(usuarioHTML)!=null){
                out.println("<h1>"+"El correo ya esta registrado"+"</h1>");
                %>
                     <jsp:forward page="registroUSuario.jsp"> 
                 <jsp:param name="mensaje" value="CORREO NO DISPONIBLE, POR FAVOR INGRESE OTRO CORREO" />
                </jsp:forward> 
            <%
            }else{
                //crear usurario e insertar a ala base de datos al mismo tiempo que inicia la sesion 
                out.println("<h1>"+"Creando usuario y session"+"</h1>");
                
               /* creando usuario e insertando a la base de datos*/
                usuarioJSP.setCorreo(usuarioHTML);
                usuarioJSP.setContraseña(contraseniaHTML);
                String idUsuario="";
                idUsuario=bll_usuario.AddToDataBaseUsuario(dbCon, usuarioJSP);

                /*creando session*/
                if(idUsuario!=""){
                 HttpSession sesion=request.getSession(); // aqui se esta creando el objeto y se esta agregando al HttpSession
                 sesion.setAttribute("tipo", "usuario"); // en esta parte se hara la comprobacion de cada tipo de usuario que entra
                 sesion.setAttribute("correo",usuarioHTML );
                 %>
                 <jsp:forward page="FrmUsuariosPrincipal.jsp"> 
                 <jsp:param name="idUsuario"   value="<%=idUsuario%>" />
                 </jsp:forward> 
                 
            <%}
                    
            }
        
        %>
        
        
    </body>
</html>
