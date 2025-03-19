package edu.du.login3.repository;

import edu.du.login3.model.MemberEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<MemberEntity> findAll() {return jdbcTemplate.query("SELECT * FROM member", new  UserRowMapper());}

    public MemberEntity findById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM member WHERE id = ?",
                new UserRowMapper(),
                id
        );
    }
    public void save(MemberEntity member) {
        if (member.getName() == null){
            jdbcTemplate.update(
                    "INSERT INTO member (id, name, password, email) VALUES (?, ?, ?, ?)",
                    member.getName(), member.getPassword(), member.getEmail()
            );
        } else {
            jdbcTemplate.update(
                    "UPDATE member SET name =?, email =?, password=? WHERE id =?",
                    member.getName(), member.getPassword(), member.getEmail()
            );
        }
    }

    public void deleteById(Long id) { jdbcTemplate.update("DELETE FROM member WHERE id = ?", id);}
    private static class UserRowMapper implements RowMapper<MemberEntity> {
        @Override
        public MemberEntity mapRow(ResultSet rs, int rowNum) throws SQLException{
            return new MemberEntity(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("email")
            );
        }
    }
}
