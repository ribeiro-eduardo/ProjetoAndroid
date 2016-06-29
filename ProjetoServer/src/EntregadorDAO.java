import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EntregadorDAO {
	public EntregadorDAO(){}
	
	public int loginEntregador(Entregador entregador){
		String sql = "SELECT senha FROM entregador WHERE login = ?";
		
		try(Connection conexao = new ConnectionFactory().getConnection()){
			System.out.println("Conexão realizada com sucesso");
			
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.setString(1, entregador.getLogin());
				
				try(ResultSet rs = stmt.executeQuery()){
					String senhaBD = null;
					while(rs.next()){
						senhaBD = rs.getString("senha");
					}
					if(senhaBD.equals(entregador.getSenha()))
						return rs.getInt("id");
				}catch (Exception e){
					e.printStackTrace();
				}
			}catch(Exception e){
				e.printStackTrace();
			} 			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return 0;
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
