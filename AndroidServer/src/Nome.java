public class Nome {
	private int id;
	private String nome;
	private String idade;
	
	public Nome(String nome, String idade){
		this.nome = nome;
		this.idade = idade;
	}
	
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
}
