package pe.uni.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pe.uni.entity.Curso;
import pe.uni.repository.CursoRepository;
import pe.uni.util.Conexion;

public class CursoRepositoryImpl implements CursoRepository {

	public boolean insertar(Curso curso) {
		boolean flag = false;
		try {
			Connection conexion = Conexion.conectar();
			
			String sql = "insert into curso(nombre) values(?)";
			PreparedStatement pstmt = conexion.prepareStatement(sql);
			pstmt.setString(1, curso.getNombre());
			int filas =pstmt.executeUpdate();			
			if(filas == 1) {
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	public boolean eliminar(int id) {
		boolean flag = false;
		
		try {
			Connection conex = Conexion.conectar();
			
			String sql = "delete from curso where id = ?";
			PreparedStatement pstmt = conex.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			int filas = pstmt.executeUpdate();
			if(filas == 1) {
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	public boolean actualizar(Curso curso) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Curso> buscarLibroPorNombre(String nombre) {
		List<Curso> cursos = new ArrayList<Curso>();
		try {
			Connection conex = Conexion.conectar();
			String sql ="select * from curso where titulo like ?";
			PreparedStatement pstmt = conex.prepareStatement(sql);
			pstmt.setString(1, "%"+nombre+"%");
			ResultSet rs = pstmt.executeQuery();
			Curso objCurso = null;
			while(rs.next()) {
				objCurso = new Curso();
				objCurso.setId(rs.getInt("id"));
				objCurso.setNombre(rs.getString("nombre"));
				cursos.add(objCurso);
			}
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}		
		return cursos;
	}

	public Curso buscarCursoPorID(int id) {
		Curso objCurso =null;
		try {
			Connection conex = Conexion.conectar();
			String sql ="select * from libro where id =?";
			PreparedStatement pstmt = conex.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				objCurso = new Curso();
				objCurso.setId(rs.getInt("id"));
				objCurso.setNombre(rs.getString("nombre"));
			}
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}		
		return objCurso;
	}

	public List<Curso> listar() {
		List<Curso> cursos = new ArrayList<Curso>();
		try {
			Connection conex = Conexion.conectar();
			String sql ="select * from libro";
			PreparedStatement pstmt = conex.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Curso objCurso = null;
			while(rs.next()) {
				objCurso = new Curso();
				objCurso.setId(rs.getInt("id"));
				objCurso.setNombre(rs.getString("nombre"));
				cursos.add(objCurso);
			}
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}		
		return cursos;
	}

}
