package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.CommentResult;
@Repository
public class CommentResultDao {
	@Autowired
    private   JdbcTemplate jdbcTemplate;
	@Value("${dao.sqltext}")
	private String sqltext;
	 public    List<CommentResult> CommentResult(String name){
		 
	       
		    return (List<CommentResult>) jdbcTemplate.query(sqltext, new Object[]{name},new RowMapper<CommentResult>(){

	            @Override
	            public CommentResult mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	CommentResult result = new CommentResult();
	            	result.setMonth(rs.getString("month_ID"));
	            	result.setName(rs.getString("P_NAME"));
	            	result.setUnit(rs.getString("unit"));
	            	result.setPoint(rs.getString("C_point"));
	            	result.setRankInCenter(rs.getString("rankInCenter"));
	            	result.setRankInUnit(rs.getString("rankInUnit"));
	            	result.setGrade(rs.getString("grade"));
	            	result.setRewardValue(rs.getString("rewardValue"));
	            	result.setRewardMatter(rs.getString("rewardMatter"));
	                return result;
	            }

				

	        });
	    }
}
