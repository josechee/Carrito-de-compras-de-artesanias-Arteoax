<%-- 
    Document   : FrmAdministrador
    Created on : 23/01/2019, 01:00:55 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/frmAdministrador.css" type="text/css" rel="stylesheet">
        <script src="js/administrador.js" type="text/javascript" > </script>
        <title>Administrador</title>
    </head>
    <body>
        <h1>Bienvenido Administrador:</h1>
        
        
         <%
            HttpSession sesion = request.getSession(); // es un objeto           
            String tipo = (String) sesion.getAttribute("tipo");
            String correo = (String) sesion.getAttribute("correo");
         if (sesion.getAttribute("tipo") != null) {

               // out.println("tipo en la sesion : " + tipo);
               // out.println("correo de la sesion : " + correo);
        %>
       
            <div id="formulario">
                 
           <!--% out.println("opcion:  "+opcion);% -->
           <form id="frmRegiones" action="registrarProducto.jsp" method="post">
                           
                      <p>    <label> Region: </label>
                        <select id="JcomboxRegiones" name="JComboxRegiones">
                            <option value="CANIADA">CANIADA</option>
                            <option value="COSTA">COSTA</option>
                            <option value="ISTMO">ISTMO</option>
                            <option value="MIXTECA"> MIXTECA</option>
                            <option value="PAPALOAPAN">PAPALOAPAN</option>
                            <option value="SIERRA NORTE">SIERRA NORTE</option>
                            <option value="SIERRA SUR">SIERRA SUR</option>
                            <option value="VALLES CENTRALES">VALLES CENTRALES</option>
                        </select></p>
                        
                        
                        <p>   <label>Nombre:</h3> </label> 
                         <input type="text" name="txtNombre"   required="" value=""/> </p>
                  
                       <p>   <label>Descripcion:</h3> </label> 
                         <input type="text" name="txtDescripcion"   required="" value=""/></p> 
                       
                       <p>   <label>Costo:</h3> </label> 
                         <input type="text" name="txtCosto"   required="" value=""/></p> 
                       
                       <p>   <label>Existencia:</h3> </label>
                          <input type="text" name="txtExistencia"   required="" value=""/></p> 
                       
                       
                       <input id="botonRegistrarProducto" type="submit"  value="Registrar Producto" class="opciones" >
                    </form>
         </div> 
        <a href="listadoVentas.jsp" id="ventas" class="opciones" >Consultar Todas Las Ventas</a>
        
        <a href="index.jsp" id="principal" class="opciones">Cerrar Sesion</a>
        
        <h3 id="h3">Productos Actuales:</h3>
          <div id="prodcutos">
              
                <table id="tblProductos" > 
                    
                    <thead>
                        <tr>
                        <td>Nombre Del Producto</td>
                        <td>Region</td>
                        <td>Descripcion</td>
                        <td>Costo</td>                    
                        <td>Cantidad</td>
                        </tr>
                    </thead>
                   <tbody id="filas">                        
                    </tbody>
                </table>
            
             
                 

        
            <br/>
            <br/>
               <!--input    type="button"  value="FinalizarCompra"  onclick="realizarCompra();" -->
        </div>
        
        
        
        
        
        
        <%////end if of session
         }else{
            //mandar al index para que inicie session
            
         %>
            <jsp:forward page="index.jsp"> 
             <jsp:param name="mensaje" value="Lo Sentimos, NO HA INICIADO LA SESION" />
             </jsp:forward> 
         
         
         <%
        }
        
        
        %>
    </body>
</html>
