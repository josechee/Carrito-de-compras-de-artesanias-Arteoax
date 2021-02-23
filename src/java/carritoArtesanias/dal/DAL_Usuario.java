/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carritoArtesanias.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import carritoArtesanias.el.Usuario;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class DAL_Usuario {

    private Usuario usuario;
    private Connection dbCon;
    private LinkedList<Usuario> listaUsuarios;

    public DAL_Usuario(Connection _dbCon, Usuario _usuario) {
        dbCon = _dbCon;
        if (_usuario != null) {
            this.usuario = _usuario;
        } else {
            this.usuario = new Usuario();
        }
    }

    //INSERTAR USUARIO
    public String addUsuarioToDataBase() throws SQLException {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        String verificador = null;
        try {
            cstmt = this.dbCon.prepareCall("{call tbl_Usuario_Insertar_SP(?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //cstmt.setString("Out_Matricula", this.alumno.getMatricula());

            cstmt.setString("Input_Correo", this.usuario.getCorreo());
            cstmt.setString("Input_Contraseña", this.usuario.getContraseña());
            //cstmt.setString("Out_ID_Usuario", this.proveedor.getColonia());

            boolean results = cstmt.execute();  //esta parte esta tronando
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
                verificador = rs.getString("idUsuario");//aqui se captura el ide del proveedor
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return null;
        }
        return verificador;//retorna el id del Proveedor
    }

    public Usuario queryUsuarioToDatabase(String idUsuario) {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call tbl_Usuario_Consultar_SP(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("In_ID_Usuario", idUsuario);
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
                this.usuario = new Usuario();
                this.usuario.setIdUsuario(rs.getString("ID_Usuario"));
                this.usuario.setCorreo(rs.getString("Correo"));
                this.usuario.setContraseña(rs.getString("Contraseña"));

            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return this.usuario;
        }
        return this.usuario;
    }

    /////////CONSULTAR  TODOS LOS USUARIOS/////////////////
    public LinkedList<Usuario> obtenerTodosLosUsuarios() {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        this.listaUsuarios = new LinkedList();
        try {
            cstmt = this.dbCon.prepareCall("{call tbl_Usuario_ConsultarTodos_SP()}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            boolean results = cstmt.execute();
            int rowsAffected = 0;

            while (results || rowsAffected != -1) {
                if (results) {
                    rs = cstmt.getResultSet();
                    // System.out.println(rs.getString("ID_Usuario"));
                    break;
                } else {
                    rowsAffected = cstmt.getUpdateCount();
                }
                results = cstmt.getMoreResults();

            }

            while (rs.next()) {
                this.usuario = new Usuario();
                this.usuario.setIdUsuario(rs.getString("ID_Usuario"));
                this.usuario.setCorreo(rs.getString("Correo"));
                this.usuario.setContraseña(rs.getString("Contraseña"));
                // verificador=rs.getInt(1);
                this.listaUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            // return verificador;
        }
        return this.listaUsuarios;
    }

    //////////////////////////////////////////7
}
