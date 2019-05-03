package pe.uni.repository;


import java.util.List;

import pe.uni.entity.Curso;

public interface CursoRepository {
	public boolean insertar(Curso curso);
	
	public boolean eliminar(int id);
	
	public boolean actualizar(Curso curso);
	
	//public Libro buscarLibro(String titulo);
	public List<Curso> buscarLibroPorNombre(String nombre);
	
	public Curso buscarCursoPorID(int id);
	
	
	public List<Curso> listar();
}
