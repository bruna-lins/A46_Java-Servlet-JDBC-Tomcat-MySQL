package model;

public class JavaBeans {
	private int id_dest;
	private String nome;
	private String descricao;
	private int valor;
	private String image;
	
	
	
	public JavaBeans() {
		super();
	}
	
	
	public JavaBeans(int id_dest, String nome, String descricao, int valor, String image) {
		super();
		this.id_dest = id_dest;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.image = image;
	}



	public int getId_dest() {
		return id_dest;
	}
	public void setId_dest(int id_dest) {
		this.id_dest = id_dest;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
