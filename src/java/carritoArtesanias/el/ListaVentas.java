package carritoArtesanias.el;

import carritoArtesanias.bll.BLL_ListaUsuario;
import carritoArtesanias.bll.*;
import carritoArtesanias.el.*;
import carritoArtesanias.util.DbUtil;
import java.sql.Connection;
import java.util.LinkedList;
import utilerias.PrecioTotalDeProductos;

/**
 *
 * @author PC
 */
public class ListaVentas {

    private LinkedList<Venta> listaVentas;

    public void obtenerDatos() {
        Connection dbCon;
        dbCon = DbUtil.getInstance().getConnection();

        this.listaVentas = new LinkedList<Venta>();
        BLL_ListaVenta bll_lista_venta = new BLL_ListaVenta();
        this.listaVentas = bll_lista_venta.obtenerTodasLasVentas(dbCon);

    }

    public LinkedList<Venta> listaVentasIdEnSession(String idUsuario) {//este es para mostrar todas las compras del usuario que este en session
        this.obtenerDatos();                                           //o en el sistema
        LinkedList<Venta> ventasIdSession = new LinkedList<Venta>();
        String idUsuarioAux = "";
        for (int i = 0; i < this.listaVentas.size(); i++) {
            idUsuarioAux = this.listaVentas.get(i).getIdUsuario();
            if (idUsuario.compareTo(idUsuario) == 0) {
                ventasIdSession.add(this.listaVentas.get(i));
            }
        }
        return ventasIdSession;
    }

    public boolean insertartodasLasCompras(String correo) {
        Connection dbCon;
        dbCon = DbUtil.getInstance().getConnection();
        
        PrecioTotalDeProductos precioTotal = new PrecioTotalDeProductos();
        boolean respuesta;

        LinkedList<Carrito> listaCarritosEnSession = new LinkedList<Carrito>();
      //  Venta venta = new Venta();
        BLL_Venta bll_venta=new BLL_Venta();
        BLL_Producto bll_producto=new BLL_Producto();
        ListaCarrito lCarrito = new ListaCarrito();
        listaCarritosEnSession = lCarrito.listaCarritosEnSession(correo);
        
        try {
            for (int i = 0; i < listaCarritosEnSession.size(); i++) {
                 Producto producto=new Producto();
                producto.setIdProducto(listaCarritosEnSession.get(i).getIdProducto());
                producto=bll_producto.QueryProductoDataBase(dbCon, producto);
                
                Venta venta = new Venta();
                venta.setIdUsuario(listaCarritosEnSession.get(i).getIdUsuario());
                venta.setIdCarrito(listaCarritosEnSession.get(i).getIdCarrito());
                venta.setProducto(producto.getNombre());
                venta.setRegion(producto.getRegion());
                venta.setPrecio(producto.getCosto());
                venta.setCantidadProoducto(listaCarritosEnSession.get(i).getCantidadProducto());
                venta.setPrecioTotal(listaCarritosEnSession.get(i).getCantidadProducto() * producto.getCosto());
                bll_venta.AddVentaToDataBase(dbCon, venta);
            }

            respuesta = true;
            System.out.println("Se insertaron correctamente todos los productos del carrito");
        } catch (Exception e) {
            respuesta = false;
            System.out.println("ha ocurrido un error, al insertar los productos del carrito");
        }

        return respuesta;
    }

}
