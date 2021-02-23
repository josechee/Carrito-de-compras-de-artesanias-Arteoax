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
public class BLL_ListaUsuario {
    public LinkedList<Usuario> obtenerTodosLosUsuarios(Connection dbCon){
         try {
            DAL_Usuario dal_usuario = new DAL_Usuario(dbCon,null);
            return dal_usuario.obtenerTodosLosUsuarios();
        } catch (Exception ex) {
            throw ex;
        }
    }
}
