package carritoArtesanias.el;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class Carrito {
    private String idCarrito;
    private String idUsuario;
    private String idProducto;
    private int cantidadProducto;

    public Carrito(String idCarrito, String idUsuario, String idProducto, int cantidadProducto) {
        this.idCarrito = idCarrito;
        this.idUsuario = idUsuario;
        this.idProducto = idProducto;
        this.cantidadProducto = cantidadProducto;
    }

    public Carrito() {
    }

    public String getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(String idCarrito) {
        this.idCarrito = idCarrito;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    
   
    
    
}
