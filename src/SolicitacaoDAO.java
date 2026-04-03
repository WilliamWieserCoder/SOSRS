import java.sql.*;
import java.util.ArrayList;

public class SolicitacaoDAO {
    
    public ArrayList<Solicitacao> listarSolicitacoesPendentes() {
        ArrayList<Solicitacao> solicitacoes = new ArrayList<>();
        String sql = "SELECT * FROM solicitacoes WHERE status = 'pendente' ORDER BY id DESC";
        
        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Solicitacao s = new Solicitacao(
                    rs.getInt("id"),
                    rs.getInt("usuario_id"),
                    rs.getString("tipo"),
                    rs.getString("localizacao"),
                    rs.getString("gravidade"),
                    rs.getString("status"),
                    rs.getString("midia")
                );
                s.setDescricao(rs.getString("descricao"));
                solicitacoes.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return solicitacoes;
    }
    
    public boolean cadastrarSolicitacao(Solicitacao solicitacao) {
        String sql = "INSERT INTO solicitacoes (usuario_id, tipo, localizacao, descricao, gravidade) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, solicitacao.getUsuarioId());
            stmt.setString(2, solicitacao.getTipo());
            stmt.setString(3, solicitacao.getLocalizacao());
            stmt.setString(4, solicitacao.getDescricao());
            stmt.setString(5, solicitacao.getGravidade());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean atenderSolicitacao(int id) {
        String sql = "UPDATE solicitacoes SET status = 'em_atendimento' WHERE id = ?";
        
        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}