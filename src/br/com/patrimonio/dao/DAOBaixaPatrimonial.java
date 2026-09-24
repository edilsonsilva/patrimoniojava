package br.com.patrimonio.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.patrimonio.pojo.BaixasPatrimoniais;
import br.com.patrimonio.pojo.Patrimonio;

public class DAOBaixaPatrimonial extends Conexao implements CRUD<BaixasPatrimoniais> {

	@Override
	public String cadastrar(BaixasPatrimoniais obj) {
		String msg = "Cadastro realizado";
		try {
			if(abrir()) {
				String cursoInsert= "INSERT INTO baixas_patrimoniais(patrimonio_id,usuario_registro_id,tipo_baixa,motivo,valor_recuperado,documento_comprobatorio)values(?,?,?,?,?,?)";
				pst = con.prepareStatement(cursoInsert);
				
				pst.setInt(1, obj.getPatrimonio_id());
				pst.setInt(2, obj.getUsuario_registro_id());
				pst.setString(3, obj.getTipo_baixa().toString());
				pst.setString(4, obj.getMotivo());
				pst.setDouble(5, obj.getValor_recuperado());
				pst.setString(6, obj.getDocumento_comprobatorio());
				
				int i = pst.executeUpdate();
				if(i < 1) {
					msg = "Não foi possível cadastrar a baixa patrimonial";
				}
				
			}
			else {
				msg = "Não foi possível abrir o banco";
			}
		}
		catch(SQLException se) {
			msg = "Erro ao tentar cadastar o curso. Mensagem:"+se.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado. Mensagem: "+e.getMessage();
		}
		return msg;
		
	}
	@Override
	public Boolean atualizar(BaixasPatrimoniais obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaixasPatrimoniais> listar() {
		List<BaixasPatrimoniais> lista = new ArrayList<BaixasPatrimoniais>();
		try {
			//abrir o banco de dados
			if(abrir()) {
				String sql = "SELECT * FROM baixas_patrimoniais;";
				//preparar a consulta para ser executada
				pst = con.prepareStatement(sql);
				//Executar a consulta com o comando executeQuery, assim teremos
				//o comando Select sendo executado. O resultado da consulta é 
				//Guardado em um variável do tipo ResultSet(rs). Sempre que você
				//tiver uma consulta SELECT o retorno desta consulta deve ficar
				//em um ResultSet
				
				rs = pst.executeQuery();
				//O comando next() faz o cursor se movimentar para adiante
				//dentro da tabela, quando há dados. Se não houver dados
				//o cursor não se movimenta e retorna falso, indicando
				//que os  dados da tabela acabaram
				while(rs.next()) {
					//Todas as vezes que laço while "roda", significa que 
					//o comando next() executou e assim foi para a próxima
					//linha e trazendo os dados desta linha.
					//Para organizar e guardar os dados dos usuários, criamos
					//um novo usuário da camada POJO e, passamos todos os 
					//dados retornados do rs para cada campo do usuario.
					//Depois adicionamos este usuário a lista de usuários
					//selecionados
					BaixasPatrimoniais bp = new BaixasPatrimoniais();
					bp.setId(rs.getInt(1));
					bp.setPatrimonio_id(rs.getInt(2));
					bp.setUsuario_registro_id(rs.getInt(3));
					bp.setMotivo(rs.getString(5));
					bp.setValor_recuperado(rs.getDouble(6));
					bp.setDocumento_comprobatorio(rs.getString(7));
					bp.setData_baixa(rs.getDate(9));			
					
					lista.add(bp);
					
				
					
				}
			}
			else {
				System.out.println("Erro ao tentar abrir a conexão");
			}
		}
		catch(SQLException se) {
			System.out.print("Erro ao tentar executar a consulta. Mensagem:"+se.getMessage());
		}
		catch(Exception e) {
			System.out.println("Erro inesperado. Mensagem:"+e.getMessage());
		}
		finally {
			fechar();
		}
		
		return lista;
	}

	@Override
	public BaixasPatrimoniais listarID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
