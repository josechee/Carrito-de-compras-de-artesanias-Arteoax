package carritoArtesanias.el;

import java.sql.Connection;
import java.util.LinkedList;
import carritoArtesanias.bll.BLL_ListaProducto;
import carritoArtesanias.util.DbUtil;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class ListaProducto {
    LinkedList<Producto> listaProductos=new LinkedList();
    
    
     public  void obtenerDatos(){
         Connection dbCon;
        dbCon = DbUtil.getInstance().getConnection();
        
        this.listaProductos=new LinkedList<Producto>();
        BLL_ListaProducto bll_ListaAlumno = new BLL_ListaProducto();
        this.listaProductos=bll_ListaAlumno.obtenerTodosLosProducto(dbCon);
    }    
    
    public  Producto nombreProducto(String nombre){
        this.obtenerDatos();
        Producto producto=null;
        String matriculaAux,idUserAux;
        boolean respuesta=false;
         for(int i=0;i<this.listaProductos.size();i++){
             idUserAux=this.listaProductos.get(i).getNombre();
             if(idUserAux.compareTo(nombre)==0){
                 producto=new Producto();
                 producto=this.listaProductos.get(i);
                 return producto;
                 
             }
         }
        return producto;
    }
    
    public LinkedList<Producto> obtenerListaProducto(){
        this.obtenerDatos();
        return this.listaProductos;
    }
    
    
    public boolean existeProducto(String nombre){
       this.obtenerDatos();
       boolean existe=false;
       String mAux;
       for(int i=0;i<this.listaProductos.size();i++){
           mAux=this.listaProductos.get(i).getNombre();
           if(mAux.compareTo(nombre)==0){
               existe=true;
           }
       }       
       return existe;
    }            

    
    public LinkedList<Producto> listaProductosPorRegion(String region){
         this.obtenerDatos();
         LinkedList<Producto> listaProductosRegion=new LinkedList<Producto>();
         String regionAux="";
         for(int i=0;i<this.listaProductos.size();i++){
             regionAux=this.listaProductos.get(i).getRegion();
             if(regionAux.compareTo(region)==0){
                 listaProductosRegion.add(this.listaProductos.get(i));
             }
         }
         return listaProductosRegion;
    }       
        
      
}
