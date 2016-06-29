package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntregaDAO {
	public EntregaDAO(){}
	
	public boolean inserirEntrega(Entrega e) throws SQLException{
		String sql = "INSERT INTO entrega(endereco, descricao, foto, entregador_id) values (?,?,?,?)";
		
		try(Connection conexao = new ConnectionFactory().getConnection()){
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.setString(1, e.getEndereco());
				stmt.setString(2, e.getDescricao());
				stmt.setString(3, "");
				stmt.setInt(4, e.getEntregador_id());
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
	
	public List<Entrega> getTodos() throws SQLException{
		String sql = "SELECT * FROM entrega ORDER BY id"; 
		
        Connection          conn    = null;
        PreparedStatement   stmt    = null;
        ResultSet           rset    = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);
            
            rset = stmt.executeQuery();
            List<Entrega> listaTodos = new ArrayList();
            
            while (rset.next()) {
            	int id = rset.getInt("id");
            	String endereco = rset.getString("endereco");
            	String descricao = rset.getString("descricao");
            	int entregador_id = rset.getInt("entregador_id");
            	String status = rset.getString("status");
            	
                Entrega e = new Entrega(id, endereco, descricao, status, entregador_id);
                
                listaTodos.add(e);
            }
            
            return listaTodos;
            
        }catch(SQLException ex){
            throw new RuntimeException("Erro ao buscar Entregas. "+ex.getMessage());
        }finally{
            try{rset.close();}catch(Exception ex){System.out.println("Erro ao finalizar lista de resultados: "+ex.getMessage());}
            try{stmt.close();  }catch(Exception ex){System.out.println("Erro ao finalizar busca: "+ex.getMessage());}
            try{conn.close();   }catch(Exception ex){System.out.println("Erro ao finalizar conexão: "+ex.getMessage());}
        }
    }
	
	public List<Entrega> getPorEntregador(int entregador_id) throws SQLException{
		String sql = "SELECT * FROM entrega WHERE entregador_id = ? ORDER BY id"; 
		
        Connection          conn    = null;
        PreparedStatement   stmt    = null;
        ResultSet           rset    = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, entregador_id);
            rset = stmt.executeQuery();
            
            List<Entrega> listaTodos = new ArrayList();
            
            while (rset.next()) {
            	int id = rset.getInt("id");
            	String endereco = rset.getString("endereco");
                System.out.println(endereco);
            	String descricao = rset.getString("descricao");
            	String status = rset.getString("status");
            	
                Entrega e = new Entrega(id, endereco, descricao, status, entregador_id);
                
                listaTodos.add(e);
            }
            
            System.out.println(listaTodos);
            return listaTodos;
            
        }catch(SQLException ex){
            throw new RuntimeException("Erro ao buscar Entregas. "+ex.getMessage());
        }finally{
            try{rset.close();}catch(Exception ex){System.out.println("Erro ao finalizar lista de resultados: "+ex.getMessage());}
            try{stmt.close();  }catch(Exception ex){System.out.println("Erro ao finalizar busca: "+ex.getMessage());}
            try{conn.close();   }catch(Exception ex){System.out.println("Erro ao finalizar conexão: "+ex.getMessage());}
        }
    }

}
