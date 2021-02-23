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
public class DAL_ListaUsuario {
    
    private Usuario usuario;
    private Connection dbCon;
    private LinkedList<Usuario> listaUsuarios;

    public DAL_ListaUsuario(Connection _dbCon, Usuario _usuario) {
        dbCon = _dbCon;
        if (_usuario != null) {
            this.usuario = _usuario;
        } else {
            this.usuario = new Usuario();
        }
    }
    
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
       
}
