/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carritoArtesanias.el;

import carritoArtesanias.bll.BLL_ListaCarrito;
import carritoArtesanias.util.DbUtil;
import java.sql.Connection;
import java.util.LinkedList;

/**
 *
 * @author PC
 */
public class ListaCarrito {
    LinkedList<Carrito> listaCarritos=new LinkedList();
    
    
    public  void obtenerDatos(){
         Connection dbCon;
        dbCon = DbUtil.getInstance().getConnection();
        
        this.listaCarritos=new LinkedList<Carrito>();
        BLL_ListaCarrito bll_ListaCarrito = new BLL_ListaCarrito();
        this.listaCarritos=bll_ListaCarrito.obtenerTodosLosCarritos(dbCon);
    }
    
   public LinkedList<Carrito> listaCarritosEnSession(String correo){
         this.obtenerDatos();
         ListaUsuarios lUsuarios=new ListaUsuarios();
         
         LinkedList<Carrito> listaCarritoConSession=new LinkedList<Carrito>();
         String idUsuarioAux="";
         idUsuarioAux=lUsuarios.obtenerID_USuario(correo);
         for(int i=0;i<this.listaCarritos.size();i++){
           //  idUsuarioAux=this.listaCarritos.get(i).getIdUsuario();
             if(idUsuarioAux.compareTo(this.listaCarritos.get(i).getIdUsuario())==0){
                 listaCarritoConSession.add(this.listaCarritos.get(i));
             }
         }
         return listaCarritoConSession;
    }
   
}
