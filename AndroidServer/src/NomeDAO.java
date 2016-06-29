import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.ConnectionFactory;

public class NomeDAO {
	private final String stmtInserir = "INSERT INTO nomes(nome, idade) VALUES(?,?)";
    private final String stmtConsultar = "SELECT * FROM nomes WHERE id = ?";
    private final String stmtListar = "SELECT * FROM nomes";

    public void inserirNome(Nome nome) {
    	System.out.println("entrou no método");
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtInserir,PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, nome.getNome());
            stmt.setString(2, nome.getIdade());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir um Nome no banco de dados. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexÃ£o. Ex="+ex.getMessage());};
        }
     }
    

}
