package com.example.sistema_orcamento.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "mov_orcamento_projeto")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_projeto")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "nome_projeto", nullable = false, length = 50)
    private String nome;

    @Column(name = "categoria_projeto", nullable = false, length = 50)
    private String categoria;

    @Column(name = "php")
    private Boolean php = false;

    @Column(name = "css")
    private Boolean css = false;

    @Column(name = "html")
    private Boolean html = false;

    @Column(name = "java")
    private Boolean java = false;

    @Column(name = "angular")
    private Boolean angular = false;

    @Column(name = "go")
    private Boolean go = false;

    @Column(name = "react")
    private Boolean react = false;

    @Column(name = "typeScript")
    private Boolean typeScript = false;

    @Column(name = "node_js")
    private Boolean nodeJs = false;

    @Column(name = "python")
    private Boolean python = false;

    @Column(name = "c_sharp")
    private Boolean cSharp = false;

    @Column(name = "oracle")
    private Boolean oracle = false;

    @Column(name = "sqlserver")
    private Boolean sqlServer = false;

    @Column(name = "postgresql")
    private Boolean postgresql = false;

    @Column(name = "mariadb")
    private Boolean mariaDb = false;

    @Column(name = "db2")
    private Boolean db2 = false;

    @Column(name = "mongodb")
    private Boolean mongoDb = false;

    @Column(name = "cassandra")
    private Boolean cassandra = false;

    @Column(name = "sqlite")
    private Boolean sqlite = false;

    @Column(name = "outras_linguagens_banco_dados", length = 100)
    private String outrasLinguagensBancoDados;

    @Column(name = "duracao", length = 30)
    private String duracao;

    @Column(name = "status", length = 10)
    private String status;
    
    //@Column(name = "preco", precision = 10)
    private double preco;

    @Column(name = "datacriacao", nullable = false, updatable = false)
    private LocalDate dataCriacao;

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDate.now();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Boolean getPhp() {
        return php;
    }

    public void setPhp(Boolean php) {
        this.php = php;
    }

    public Boolean getCss() {
        return css;
    }

    public void setCss(Boolean css) {
        this.css = css;
    }

    public Boolean getHtml() {
        return html;
    }

    public void setHtml(Boolean html) {
        this.html = html;
    }

    public Boolean getJava() {
        return java;
    }

    public void setJava(Boolean java) {
        this.java = java;
    }

    public Boolean getAngular() {
        return angular;
    }

    public void setAngular(Boolean angular) {
        this.angular = angular;
    }

    public Boolean getGo() {
        return go;
    }

    public void setGo(Boolean go) {
        this.go = go;
    }

    public Boolean getReact() {
        return react;
    }

    public void setReact(Boolean react) {
        this.react = react;
    }

    public Boolean getTypeScript() {
        return typeScript;
    }

    public void setTypeScript(Boolean typeScript) {
        this.typeScript = typeScript;
    }

    public Boolean getNodeJs() {
        return nodeJs;
    }

    public void setNodeJs(Boolean nodeJs) {
        this.nodeJs = nodeJs;
    }

    public Boolean getPython() {
        return python;
    }

    public void setPython(Boolean python) {
        this.python = python;
    }

    public Boolean getCSharp() {
        return cSharp;
    }

    public void setCSharp(Boolean cSharp) {
        this.cSharp = cSharp;
    }

    public Boolean getOracle() {
        return oracle;
    }

    public void setOracle(Boolean oracle) {
        this.oracle = oracle;
    }

    public Boolean getSqlServer() {
        return sqlServer;
    }

    public void setSqlServer(Boolean sqlServer) {
        this.sqlServer = sqlServer;
    }

    public Boolean getPostgresql() {
        return postgresql;
    }

    public void setPostgresql(Boolean postgresql) {
        this.postgresql = postgresql;
    }

    public Boolean getMariaDb() {
        return mariaDb;
    }

    public void setMariaDb(Boolean mariaDb) {
        this.mariaDb = mariaDb;
    }

    public Boolean getDb2() {
        return db2;
    }

    public void setDb2(Boolean db2) {
        this.db2 = db2;
    }

    public Boolean getMongoDb() {
        return mongoDb;
    }

    public void setMongoDb(Boolean mongoDb) {
        this.mongoDb = mongoDb;
    }

    public Boolean getCassandra() {
        return cassandra;
    }

    public void setCassandra(Boolean cassandra) {
        this.cassandra = cassandra;
    }

    public Boolean getSqlite() {
        return sqlite;
    }

    public void setSqlite(Boolean sqlite) {
        this.sqlite = sqlite;
    }

    public String getOutrasLinguagensBancoDados() {
        return outrasLinguagensBancoDados;
    }

    public void setOutrasLinguagensBancoDados(String outrasLinguagensBancoDados) {
        this.outrasLinguagensBancoDados = outrasLinguagensBancoDados;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
}
