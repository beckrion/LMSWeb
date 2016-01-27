package com.gcit.training.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gcit.training.lms.dao.AuthorDAO;
import com.gcit.training.lms.entity.Author;

public class AdministrativeService {
	
	public void addAuthor(Author author) throws SQLException{
		ConnectionUtil connUtil = new ConnectionUtil();
		Connection connection = connUtil.getConnection();
		try{
			AuthorDAO adao = new AuthorDAO(connection);
			adao.create(author);
			connection.commit();
		}catch (Exception e){
			e.printStackTrace();
			connection.rollback();
		}finally{
			connection.close();
		}
		
	}
	
	public List<Author> getAllAuthors() throws SQLException{
		ConnectionUtil connUtil = new ConnectionUtil();
		Connection connection = connUtil.getConnection();
		try{
			AuthorDAO adao = new AuthorDAO(connection);
			return adao.readAll();
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}finally{
			connection.close();
		}
	}

}
