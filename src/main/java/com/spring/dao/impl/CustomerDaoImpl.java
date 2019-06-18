package com.spring.dao.impl;

import java.sql.PreparedStatement;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.spring.model.Utilisateur;


@Repository
public class CustomerDaoImpl extends JdbcDaoSupport implements com.spring.dao.CustomerDao {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public void insert(List<? extends Utilisateur> Customers) {
		String sql = "INSERT INTO utilisateur " + "(id, name) VALUES (?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Utilisateur customer = Customers.get(i);
				ps.setLong(1, customer.getId());
				ps.setString(2, customer.getName());
			}

			public int getBatchSize() {
				return Customers.size();
			}
		});

	}

	@Override
	public List<Utilisateur> loadAllCustomers() {
		String sql = "SELECT * FROM utilisateur";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

		List<Utilisateur> result = new ArrayList<>();
		for (Map<String, Object> row : rows) {
			Utilisateur customer = new Utilisateur();
			customer.setId((Integer) row.get("id"));
			customer.setName((String) row.get("name"));
			result.add(customer);
		}

		return result;
	}
}
