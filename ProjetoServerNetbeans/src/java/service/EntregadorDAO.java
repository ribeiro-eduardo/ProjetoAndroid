package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EntregadorDAO {
		
	public int login(String login, String senha) throws SQLException {
        String stmtValidarLogin = "SELECT * FROM entregador WHERE login=? and senha=?";    
            
        Connection          conn    = null;
        PreparedStatement   stmt    = null;
        ResultSet           rset    = null;
        
        try{
                                  
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(stmtValidarLogin);
            stmt.setString(1,login);
            stmt.setString(2,senha);
            System.out.println(login);
            System.out.println(senha);
            
            rset = stmt.executeQuery();          
            
            if (rset.next()) {
                return rset.getInt("cod");
            }
            else {
                return 0;
            }
           
            
        }catch(SQLException ex){
            throw new RuntimeException("Erro ao validar Login." +ex.getMessage());
        }finally{
            try{rset.close();}catch(Exception ex){System.out.println("Erro ao finalizar lista de resultados: "+ex.getMessage());}
            try{stmt.close();  }catch(Exception ex){System.out.println("Erro ao finalizar busca: "+ex.getMessage());}
            try{conn.close();   }catch(Exception ex){System.out.println("Erro ao finalizar conexão: "+ex.getMessage());}
        }
    }
	
	public boolean inserirEntregador(Entregador e) throws SQLException{
		String sql = "INSERT INTO entregador(login, senha) values (?,?)";
		
		try(Connection conexao = new ConnectionFactory().getConnection()){
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.setString(1, e.getLogin());
				stmt.setString(2, e.getSenha());
				stmt.executeUpdate();
				return true;
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	} 
}
