<%-- 
    Document   : controlSesion
    Author     : PC
--%>

<%@page import="carritoArtesanias.el.ListaUsuarios"%>
<%@page import="carritoArtesanias.el.Usuario"%>
<%@page import="java.util.LinkedList"%>
<%@page import="carritoArtesanias.bll.BLL_Usuario"%>
<%@page import="carritoArtesanias.util.DbUtil"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/registro.css" type="text/css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <%
            //obtener todos los datos del login
            String usuario = request.getParameter("txtUsuario");
            String contrasenia = request.getParameter("txtContrasenia");
        %>

        <%
            //obntener todos los usuarios de la base de datos
            Connection dbCon;
            dbCon = DbUtil.getInstance().getConnection();

            BLL_Usuario bll_Usuario = new BLL_Usuario();
            LinkedList<Usuario> listaUsuarios = new LinkedList();
            listaUsuarios = bll_Usuario.obtenerTodosLosUsuarios(dbCon);
            ////
            ListaUsuarios ListUserController = new ListaUsuarios();

            if (listaUsuarios != null) {
                out.println("size " + listaUsuarios.size());
                for (int i = 0; i < listaUsuarios.size(); i++) {
                    out.println("usuario: " + listaUsuarios.get(i).getCorreo());
                }

                if (ListUserController.cuentaUsuarioExistente(usuario) == true) {
                    if (ListUserController.UsuarioCorrecto(usuario, contrasenia) == true) {
                        //entra cuando el correo y la contrasenia son correctas ambas
                        ///mandar a llamar el formulario principal de productos

                        if (usuario.compareTo("admin@gmail.com") == 0 && contrasenia.compareTo("admin") == 0) {//en este caso el los datos del admin es estatico
                            //entra en el Formulario del administrador
                            HttpSession sesion = request.getSession(); // aqui se esta creando el objeto y se esta agregando al HttpSession
                            sesion.setAttribute("tipo", "administrador"); // en esta parte se hara la comprobacion de cada tipo de usuario que entra
                            sesion.setAttribute("correo", usuario);
        %>      
        <jsp:forward page="FrmPrincipalAdministrador.jsp"> 
            <jsp:param name="administrador" value="<%=usuario%>" />
        </jsp:forward> 
        <%
        } else {//cualquier usuario ya registrado
            HttpSession sesion = request.getSession(); // aqui se esta creando el objeto y se esta agregando al HttpSession
            sesion.setAttribute("tipo", "usuario"); // en esta parte se hara la comprobacion de cada tipo de usuario que entra
            sesion.setAttribute("correo", usuario);
        %>
        <jsp:forward page="FrmUsuariosPrincipal.jsp"> 
            <jsp:param name="idusuario" value="<%=usuario%>" />
        </jsp:forward> 

        <%
            }

        %>
        <jsp:forward page="registroUSuario.jsp"> 
            <jsp:param name="mensaje" value="¿Es primera vez que entras en esta pagina?. Por favor registrate para empezar a formar parte de nuestros clientes y usuarios satisfechos." />
        </jsp:forward> 

        <%                       } else {
            ///mandar mensaje que la contrasenia no es correcta
        %>     
        <jsp:forward page="index.jsp"> 
            <jsp:param name="mensaje" value="Contrasenia Invalida" />
        </jsp:forward> 
        <%     }

        } else {
            //mandar mensaje que no existe el usuario en un nuevo formulario que tenga la opcion salir o registrarse
        %>
        <jsp:forward page="registroUSuario.jsp"> 
            <jsp:param name="mensaje" value="¿Es primera vez que entras en esta pagina?. Por favor registrate para empezar a formar parte de nuestros clientes y usuarios satisfechos." />
        </jsp:forward> 
        <%
            }

        } else {

        %>
        <jsp:forward page="index.jsp"> 
            <jsp:param name="mensaje" value="LO SENTIMOS, NO HAY USUARIOS REGISTRADOS EN EL SISTEMA" />
        </jsp:forward> 


        <%            }
        %>
        <!--        // comprobar que exista el usuario que se ingreso 
          /*      String usuarioAux,contraseniaAux;
                
                if(listaUsuarios.isEmpty()==false){
                    for(int i=0;i<listaUsuarios.size();i++){
                     //  usuarioAux= listaUsuarios.get(i).getCuentaUsuario();
                   //    if(usuario.compareTo(usuarioAux)==0){
                        //   out.println(listaUsuarios.get(i).getCuentaUsuario());
                           
                          HttpSession sesion=request.getSession(); // aqui se esta creando el objeto y se esta agregando al HttpSession
                         sesion.setAttribute("tipo", "administrador"); // en esta parte se hara la comprobacion de cada tipo de usuario que entra
                           sesion.setAttribute("nombre", "administrador");
                           */
                         
        <!-- jsp:forward page="controlUsuario.jsp"> 
        <!-- jsp:param name="respuesta" value="se ha iniciado la sesion 1" />
        <!-- /jsp:forward> -->

        <!--    //      }
    
          //       }
            
          %> -->


    </body>
</html>
