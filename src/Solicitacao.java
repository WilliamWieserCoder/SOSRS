public class Solicitacao {
    private int id;
    private int usuarioId;
    private String tipo; // "resgate", "risco iminente", "outro"
    private String localizacao;
    private String descricao; // ← NOVO CAMPO ADICIONADO
    private String gravidade; // "baixa", "media", "alta"
    private String status; // "pendente", "em atendimento", "concluido"
    private String midia; // caminho da foto/video
    
    public Solicitacao() {}
    
    // Construtor original (sem descricao) - mantido para compatibilidade
    public Solicitacao(int id, int usuarioId, String tipo, String localizacao, String gravidade, String status, String midia) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.tipo = tipo;
        this.localizacao = localizacao;
        this.gravidade = gravidade;
        this.status = status;
        this.midia = midia;
        this.descricao = ""; // valor padrão
    }
    
    // NOVO CONSTRUTOR COM DESCRICAO (para usar com o banco)
    public Solicitacao(int id, int usuarioId, String tipo, String localizacao, String descricao, String gravidade, String status, String midia) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.tipo = tipo;
        this.localizacao = localizacao;
        this.descricao = descricao;
        this.gravidade = gravidade;
        this.status = status;
        this.midia = midia;
    }
    
    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }
    
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    
    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }
    
    // NOVO GETTER E SETTER PARA DESCRICAO
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    
    public String getGravidade() { return gravidade; }
    public void setGravidade(String gravidade) { this.gravidade = gravidade; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getMidia() { return midia; }
    public void setMidia(String midia) { this.midia = midia; }
}