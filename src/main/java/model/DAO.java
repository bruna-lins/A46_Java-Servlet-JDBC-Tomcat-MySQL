package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	/** Módulo de conexão **/

	// Parametros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/a46?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "15923";

	// Método de conexão

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CRUD CREATE **/
	
	public void inserirDestino(JavaBeans destino) {
		String create = "insert into destinos (nome, descricao, valor, image) values (?,?,?,?)";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);

			pst.setString(1, destino.getNome());
			pst.setString(2, destino.getDescricao());
			pst.setInt(3, destino.getValor());
			pst.setString(4, destino.getImage());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/** CRUD READ **/

	public ArrayList<JavaBeans> listarDestinos() {

		ArrayList<JavaBeans> destinos = new ArrayList<>();

		String read = "select * from destinos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				int id_dest = rs.getInt(1);
				String nome = rs.getString(2);
				String descricao = rs.getString(3);
				int valor = rs.getInt(4);
				String image = rs.getString(5);

				destinos.add(new JavaBeans(id_dest, nome, descricao, valor, image));
			}
			con.close();
			return destinos;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	/** CRUD UPDATE **/

	// selecionar o destino
	public void selecionarDestino(JavaBeans destino) {
		String read2 = "select * from destinos where Id_dest = ?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, destino.getId_dest());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				destino.setId_dest(rs.getInt(1));
				destino.setNome(rs.getString(2));
				destino.setDescricao(rs.getString(3));
				destino.setValor(rs.getInt(4));
				destino.setImage(rs.getString(5));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//editar destinos
	public void alterarDestino(JavaBeans destino) {
		String updt = "update destinos set nome=?, descricao=?, valor=?, image=? where id_dest=?";
		
		try {
			Connection con= conectar();
			PreparedStatement pst = con.prepareStatement(updt);
			pst.setString(1, destino.getNome());
			pst.setString(2, destino.getDescricao());
			pst.setInt(3, destino.getValor());
			pst.setString(4, destino.getImage());
			pst.setInt(5, destino.getId_dest());
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD DELETE **/
	
	public void deletarDestino(JavaBeans destino) {
		String delete = "delete from destinos where Id_dest = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, destino.getId_dest());
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
}
