<%-- 
    Document   : registroUSuario
    Created on : 23/01/2019, 12:51:07 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/registro.css" type="text/css" rel="stylesheet"> 
        
        <title>Registro</title>
    </head>
    <body>
        
        <%
            //obtener MENSAJE del login
            String mensaje;
            mensaje=request.getParameter("mensaje");
            if(mensaje==null){
            mensaje="¿Es primera vez que entras en esta pagina?. Por favor registrate para empezar a formar parte de nuestros clientes y usuarios satisfechos.";
            }
      //  out.println("respuesta:    "+mensaje);
        %>
        
        <div id="principal">
            <div id="contenedor">
                <div id="cabdecera">
                    <h1 id="textoLogin">Registro</h1>
                </div>
                    <br/>
                <br/>
                <br/>                   
                <p id="p1"> 
            <%
             //   String mensaje = request.getParameter("mensaje");
                out.print(mensaje);
            %>
              
            </p>
                <div id="cuerpo">
                    <form id="frmPrincipal" action="control_Registro.jsp" method="post">

                        <p>   <label>Correo Electronico: </label> </p>
                        <input type="email" name="txtUsuario" id="usuario" placeholder="Ingrese su Correo electronico" autofocus="" required="" value=""/>
                        <p> <label>Contrasenia:</label></p>
                        <p>   <input type="password" name="txtContrasenia"  placeholder="Ingrese su contrasenia" required="" value=""/></p>  <!--por que funciona solamente cuando tiene un valor en la variable-->
                        <a href="registroUSuario.jsp" ></a>
                        <p id="bot">  <input type="submit" id="submit" name="btnIngresar" value="Registrarse" class="boton"></p>
                        
                       
                    </form>
                </div>      
            </div> 
        </div>
        <a href="index.jsp" id="salir" class="boton" >Regresar</a>
        
      
        
        
    </body>
</html>
