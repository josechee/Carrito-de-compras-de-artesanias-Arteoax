package carritoArtesanias.el;

import java.sql.Connection;
import java.util.LinkedList;
import carritoArtesanias.bll.BLL_ListaUsuario;
import carritoArtesanias.bll.BLL_Usuario;
import carritoArtesanias.util.DbUtil;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class ListaUsuarios {

    private LinkedList<Usuario> listaUsuarios;

    public void obtenerDatos() {
        Connection dbCon;
        dbCon = DbUtil.getInstance().getConnection();

        this.listaUsuarios = new LinkedList<Usuario>();
        BLL_ListaUsuario bll_ListaUsuario = new BLL_ListaUsuario();
        this.listaUsuarios = bll_ListaUsuario.obtenerTodosLosUsuarios(dbCon);

    }

    public Usuario existeUsuario(String usuario) {
        this.obtenerDatos();
        Usuario u = null;
        String correoAux;
        boolean respuesta = false;
        for (int i = 0; i < this.listaUsuarios.size(); i++) {
            correoAux = this.listaUsuarios.get(i).getCorreo();
            if (correoAux.compareTo(usuario) == 0) {
                respuesta = true;
                u = new Usuario();
                u.setCorreo(usuario);
                u.setContraseña(listaUsuarios.get(i).getContraseña());
                u.setIdUsuario(this.listaUsuarios.get(i).getIdUsuario());
                return u;

            }
        }
        return u;
    }

    
    public boolean UsuarioCorrecto(String usuario,String contrasenia) {
        this.obtenerDatos();
        Usuario u = null;
        String correoAux,contraseniaAux;
        boolean respuesta = false;
        for (int i = 0; i < this.listaUsuarios.size(); i++) {
            correoAux = this.listaUsuarios.get(i).getCorreo();
            contraseniaAux=this.listaUsuarios.get(i).getContraseña();
            if (correoAux.compareTo(usuario) == 0 && contraseniaAux.compareTo(contrasenia)==0) {
                respuesta = true;
            }
        }
        return respuesta;
    }
    
    public LinkedList<Usuario> obtenerListaUsuario() {
        this.obtenerDatos();
        return this.listaUsuarios;

    }

    public boolean cuentaUsuarioExistente(String usuario) {
        this.obtenerDatos();
        boolean existe = false;
        String correoAux;
        for (int i = 0; i < this.listaUsuarios.size(); i++) {
            correoAux = this.listaUsuarios.get(i).getCorreo();
            if (correoAux.compareTo(usuario) == 0) {
                existe = true;
            }
        }
        return existe;
    }
    
    public String obtenerID_USuario(String correo){
        String correoAux="",id="";
        this.obtenerDatos();
        //linea checar a detalle que esta pasando
        for(int i=0;i<this.listaUsuarios.size();i++){
            correoAux=this.listaUsuarios.get(i).getCorreo();
            
            if(correoAux.compareTo(correo)==0){
                id=this.listaUsuarios.get(i).getIdUsuario();
                
            }
        }
        return id;
    }

}
