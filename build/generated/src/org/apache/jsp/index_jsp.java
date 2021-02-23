package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/login.css\" type=\"text/css\" rel=\"stylesheet\">\n");
      out.write("        <title>Arteoax</title>   \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div id=\"principal\">\n");
      out.write("            <div id=\"contenedor\">\n");
      out.write("                <div id=\"cabdecera\">           \n");
      out.write("                    <h1 id=\"textoLogin\">Login</h1>\n");
      out.write("                </div>\n");
      out.write("                <br/>\n");
      out.write("                <br/>\n");
      out.write("                <br/>                   \n");
      out.write("                <p id=\"p1\"> \n");
      out.write("                    ");

                        String mensaje = request.getParameter("mensaje");
                        if (mensaje != null) {
                            out.print(mensaje);
                        }
                    
      out.write("\n");
      out.write("                </p>\n");
      out.write("                <div id=\"cuerpo\">\n");
      out.write("                    <form id=\"frmLogin\" action=\"controlSesion.jsp\" method=\"post\">\n");
      out.write("                        <p>   <label>Email: </label> </p>\n");
      out.write("                        <input type=\"email\" name=\"txtUsuario\" id=\"usuario\" placeholder=\"Email\" autofocus=\"\" required=\"\" value=\"\"/>\n");
      out.write("                        <p> <label>Password:</label></p>\n");
      out.write("                        <p>   <input type=\"password\" name=\"txtContrasenia\"  placeholder=\"Password\" required=\"\" value=\"\"/></p>  <!--por que funciona solamente cuando tiene un valor en la variable-->\n");
      out.write("                        <p id=\"bot\">  <input type=\"submit\" id=\"submit\" name=\"btnIngresar\" value=\"Ingresar\" class=\"boton\"></p>\n");
      out.write("                    </form>\n");
      out.write("                </div>      \n");
      out.write("            </div> \n");
      out.write("        </div>\n");
      out.write("        <a href=\"registroUSuario.jsp\" id=\"botonRegistrarUsuario\" class=\"boton\" >Registrarse</a>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
