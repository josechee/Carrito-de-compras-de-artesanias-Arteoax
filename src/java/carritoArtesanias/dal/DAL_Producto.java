package carritoArtesanias.dal;

import carritoArtesanias.el.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import carritoArtesanias.el.Producto;


/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class DAL_Producto {
    private Producto producto;
    private Connection dbCon;

    public DAL_Producto(Connection _dbCon, Producto _producto) {
        dbCon = _dbCon;
        if (_producto != null) {
            this.producto = _producto;
        } else {
            this.producto = new Producto();
        }
    }
    
     public String addProductoToDataBase() throws SQLException {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        String verificador = null;
        try {
            cstmt = this.dbCon.prepareCall("{call tbl_Producto_Insertar_SP(?,?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("Input_Nombre", this.producto.getNombre());
            cstmt.setString("Input_Descripcion", this.producto.getDescripcion());
            cstmt.setString("Input_Region", this.producto.getRegion());
            cstmt.setDouble("Input_Costo", this.producto.getCosto());
            cstmt.setInt("Input_Existencia", this.producto.getExistencia());
         
            boolean results = cstmt.execute();
            int rowsAffected = 0;

            while (results || rowsAffected != -1) {
                if (results) {
                    rs = cstmt.getResultSet();
                    break;
                } else {
                    rowsAffected = cstmt.getUpdateCount();
                }
                results = cstmt.getMoreResults();

            }

            if (rs.next()) {
                //verificador = rs.getInt(1);
                verificador = rs.getString("idProducto");
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return null;
        }
        return verificador;
    }

     
      public Producto queryProductoToDatabase() {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call tbl_Producto_Consultar_SP(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("In_ID_Producto", this.producto.getIdProducto());
            boolean results = cstmt.execute();
            int rowsAffected = 0;

            while (results || rowsAffected != -1) {
                if (results) {
                    rs = cstmt.getResultSet();
                    break;
                } else {
                    rowsAffected = cstmt.getUpdateCount();
                }
                results = cstmt.getMoreResults();
            }

            if (rs.next()) {
                this.producto = new Producto();
                this.producto.setNombre(rs.getString("Nombre"));
                this.producto.setDescripcion(rs.getString("Descripcion"));
                this.producto.setRegion(rs.getString("Region"));
               this.producto.setCosto(rs.getDouble("Costo"));
               this.producto.setExistencia(rs.getInt("Existencia"));
               
                // verificador = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return this.producto;
        }
        return this.producto;
    }
      
      
   ////// 
      public LinkedList<Producto> listaProductosPorRegionToDatabase() {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        LinkedList<Producto> listaProducto=new LinkedList<Producto>();
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call tbl_Producto_ConsultarPorRegion_SP(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("In_ID_Region", this.producto.getRegion());
            boolean results = cstmt.execute();
            int rowsAffected = 0;

            while (results || rowsAffected != -1) {
                if (results) {
                    rs = cstmt.getResultSet();
                    break;
                } else {
                    rowsAffected = cstmt.getUpdateCount();
                }
                results = cstmt.getMoreResults();
            }

            if (rs.next()) {
                this.producto = new Producto();
                this.producto.setIdProducto(rs.getString("ID_Producto"));
                this.producto.setNombre(rs.getString("Nombre"));
                this.producto.setDescripcion(rs.getString("Descripcion"));
                this.producto.setRegion(rs.getString("Region"));
               this.producto.setCosto(rs.getDouble("Costo"));
               this.producto.setExistencia(rs.getInt("Existencia"));
               listaProducto.add(producto);
                // verificador = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return listaProducto;
        }
        return listaProducto;
    }
      
}
