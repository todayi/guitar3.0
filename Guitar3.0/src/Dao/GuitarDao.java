package Dao;

import java.util.ArrayList;
import java.util.List;

import Model.Guitar;

public interface GuitarDao {
	public List<Guitar> findALL() throws Exception ;
	public void addGuitar(Guitar guitar) throws Exception;
	public boolean deleteGuitar(int id) throws Exception;
}
