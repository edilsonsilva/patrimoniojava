package br.com.patrimonio.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.patrimonio.pojo.Cursos;
import br.com.patrimonio.pojo.Movimentacoes;

public class DAOMovimentacoes extends Conexao implements CRUD<Movimentacoes> {

	@Override
	public String cadastrar(Movimentacoes obj) {
		String msg = "Cadastro realizado";
		

		try {
			if(abrir()) {
				String cursoInsert= "INSERT INTO movimentacoes(patrimonio_id,usuario_registro_id,tipo_movimentacao,responsavel_destino,documento_responsavel,data_prevista_retorno,data_efetiva_retorno,observacoes) values(?,?,?,?,?,?,?,?)"; 
				pst = con.prepareStatement(cursoInsert);
				
			
				pst.setInt(1, obj.getPatrimonio_id());
				pst.setInt(2, obj.getUsuario_registro_id());
				pst.setString(3,obj.getTipo_movimentacao().toString());
				pst.setString(4, obj.getResponsavel_destino());
				pst.setString(5, obj.getDocumento_responsavel());
				pst.setDate(6,obj.getData_prevista_retorno());
				pst.setDate(7, obj.getData_retorno_efetivo());
				pst.setString(8, obj.getObservacoes());
				
				
				int i = pst.executeUpdate();
				if(i < 1) {
					msg = "Não foi possível cadastrar a movimentações";
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
	public Boolean atualizar(Movimentacoes obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movimentacoes> listar() {
		List<Movimentacoes> lista = new ArrayList<Movimentacoes>();
		try {
			//abrir o banco de dados
			if(abrir()) {
				String sql = "SELECT * FROM movimentacoes";
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
					Movimentacoes mov = new Movimentacoes();
					
					mov.setId(rs.getInt(1));
					mov.setPatrimonio_id(rs.getInt(2));
					mov.setUsuario_registro_id(rs.getInt(3));
					//mov.setString(3,obj.getTipo_movimentacao().toString());
					mov.setResponsavel_destino(rs.getString(5));
					mov.setDocumento_responsavel(rs.getString(6));
					mov.setData_saida(rs.getDate(7));
					mov.setData_prevista_retorno(rs.getDate(8));
					mov.setData_retorno_efetivo(rs.getDate(9));
					mov.setObservacoes(rs.getString(10));			
					
					
				
					lista.add(mov);									
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
	public Movimentacoes listarID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
