public class Alerta {
    private int id;
    private String titulo;
    private String descricao;
    private String localizacao;
    private String gravidade; // "verde", "amarelo", "vermelho"
    private String status; // "ativo", "resolvido"
    
    public Alerta() {}
    
    public Alerta(int id, String titulo, String descricao, String localizacao, String gravidade, String status) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.gravidade = gravidade;
        this.status = status;
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    
    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }
    
    public String getGravidade() { return gravidade; }
    public void setGravidade(String gravidade) { this.gravidade = gravidade; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public void exibir() {
        System.out.println("[" + gravidade.toUpperCase() + "] " + titulo + " - " + localizacao);
        System.out.println("  " + descricao);
    }
}