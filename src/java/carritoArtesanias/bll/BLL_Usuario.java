/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carritoArtesanias.bll;

import java.sql.Connection;
import java.util.LinkedList;
import carritoArtesanias.dal.DAL_Usuario;
import carritoArtesanias.el.Usuario;


/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class BLL_Usuario {
    
    private LinkedList<Usuario> listaUsuariios;
    
    public String AddToDataBaseUsuario(Connection dbCon, Usuario usuario) throws Exception {
        try {
            DAL_Usuario dal_usuario = new DAL_Usuario(dbCon, usuario);
            return dal_usuario.addUsuarioToDataBase();
        } catch (Exception ex) {
            throw ex;
        }
    } 
    
     public Usuario QueryUsuarioDataBase(Connection dbCon, String  idUsuario) throws Exception {
        try {
            DAL_Usuario dal_usuario = new DAL_Usuario(dbCon, null);
            return dal_usuario.queryUsuarioToDatabase(idUsuario);
          //  return dal_usuario.loginUsuarioToDatabase(idUsuario);
        } catch (Exception ex) {
            throw ex;
        }
     }   
 
         
     
    public LinkedList<Usuario> obtenerTodosLosUsuarios(Connection dbCon){
         try {
            DAL_Usuario dal_usuario = new DAL_Usuario(dbCon,null);
            return dal_usuario.obtenerTodosLosUsuarios();
        } catch (Exception ex) {
            throw ex;
        }
    }
}
