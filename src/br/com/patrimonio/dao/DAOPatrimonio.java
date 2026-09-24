package br.com.patrimonio.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.patrimonio.pojo.Cursos;
import br.com.patrimonio.pojo.Patrimonio;

public class DAOPatrimonio extends Conexao implements CRUD<Patrimonio>{

	@Override
	public String cadastrar(Patrimonio obj) {
		String msg = "Cadastro realizado";
		try {
			if(abrir()) {
				String cursoInsert= "INSERT INTO patrimonios(numero_tombamento,nome,descricao,curso_id,local_id, categoria_id,criado_por,status,valor_aquisicao,data_aquisicao)VALUES(?,?,?,?,?,?,?,?,?,?)";
				pst = con.prepareStatement(cursoInsert);
				
				pst.setString(1, obj.getNumero_tombamento());
				pst.setString(2, obj.getNome());
				pst.setString(3, obj.getDescricao());
				pst.setInt(4, obj.getCurso_id());
				pst.setInt(5, obj.getLocais_id());
				pst.setInt(6, obj.getCategoria_id());
				pst.setInt(7,obj.getCriado_por());
				pst.setString(8, obj.getStatus().toString());
				pst.setDouble(9, obj.getValor_aquisicao());
				pst.setDate(10, obj.getData_aquisicao());
				
				int i = pst.executeUpdate();
				if(i < 1) {
					msg = "Não foi possível cadastrar o patrimônio";
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
	public Boolean atualizar(Patrimonio obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patrimonio> listar() {
		List<Patrimonio> lista = new ArrayList<Patrimonio>();
		try {
			//abrir o banco de dados
			if(abrir()) {
				String sql = "SELECT * FROM patrimonios;";
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
					Patrimonio pa = new Patrimonio();
					pa.setId(rs.getInt(1));
					pa.setNumero_tombamento(rs.getString(2));
					pa.setNome(rs.getString(3));
					pa.setDescricao(rs.getString(4));
					pa.setCurso_id(rs.getInt(5));
					pa.setLocais_id(rs.getInt(6));
					pa.setCategoria_id(rs.getInt(7));
					pa.setValor_aquisicao(rs.getDouble(9));
					pa.setData_aquisicao(rs.getDate(10));
					pa.setCriado_por(rs.getInt(11));
					pa.setAtualizado_por(rs.getInt(12));
					pa.setCriado_em(rs.getDate(13));
					pa.setAtualizado_em(rs.getDate(14));			
					
					lista.add(pa);									
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
	public Patrimonio listarID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
