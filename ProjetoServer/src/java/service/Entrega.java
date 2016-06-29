package service;


public class Entrega {
	private int id;
	private String endereco;
	private String descricao;
	private String status;
	private int entregador_id;
	
	
	
	public Entrega(String endereco, String descricao, int entregador_id) {
		super();
		this.endereco = endereco;
		this.descricao = descricao;
		this.entregador_id = entregador_id;
	}
	
	public Entrega(int id, String endereco, String descricao, String status, int entregador_id){
		super();
		this.id = id;
		this.endereco = endereco;
		this.descricao = descricao;
		this.status = status;
		this.entregador_id = entregador_id;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getEntregador_id() {
		return entregador_id;
	}
	
	public void setEntregador_id(int entregador_id) {
		this.entregador_id = entregador_id;
	}
}
