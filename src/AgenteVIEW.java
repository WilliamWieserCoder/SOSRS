import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AgenteVIEW extends JFrame {
    
    private JTextField txtTitulo;
    private JTextField txtLocalizacao;
    private JTextArea txtDescricao;
    private JRadioButton rbVerde;
    private JRadioButton rbAmarelo;
    private JRadioButton rbVermelho;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaSolicitacoes;
    
    public AgenteVIEW() {
        setTitle("SOS RS - Defesa Civil");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1100, 750);
        setLocationRelativeTo(null);
        
        // Painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(245, 245, 245));
        
        // ========== CABEÇALHO ==========
        JPanel header = new JPanel();
        header.setBounds(0, 0, 1100, 70);
        header.setBackground(new Color(30, 136, 229));
        header.setLayout(null);
        
        JLabel lblLogo = new JLabel("🆘 SOS RS - Defesa Civil");
        lblLogo.setFont(new Font("Roboto", Font.BOLD, 20));
        lblLogo.setForeground(Color.WHITE);
        lblLogo.setBounds(20, 20, 250, 30);
        header.add(lblLogo);
        
        JLabel lblUsuario = new JLabel("👤 Agente");
        lblUsuario.setFont(new Font("Roboto", Font.PLAIN, 14));
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setBounds(1000, 25, 80, 25);
        header.add(lblUsuario);
        
        mainPanel.add(header);
        
        // ========== SEÇÃO CADASTRAR ALERTA ==========
        JLabel lblCadastrar = new JLabel("📢 CADASTRAR ALERTA");
        lblCadastrar.setFont(new Font("Roboto", Font.BOLD, 20));
        lblCadastrar.setBounds(30, 90, 300, 30);
        mainPanel.add(lblCadastrar);
        
        // Card branco do formulário
        JPanel cardCadastro = new JPanel();
        cardCadastro.setBounds(30, 130, 500, 320);
        cardCadastro.setBackground(Color.WHITE);
        cardCadastro.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        cardCadastro.setLayout(null);
        
        // Campo Título
        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(20, 20, 80, 25);
        cardCadastro.add(lblTitulo);
        
        txtTitulo = new JTextField();
        txtTitulo.setBounds(20, 45, 460, 35);
        txtTitulo.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        cardCadastro.add(txtTitulo);
        
        // Campo Localização
        JLabel lblLocal = new JLabel("Localização:");
        lblLocal.setBounds(20, 90, 80, 25);
        cardCadastro.add(lblLocal);
        
        txtLocalizacao = new JTextField();
        txtLocalizacao.setBounds(20, 115, 460, 35);
        txtLocalizacao.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        cardCadastro.add(txtLocalizacao);
        
        // Gravidade
        JLabel lblGravidade = new JLabel("Gravidade:");
        lblGravidade.setBounds(20, 160, 80, 25);
        cardCadastro.add(lblGravidade);
        
        rbVerde = new JRadioButton("🟢 Verde");
        rbAmarelo = new JRadioButton("🟡 Amarelo");
        rbVermelho = new JRadioButton("🔴 Vermelho");
        
        ButtonGroup grupoGravidade = new ButtonGroup();
        grupoGravidade.add(rbVerde);
        grupoGravidade.add(rbAmarelo);
        grupoGravidade.add(rbVermelho);
        
        rbVerde.setBounds(20, 185, 100, 25);
        rbAmarelo.setBounds(130, 185, 110, 25);
        rbVermelho.setBounds(250, 185, 110, 25);
        cardCadastro.add(rbVerde);
        cardCadastro.add(rbAmarelo);
        cardCadastro.add(rbVermelho);
        
        // Campo Descrição
        JLabel lblDesc = new JLabel("Descrição:");
        lblDesc.setBounds(20, 220, 80, 25);
        cardCadastro.add(lblDesc);
        
        txtDescricao = new JTextArea();
        txtDescricao.setRows(3);
        JScrollPane scrollDesc = new JScrollPane(txtDescricao);
        scrollDesc.setBounds(20, 245, 460, 60);
        scrollDesc.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        cardCadastro.add(scrollDesc);
        
        // Botão Publicar
        JButton btnPublicar = new JButton("PUBLICAR ALERTA");
        btnPublicar.setBounds(150, 320, 200, 40);
        btnPublicar.setBackground(new Color(30, 136, 229));
        btnPublicar.setForeground(Color.WHITE);
        btnPublicar.setFont(new Font("Roboto", Font.BOLD, 14));
        btnPublicar.addActionListener(e -> publicarAlerta());
        cardCadastro.add(btnPublicar);
        
        mainPanel.add(cardCadastro);
        
        // ========== SEÇÃO SOLICITAÇÕES PENDENTES ==========
        JLabel lblSolicitacoes = new JLabel("📋 SOLICITAÇÕES PENDENTES");
        lblSolicitacoes.setFont(new Font("Roboto", Font.BOLD, 20));
        lblSolicitacoes.setBounds(570, 90, 300, 30);
        mainPanel.add(lblSolicitacoes);
        
        // Lista de solicitações
        modeloLista = new DefaultListModel<>();
        listaSolicitacoes = new JList<>(modeloLista);
        listaSolicitacoes.setFont(new Font("Roboto", Font.PLAIN, 14));
        JScrollPane scrollSolicitacoes = new JScrollPane(listaSolicitacoes);
        scrollSolicitacoes.setBounds(570, 130, 480, 200);
        scrollSolicitacoes.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        mainPanel.add(scrollSolicitacoes);
        
        // Botão Atender
        JButton btnAtender = new JButton("Atender Selecionado");
        btnAtender.setBounds(720, 340, 180, 35);
        btnAtender.setBackground(new Color(30, 136, 229));
        btnAtender.setForeground(Color.WHITE);
        btnAtender.addActionListener(e -> atenderSolicitacao());
        mainPanel.add(btnAtender);
        
        // ========== MAPA DE ÁREAS DE RISCO ==========
        JLabel lblMapa = new JLabel("🗺️ MAPA DE ÁREAS DE RISCO");
        lblMapa.setFont(new Font("Roboto", Font.BOLD, 16));
        lblMapa.setBounds(30, 470, 300, 30);
        mainPanel.add(lblMapa);
        
        // Placeholder do mapa
        JPanel mapaPlaceholder = new JPanel();
        mapaPlaceholder.setBounds(30, 510, 1020, 150);
        mapaPlaceholder.setBackground(new Color(224, 224, 224));
        mapaPlaceholder.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        mapaPlaceholder.setLayout(new GridBagLayout());
        
        JLabel lblMapaTexto = new JLabel("🗺️ MAPA INTERATIVO");
        lblMapaTexto.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblMapaTexto.setForeground(new Color(102, 102, 102));
        mapaPlaceholder.add(lblMapaTexto);
        
        mainPanel.add(mapaPlaceholder);
        
        // Botão Sair
        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(970, 670, 100, 35);
        btnSair.addActionListener(e -> {
            this.dispose();
            new LoginVIEW().setVisible(true);
        });
        mainPanel.add(btnSair);
        
        add(mainPanel);
        
        // Carregar solicitações
        carregarSolicitacoes();
    }
    
    private void publicarAlerta() {
    String titulo = txtTitulo.getText();
    String localizacao = txtLocalizacao.getText();
    String descricao = txtDescricao.getText();
    
    String gravidade = "";
    if (rbVerde.isSelected()) gravidade = "verde";
    else if (rbAmarelo.isSelected()) gravidade = "amarelo";
    else if (rbVermelho.isSelected()) gravidade = "vermelho";
    
    if (titulo.isEmpty() || localizacao.isEmpty() || gravidade.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Atenção", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    Alerta novoAlerta = new Alerta(0, titulo, descricao, localizacao, gravidade, "ativo");
    AlertaDAO dao = new AlertaDAO();
    
    if (dao.cadastrarAlerta(novoAlerta)) {
        JOptionPane.showMessageDialog(this, "Alerta publicado com sucesso!");
        // Limpar campos
        txtTitulo.setText("");
        txtLocalizacao.setText("");
        txtDescricao.setText("");
        rbVerde.setSelected(false);
        rbAmarelo.setSelected(false);
        rbVermelho.setSelected(false);
    } else {
        JOptionPane.showMessageDialog(this, "Erro ao publicar alerta!");
    }
}
    
   private void carregarSolicitacoes() {
    modeloLista.clear();
    SolicitacaoDAO dao = new SolicitacaoDAO();
    ArrayList<Solicitacao> solicitacoes = dao.listarSolicitacoesPendentes();
    
    for (Solicitacao s : solicitacoes) {
        String gravidadeIcon = s.getGravidade().equals("alta") ? "🔴" : "🟡";
        modeloLista.addElement("#" + s.getId() + " | " + s.getTipo() + " | " + s.getLocalizacao() + " | " + gravidadeIcon);
    }
    
    if (modeloLista.isEmpty()) {
        modeloLista.addElement("Nenhuma solicitação pendente");
    }
}
    
    private void atenderSolicitacao() {
    int indice = listaSolicitacoes.getSelectedIndex();
    if (indice == -1) {
        JOptionPane.showMessageDialog(this, "Selecione uma solicitação para atender!");
        return;
    }
    
    String selecionado = modeloLista.getElementAt(indice);
    if (selecionado.equals("Nenhuma solicitação pendente")) {
        return;
    }
    
    // Extrair ID da solicitação
    String[] partes = selecionado.split(" \\| ");
    int id = Integer.parseInt(partes[0].replace("#", ""));
    
    SolicitacaoDAO dao = new SolicitacaoDAO();
    if (dao.atenderSolicitacao(id)) {
        JOptionPane.showMessageDialog(this, "Solicitação #" + id + " em atendimento!");
        carregarSolicitacoes();
    } else {
        JOptionPane.showMessageDialog(this, "Erro ao atender solicitação!");
    }
}
}