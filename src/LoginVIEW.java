import javax.swing.*;
import java.awt.*;

public class LoginVIEW extends JFrame {
    
    private JTextField txtEmail;
    private JPasswordField txtSenha;
    private JButton btnEntrar;
    private JButton btnVisitante;
    
    public LoginVIEW() {
        setTitle("SOS RS - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Criar o painel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(245, 245, 245));
        
        // Título principal
        JLabel lblTitulo = new JLabel("SOS RS");
        lblTitulo.setFont(new Font("Roboto", Font.BOLD, 36));
        lblTitulo.setForeground(new Color(30, 136, 229));
        lblTitulo.setBounds(150, 30, 200, 50);
        panel.add(lblTitulo);
        
        // Subtítulo
        JLabel lblSubtitulo = new JLabel("Sistema de Alerta e Prevenção");
        lblSubtitulo.setFont(new Font("Roboto", Font.PLAIN, 14));
        lblSubtitulo.setForeground(new Color(66, 66, 66));
        lblSubtitulo.setBounds(110, 80, 250, 25);
        panel.add(lblSubtitulo);
        
        // Label Email
        JLabel lblEmail = new JLabel("E-mail:");
        lblEmail.setFont(new Font("Roboto", Font.PLAIN, 14));
        lblEmail.setBounds(100, 130, 80, 25);
        panel.add(lblEmail);
        
        // Campo Email
        txtEmail = new JTextField();
        txtEmail.setBounds(100, 155, 250, 35);
        txtEmail.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        panel.add(txtEmail);
        
        // Label Senha
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Roboto", Font.PLAIN, 14));
        lblSenha.setBounds(100, 200, 80, 25);
        panel.add(lblSenha);
        
        // Campo Senha
        txtSenha = new JPasswordField();
        txtSenha.setBounds(100, 225, 250, 35);
        txtSenha.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        panel.add(txtSenha);
        
        // Botão Entrar
        btnEntrar = new JButton("Entrar");
        btnEntrar.setBackground(new Color(30, 136, 229));
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setFont(new Font("Roboto", Font.BOLD, 14));
        btnEntrar.setBounds(100, 280, 250, 40);
        btnEntrar.setBorder(BorderFactory.createEmptyBorder());
        btnEntrar.addActionListener(e -> fazerLogin());
        panel.add(btnEntrar);
        
        // Botão Visitante
        btnVisitante = new JButton("Acessar como visitante");
        btnVisitante.setBackground(new Color(245, 245, 245));
        btnVisitante.setForeground(new Color(30, 136, 229));
        btnVisitante.setFont(new Font("Roboto", Font.PLAIN, 12));
        btnVisitante.setBounds(140, 330, 170, 25);
        btnVisitante.setBorder(BorderFactory.createEmptyBorder());
        btnVisitante.addActionListener(e -> acessarVisitante());
        panel.add(btnVisitante);
        
        add(panel);
    }
    
   private void fazerLogin() {
    String email = txtEmail.getText();
    String senha = new String(txtSenha.getPassword());
    
    UsuarioDAO dao = new UsuarioDAO();
    Usuario usuario = dao.fazerLogin(email, senha);
    
    if (usuario != null) {
        JOptionPane.showMessageDialog(this, "Bem-vindo, " + usuario.getNome() + "!");
        
        if (usuario.getTipo().equals("agente")) {
            new AgenteVIEW().setVisible(true);
        } else {
            new CidadaoVIEW().setVisible(true);
        }
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, 
            "E-mail ou senha inválidos!\n\nUse:\nagente / 123\ncidadao / 123",
            "Erro",
            JOptionPane.ERROR_MESSAGE);
    }
}
    
    private void acessarVisitante() {
        JOptionPane.showMessageDialog(this, "Acessando como visitante!");
        new CidadaoVIEW().setVisible(true);
        this.dispose();
    }
}