/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carritoArtesanias.dal;

import carritoArtesanias.el.Carrito;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class DAL_ListaCarrito {
    
    private Carrito carrito;
    private Connection dbCon;

    public DAL_ListaCarrito(Connection _dbCon, Carrito _carrito) {
        dbCon = _dbCon;
        if (_carrito != null) {
            this.carrito = _carrito;
        } else {
            this.carrito = new Carrito();
        }
    }

    public LinkedList<Carrito> obtenerTodosLosCarritos() {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;

        LinkedList<Carrito> listaCarrito = new LinkedList<Carrito>();
        try {
            cstmt = this.dbCon.prepareCall("{call tbl_Carritos_ConsultarTodos_SP()}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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

            while (rs.next()) {
                this.carrito = new Carrito();
                this.carrito.setIdCarrito(rs.getString("ID_Carrito"));
                this.carrito.setIdUsuario(rs.getString("ID_Usuario"));
                this.carrito.setIdProducto(rs.getString("ID_Producto"));
                this.carrito.setCantidadProducto(rs.getInt("Cantidad_Producto"));
              
                listaCarrito.add(carrito);
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return null;
        }
        return listaCarrito;
    }

}
