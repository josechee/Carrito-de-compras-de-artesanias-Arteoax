/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carritoArtesanias.el;

import java.util.LinkedList;

/**
 *
 * @author  PC-PC
 */
public class Usuario {
    private String idUsuario;
    private String correo;
    private String contraseña;
    private LinkedList<Usuario>  listaUsuarios;
            
   public Usuario(String idUsuario, String correo, String contraseña) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.contraseña = contraseña;
    }
    
    public Usuario() {
        
    }
   
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LinkedList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(LinkedList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }


    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
   public LinkedList<Usuario> obtenerUsuarios(){
       this.listaUsuarios=new LinkedList<Usuario>();
       
       
   return listaUsuarios;
   
   }
    
    
}
