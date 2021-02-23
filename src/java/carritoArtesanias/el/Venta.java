
package carritoArtesanias.el;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class Venta {
    private String idVenta;
    private String idUsuario;
    private String idCarrito;
    private String producto;
    private String Region;
    private double precio;
    private int cantidadProoducto;
    private double precioTotal;
    private String fecha;
   
    
    public Venta() {
        
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(String idCarrito) {
        this.idCarrito = idCarrito;
    }

    public int getCantidadProoducto() {
        return cantidadProoducto;
    }

    public void setCantidadProoducto(int cantidadProoducto) {
        this.cantidadProoducto = cantidadProoducto;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
}
