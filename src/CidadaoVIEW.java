import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CidadaoVIEW extends JFrame {
    
    private JTextArea txtDescricao;
    private JTextField txtLocalizacao;
    private DefaultListModel<String> modeloAlertas;
    private JList<String> listaAlertas;
    
    public CidadaoVIEW() {
        setTitle("SOS RS - Painel do Cidadão");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        
        // Painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(245, 245, 245));
        
        // ========== CABEÇALHO ==========
        JPanel header = new JPanel();
        header.setBounds(0, 0, 900, 70);
        header.setBackground(new Color(30, 136, 229));
        header.setLayout(null);
        
        JLabel lblLogo = new JLabel("🆘 SOS RS");
        lblLogo.setFont(new Font("Roboto", Font.BOLD, 20));
        lblLogo.setForeground(Color.WHITE);
        lblLogo.setBounds(20, 20, 150, 30);
        header.add(lblLogo);
        
        JLabel lblUsuario = new JLabel("👤 Olá, Visitante");
        lblUsuario.setFont(new Font("Roboto", Font.PLAIN, 14));
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setBounds(750, 25, 150, 25);
        header.add(lblUsuario);
        
        mainPanel.add(header);
        
        // ========== SEÇÃO ALERTAS ==========
        JLabel lblAlertas = new JLabel("🔴 ALERTAS ATIVOS");
        lblAlertas.setFont(new Font("Roboto", Font.BOLD, 20));
        lblAlertas.setBounds(30, 90, 250, 30);
        mainPanel.add(lblAlertas);
        
        // Botão Atualizar
        JButton btnAtualizar = new JButton("🔄 Atualizar");
        btnAtualizar.setBounds(750, 90, 120, 30);
        btnAtualizar.setBackground(Color.WHITE);
        btnAtualizar.addActionListener(e -> carregarAlertas());
        mainPanel.add(btnAtualizar);
        
        // Lista de alertas
        modeloAlertas = new DefaultListModel<>();
        listaAlertas = new JList<>(modeloAlertas);
        listaAlertas.setFont(new Font("Roboto", Font.PLAIN, 14));
        JScrollPane scrollAlertas = new JScrollPane(listaAlertas);
        scrollAlertas.setBounds(30, 130, 400, 200);
        scrollAlertas.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        mainPanel.add(scrollAlertas);
        
        // ========== SEÇÃO SOLICITAR SOCORRO ==========
        JLabel lblSocorro = new JLabel("🆘 SOLICITAR SOCORRO");
        lblSocorro.setFont(new Font("Roboto", Font.BOLD, 20));
        lblSocorro.setBounds(500, 90, 250, 30);
        mainPanel.add(lblSocorro);
        
        // Radio buttons
        JRadioButton rbResgate = new JRadioButton("Resgate");
        JRadioButton rbRisco = new JRadioButton("Risco Iminente");
        JRadioButton rbOutro = new JRadioButton("Outro");
        ButtonGroup grupoTipo = new ButtonGroup();
        grupoTipo.add(rbResgate);
        grupoTipo.add(rbRisco);
        grupoTipo.add(rbOutro);
        rbResgate.setSelected(true);
        
        rbResgate.setBounds(500, 130, 100, 25);
        rbRisco.setBounds(610, 130, 120, 25);
        rbOutro.setBounds(740, 130, 80, 25);
        mainPanel.add(rbResgate);
        mainPanel.add(rbRisco);
        mainPanel.add(rbOutro);
        
        // Campo Localização
        JLabel lblLocal = new JLabel("Localização:");
        lblLocal.setBounds(500, 170, 100, 25);
        mainPanel.add(lblLocal);
        
        txtLocalizacao = new JTextField();
        txtLocalizacao.setBounds(500, 195, 350, 35);
        txtLocalizacao.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        mainPanel.add(txtLocalizacao);
        
        // Campo Descrição
        JLabel lblDesc = new JLabel("Descrição:");
        lblDesc.setBounds(500, 240, 100, 25);
        mainPanel.add(lblDesc);
        
        txtDescricao = new JTextArea();
        txtDescricao.setRows(3);
        JScrollPane scrollDesc = new JScrollPane(txtDescricao);
        scrollDesc.setBounds(500, 265, 350, 80);
        scrollDesc.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        mainPanel.add(scrollDesc);
        
        // Botão Anexar
        JButton btnAnexar = new JButton("📎 Anexar foto/vídeo");
        btnAnexar.setBounds(500, 355, 150, 30);
        btnAnexar.setBackground(new Color(245, 245, 245));
        mainPanel.add(btnAnexar);
        
        // Botão Enviar
        JButton btnEnviar = new JButton("ENVIAR SOLICITAÇÃO");
        btnEnviar.setBounds(500, 400, 350, 45);
        btnEnviar.setBackground(new Color(229, 57, 53));
        btnEnviar.setForeground(Color.WHITE);
        btnEnviar.setFont(new Font("Roboto", Font.BOLD, 14));
        btnEnviar.addActionListener(e -> enviarSolicitacao(rbResgate, rbRisco, rbOutro));
        mainPanel.add(btnEnviar);
        
        // ========== RECURSOS EDUCATIVOS ==========
        JLabel lblEducativos = new JLabel("📚 RECURSOS EDUCATIVOS");
        lblEducativos.setFont(new Font("Roboto", Font.BOLD, 16));
        lblEducativos.setBounds(30, 360, 250, 30);
        mainPanel.add(lblEducativos);
        
        JButton btnGuia = new JButton("📖 Guia de Primeiros Socorros");
        btnGuia.setBounds(30, 400, 250, 40);
        btnGuia.setBackground(Color.WHITE);
        btnGuia.setBorder(BorderFactory.createLineBorder(new Color(30, 136, 229)));
        btnGuia.addActionListener(e -> mostrarGuia());
        mainPanel.add(btnGuia);
        
        JButton btnKit = new JButton("🎒 Kit Emergência");
        btnKit.setBounds(30, 450, 250, 40);
        btnKit.setBackground(Color.WHITE);
        btnKit.setBorder(BorderFactory.createLineBorder(new Color(30, 136, 229)));
        btnKit.addActionListener(e -> mostrarKit());
        mainPanel.add(btnKit);
        
        // Botão Sair
        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(750, 600, 100, 35);
        btnSair.addActionListener(e -> {
            this.dispose();
            new LoginVIEW().setVisible(true);
        });
        mainPanel.add(btnSair);
        
        add(mainPanel);
        
        // Carregar alertas
        carregarAlertas();
    }
    
 private void carregarAlertas() {
    modeloAlertas.clear();
    AlertaDAO dao = new AlertaDAO();
    ArrayList<Alerta> alertas = dao.listarAlertas();
    
    for (Alerta a : alertas) {
        String cor = "";
        switch (a.getGravidade()) {
            case "vermelho": cor = "🔴"; break;
            case "amarelo": cor = "🟡"; break;
            case "verde": cor = "🟢"; break;
        }
        modeloAlertas.addElement(cor + " " + a.getTitulo() + " - " + a.getLocalizacao());
    }
    
    if (alertas.isEmpty()) {
        modeloAlertas.addElement("Nenhum alerta no momento");
    }
}
    
   private void enviarSolicitacao(JRadioButton rbResgate, JRadioButton rbRisco, JRadioButton rbOutro) {
    String localizacao = txtLocalizacao.getText();
    String descricao = txtDescricao.getText();
    
    if (localizacao.isEmpty() || descricao.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Atenção", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    String tipo;
    if (rbResgate.isSelected()) tipo = "resgate";
    else if (rbRisco.isSelected()) tipo = "risco iminente";
    else tipo = "outro";
    
    // UsuarioId 2 = João Cidadão (do banco)
    Solicitacao nova = new Solicitacao(0, 2, tipo, localizacao, descricao, "media", "pendente", "");
    
    SolicitacaoDAO dao = new SolicitacaoDAO();
    if (dao.cadastrarSolicitacao(nova)) {
        JOptionPane.showMessageDialog(this, "Solicitação enviada com sucesso!");
        txtLocalizacao.setText("");
        txtDescricao.setText("");
    } else {
        JOptionPane.showMessageDialog(this, "Erro ao enviar solicitação!");
    }
}
    
    private void mostrarGuia() {
        String guia = "📖 GUIA DE PRIMEIROS SOCORROS\n\n" +
                      "1. Mantenha a calma\n" +
                      "2. Ligue para o 192 (SAMU)\n" +
                      "3. Não mova a vítima se houver risco de fratura\n" +
                      "4. Aguarde o resgate em local seguro\n" +
                      "5. Tenha os documentos em mãos";
        JOptionPane.showMessageDialog(this, guia, "Guia de Primeiros Socorros", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void mostrarKit() {
        String kit = "🎒 KIT EMERGÊNCIA\n\n" +
                     "✓ Água potável (3 litros por pessoa)\n" +
                     "✓ Lanterna e pilhas\n" +
                     "✓ Rádio portátil\n" +
                     "✓ Documentos (cópias)\n" +
                     "✓ Medicamentos essenciais\n" +
                     "✓ Alimentos não perecíveis\n" +
                     "✓ Cobertores e roupas";
        JOptionPane.showMessageDialog(this, kit, "Kit Emergência", JOptionPane.INFORMATION_MESSAGE);
    }
}