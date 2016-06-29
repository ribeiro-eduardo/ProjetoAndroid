package service;


public class Entregador {

    private int id;
    private String login;
    private String senha;
        
    public Entregador() {
    }
    public Entregador(String login, String senha){
            this.login = login;
            this.senha = senha;
    }
	
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setIdade(String senha) {
        this.senha = senha;
    }
	
}
