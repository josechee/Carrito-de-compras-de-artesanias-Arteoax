package test;

import carritoArtesanias.bll.BLL_Carrito;
import carritoArtesanias.bll.BLL_ListaProducto;
import carritoArtesanias.bll.BLL_ListaVenta;
import carritoArtesanias.bll.BLL_Producto;
import carritoArtesanias.dal.DAL_ListaProducto;
import carritoArtesanias.el.Carrito;
import carritoArtesanias.el.ListaCarrito;
import carritoArtesanias.el.ListaProducto;
import carritoArtesanias.el.ListaUsuarios;
import carritoArtesanias.el.ListaVentas;
import carritoArtesanias.el.Producto;
import carritoArtesanias.el.Venta;
import carritoArtesanias.util.DbUtil;
import java.sql.Connection;
import java.util.LinkedList;

/**
 *
 * @author PC
 */
public class Test {
    public static void main(String args[]) throws Exception {
        Connection dbCon;
        dbCon = DbUtil.getInstance().getConnection();
        
        
         
//    ListaProducto lProducto=new ListaProducto();
//    LinkedList<Producto> listaProducto=new   LinkedList<Producto>(); 
//    
//    Producto p=new Producto();
//    p.setRegion("PAPALOAPAN");
//    listaProducto=lProducto.listaProductosPorRegion("PAPALOAPAN");
//        System.out.println(listaProducto.size());

//        ListaUsuarios lUsuarios=new ListaUsuarios();
//        System.out.println(lUsuarios.obtenerID_USuario("ozmar@gmail.com"));
////        
//    ListaCarrito lCarrito=new ListaCarrito();
//           LinkedList<Carrito> lista=new LinkedList<Carrito>();
//           BLL_Producto bll_producto=new BLL_Producto();
//           
//           lista=lCarrito.listaCarritosEnSession("salm@gmail.com");
//           
//           for (int i = 0; i < lista.size(); i++) {
//                Producto producto=new Producto();
//                producto.setIdProducto(lista.get(i).getIdProducto());
//                producto=bll_producto.QueryProductoDataBase(dbCon, producto);
//                
//                System.out.println(producto.getRegion()  + "    "+producto.getNombre()+ "    "+  producto.getCosto()+"    "+ lista.get(i).getCantidadProducto());
//     
//            }
            ListaVentas lVentas=new ListaVentas();
        //System.out.println(lVentas.insertartodasLasCompras("salm@gmail.com"));
//
//        LinkedList<Venta> lista = lVentas.listaVentasIdEnSession("3ce80b6e-20cb-11e9-8124-28d244202eee");
//        System.out.println(lista.get(0).getProducto());
//        System.out.println("tamanio de la pagina: "+ lista.size());
//        
//      
//        Carrito carrito=new Carrito();
//        BLL_Carrito bll_carrito=new BLL_Carrito();
//        carrito.setIdUsuario("54980050-205b-11e9-b334-28d244202eee");
////        System.out.println(bll_carrito.EliminarCarritoDataBase(dbCon, carrito));
//
//        LinkedList<Producto> lista=new LinkedList<Producto>();
//           BLL_ListaProducto bll_lista_producto=new BLL_ListaProducto();
//           
//           lista=bll_lista_producto.obtenerTodosLosProducto(dbCon);
//           System.out.println(lista.get(0).getNombre());
//           
           
           ListaUsuarios lUsuarios=new ListaUsuarios();
           String idUsuario="" ;
           idUsuario=lUsuarios.obtenerID_USuario("ariel@gmail.com");
//           System.out.println("idUsuario:   "+idUsuario);
//           

           BLL_ListaVenta bll_listaVenta=new BLL_ListaVenta();
           Venta venta=new Venta();
           venta.setIdUsuario(idUsuario);
           
           LinkedList<Venta> lista=new LinkedList<Venta>();
           
           lista=bll_listaVenta.obtenerVentasDelUsuario(dbCon, venta);
           System.out.println("idUsuario                           producto");
           for(int i=0;i<lista.size();i++){
               System.out.println(lista.get(i).getIdUsuario()+"     "+lista.get(i).getProducto());
           }
   }




 }