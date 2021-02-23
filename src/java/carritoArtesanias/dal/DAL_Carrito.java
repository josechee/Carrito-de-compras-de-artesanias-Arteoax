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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import carritoArtesanias.el.Producto;


/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class DAL_Carrito {

    private Carrito carrito;
    private Connection dbCon;

    public DAL_Carrito(Connection _dbCon, Carrito _carrito) {
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

    public Carrito queryCarritoToDatabase() {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call tbl_Carrito_Consultar_SP(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("In_ID_Carrito", this.carrito.getIdCarrito());
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
                this.carrito = new Carrito();
                this.carrito.setIdUsuario(rs.getString("ID_Usuario"));
                this.carrito.setIdProducto(rs.getString("ID_Producto"));
                this.carrito.setCantidadProducto(rs.getInt("Cantidad_Producto"));
              
                // verificador = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return this.carrito;
        }
        return this.carrito;
    }
    
    
    
    
    public Carrito queryAlumnoPorIdUsuarioToDatabase() {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call tbl_Carrito_ConsultarPorID_Usuario_SP(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("ID_Usuario", this.carrito.getIdUsuario());
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
                this.carrito = new Carrito();
                this.carrito.setIdCarrito(rs.getString("ID_Carrito"));
                this.carrito.setIdProducto(rs.getString("ID_Producto"));
                this.carrito.setCantidadProducto(rs.getInt("Cantidad_Producto"));
       
                // verificador = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return this.carrito;
        }
        return this.carrito;
    }
    

    public String addCarritoToDataBase() throws SQLException {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        String verificador = null;
        try {
            cstmt = this.dbCon.prepareCall("{call tbl_Carrito_Insertar_SP(?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("Input_ID_Usuario", this.carrito.getIdUsuario());
            cstmt.setString("Input_ID_Producto", this.carrito.getIdProducto());
            cstmt.setInt("Input_Cantidad_Producto", this.carrito.getCantidadProducto());

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
                verificador = rs.getString("idCarrito");
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return null;
        }
        return verificador;
    } 
    
    public int eliminarCaritos(){
        
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call tbl_Carrito_Eliminar_SP(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("In_ID_Usuario", this.carrito.getIdUsuario());////////////

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
                verificador = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return 0;
        }
        return verificador;
    }
   
}
