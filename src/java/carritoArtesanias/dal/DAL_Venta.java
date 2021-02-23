/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carritoArtesanias.dal;

import carritoArtesanias.el.Carrito;
import carritoArtesanias.el.Venta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class DAL_Venta {

    private Venta venta;
    private Connection dbCon;

    public DAL_Venta(Connection _dbCon, Venta _venta) {
        dbCon = _dbCon;
        if (_venta != null) {
            this.venta = _venta;
        } else {
            this.venta = new Venta();
        }
    }

    public String addVentaToDataBase() throws SQLException {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        String verificador = "";
        try {
            cstmt = this.dbCon.prepareCall("{call tbl_Venta_Insertar_SP(?,?,?,?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            cstmt.setString("Input_ID_Usuario", this.venta.getIdUsuario());
            cstmt.setString("Input_ID_Carrito", this.venta.getIdCarrito());
            cstmt.setString("Input_Producto", this.venta.getProducto());
            cstmt.setString("Input_Region", this.venta.getRegion());
            cstmt.setDouble("Input_Precio", this.venta.getPrecio());
            cstmt.setInt("Input_Total_Producto", this.venta.getCantidadProoducto());
            cstmt.setDouble("Input_Precio_Total", this.venta.getPrecioTotal());
          

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
                verificador = rs.getString("idVenta");//aqui se captura el ide del proveedor
            }

        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return verificador;
        }
        return verificador;//retorna el id del Proveedor

    }

    public Venta queryVentaToDatabase() {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call tbl_Venta_Consultar_SP(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("In_ID_Venta", this.venta.getIdVenta());
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
                this.venta = new Venta();
                this.venta.setIdUsuario(rs.getString("ID_Usuario"));
                this.venta.setIdCarrito(rs.getString("ID_Carrito"));
                this.venta.setProducto(rs.getString("Producto"));
                this.venta.setRegion(rs.getString("Region"));
                this.venta.setPrecio(rs.getDouble("Precio"));
                this.venta.setCantidadProoducto(rs.getInt("Total_Producto"));
                this.venta.setPrecioTotal(rs.getDouble("Precio_Total"));
                this.venta.setFecha(rs.getString("Fecha"));

                // verificador = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return this.venta;
        }
        return this.venta;
    }
    
    
     public LinkedList<Venta> obtenerTodasLasVentas() {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;

        LinkedList<Venta> listaVenta = new LinkedList<Venta>();
        try {
            cstmt = this.dbCon.prepareCall("{call tbl_Venta_ConsultarTodos_SP()}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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
                this.venta = new Venta();
                this.venta.setIdVenta(rs.getString("ID_Venta"));
                this.venta.setIdUsuario(rs.getString("ID_Usuario"));
                this.venta.setIdCarrito(rs.getString("ID_Carrito"));
                this.venta.setProducto(rs.getString("Producto"));
                this.venta.setRegion(rs.getString("Region"));
                this.venta.setPrecio(rs.getDouble("Precio"));
                this.venta.setCantidadProoducto(rs.getInt("Total_Producto"));
                this.venta.setPrecioTotal(rs.getDouble("Precio_Total"));
                this.venta.setFecha(rs.getString("Fecha"));
                
                listaVenta.add(venta);
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return null;
        }
        return listaVenta;
    }

}
