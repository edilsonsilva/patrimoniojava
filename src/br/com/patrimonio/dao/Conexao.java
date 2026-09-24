/*
 * O pacote br.com.patrimonio.dao, armazena as classes, interfaces e enus relacionados
 * a conexão com o banco de dados.
 */
package br.com.patrimonio.dao;
/*
 * Importação das classe e interfaces que serão utilizadas para estabelecer a conexão
 * com o banco de dados e executar os comandos de SQL.
 * A interface Connection(Conexão) permite estabelecer a conexão com o banco de dados
 * A interface DriverManager(Gerenciador de Drive) permite fazer passagem dos dados de 
 * conexão, tais como: url do banco, usuário e senha e, retorna a conexão estabelecida
 * com o banco
 * A classe SQLException(tratamento de erro) permite capturar o erro gerado ao tentar
 * executar um comando de SQL e exibir o erro na tela
 * A interface ResultSet(Resultado encontrado) é usada para guardar os retornos das 
 * consultas SELECT
 * A interface PreparedStatement é utilizada para executar comandos de sql que modificam
 * a estrutura das tabelas, tais como: INSERT , UPDATE , DELETE
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A classe Conexao é uma abstrata gerada para permitir a conexao com o banco de dados
 * das classe que farão a seleção, inserção, atualização e deleção de dados no banco de dados.
 * Nesta classe temos duas funções: abrir(), que abre a conexão com banco de dados e fechar(),
 */
public abstract class Conexao {	
	//O elemento con recebe uma conexao estabelecida com o 
	//o banco de dados. Portanto , ele deve ser do tipo 
	//Connection, assim estará preparado para receber a 
	//a conexao com o banco de dados. Iniciamos o objeto
	//con como null(nullo) para depois receber a conexão
	public Connection con = null;
	public PreparedStatement pst = null;
	public ResultSet rs = null;
	
	/**
	 * O método abrir é utilizado para estabelecer a conexão 
	 * com o banco de dados.
	 * @return 
	 * Retorna a conexão com o banco.
	 */
	public Boolean abrir() {
		Boolean abriu = true;
		try {
			
			//Carregar o driver de comunição com o banco de dados
			//mysql. Em tempo de execução será feita um instância
			//do driver, que o torna um objeto
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3060/squash_db", "root", "123@senac");
						
		}
		catch(SQLException se) {
			System.out.println("Erro ao tentar estabelecer a conexão com o banco de dados. Mensagem: "+se.getMessage());
			abriu = false;
		}
		catch(Exception ex) {
			System.out.println("Erro inesperado. Mensagem: "+ex.getMessage());
			abriu = false;
		}
		return abriu;
		
	}
	/**
	 * O método fechar, realiza o fechamento da conexão com o 
	 * banco de dados.
	 * @return
	 * Retorna que o banco foi fechado ou não
	 */
	public Boolean fechar() {
		Boolean fechou = true;
		try {
			con.close();
		}
		catch(SQLException se) {
			System.out.println("Erro ao tentar fechar o banco de dados. Mensagem: "+se.getMessage());
			fechou = false;
		}
		catch(Exception ex) {
			System.out.println("Erro inesperado. Mensagem: "+ex.getMessage());
			fechou = false;
		}
		return fechou;	
	}	
}
