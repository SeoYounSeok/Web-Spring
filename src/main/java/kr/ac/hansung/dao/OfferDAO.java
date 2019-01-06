package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Offer;

@Repository
public class OfferDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int getRowCount() {
		String sqlStatement = "select count(*) from offers";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}
	
	public List<Offer> getSemesterOffers(int year, int semester) {
		String sqlStatement = "select * from course where year=? and semester=?";
		
		return jdbcTemplate.query(sqlStatement, new Object[] {year, semester},
				new RowMapper<Offer>() {

					@Override
					public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

						Offer offer = new Offer();
						offer.setCoursecode(rs.getString("coursecode"));
						offer.setCoursename(rs.getString("coursename"));
						offer.setDivision(rs.getString("division"));
						offer.setGrade(rs.getInt("grade"));
						offer.setSemester(rs.getInt("semester"));
						offer.setYear(rs.getInt("year"));
						
						
						return offer;
					}
			
		});
	}
	
	public List<Offer> getOffers() {
		String sqlStatement = "select * from course";
		
		return jdbcTemplate.query(sqlStatement,
				new RowMapper<Offer>() {

					@Override
					public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

						Offer offer = new Offer();
						offer.setCoursecode(rs.getString("coursecode"));
						offer.setCoursename(rs.getString("coursename"));
						offer.setDivision(rs.getString("division"));
						offer.setGrade(rs.getInt("grade"));
						offer.setSemester(rs.getInt("semester"));
						offer.setYear(rs.getInt("year"));
						
						
						return offer;
					}
			
		});
	}
	
	public boolean insert(Offer offer) {
		
		int year = offer.getYear();
		int semester = offer.getSemester();
		String coursecode = offer.getCoursecode();
		String coursename = offer.getCoursename();
		String division = offer.getDivision();
		int grade = offer.getGrade();
		
		String sqlStatement = "insert into course (year, semester, coursecode, coursename, division, grade) values (?, ?, ?, ?, ?, ?)";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, coursecode, coursename, division, grade}) == 1);
	}	
	
}
