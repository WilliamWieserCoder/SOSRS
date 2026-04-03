import java.sql.*;
import java.util.ArrayList;

public class AlertaDAO {
    
    public ArrayList<Alerta> listarAlertas() {
        ArrayList<Alerta> alertas = new ArrayList<>();
        String sql = "SELECT * FROM alertas WHERE status = 'ativo' ORDER BY id DESC";
        
        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Alerta a = new Alerta(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("descricao"),
                    rs.getString("localizacao"),
                    rs.getString("gravidade"),
                    rs.getString("status")
                );
                alertas.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alertas;
    }
    
    public boolean cadastrarAlerta(Alerta alerta) {
        String sql = "INSERT INTO alertas (titulo, descricao, localizacao, gravidade) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, alerta.getTitulo());
            stmt.setString(2, alerta.getDescricao());
            stmt.setString(3, alerta.getLocalizacao());
            stmt.setString(4, alerta.getGravidade());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}