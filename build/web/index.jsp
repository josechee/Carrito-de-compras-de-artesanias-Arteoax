<%-- 
    Document   : index
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/login.css" type="text/css" rel="stylesheet">
        <title>Arteoax</title>   
    </head>
    <body>

        <div id="principal">
            <div id="contenedor">
                <div id="cabdecera">           
                    <h1 id="textoLogin">Login</h1>
                </div>
                <br/>
                <br/>
                <br/>                   
                <p id="p1"> 
                    <%
                        String mensaje = request.getParameter("mensaje");
                        if (mensaje != null) {
                            out.print(mensaje);
                        }
                    %>
                </p>
                <div id="cuerpo">
                    <form id="frmLogin" action="controlSesion.jsp" method="post">
                        <p>   <label>Email: </label> </p>
                        <input type="email" name="txtUsuario" id="usuario" placeholder="Email" autofocus="" required="" value=""/>
                        <p> <label>Password:</label></p>
                        <p>   <input type="password" name="txtContrasenia"  placeholder="Password" required="" value=""/></p>  <!--por que funciona solamente cuando tiene un valor en la variable-->
                        <p id="bot">  <input type="submit" id="submit" name="btnIngresar" value="Ingresar" class="boton"></p>
                    </form>
                </div>      
            </div> 
        </div>
        <a href="registroUSuario.jsp" id="botonRegistrarUsuario" class="boton" >Registrarse</a>
    </body>
</html>
