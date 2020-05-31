package com.catering.in.CateringBusinessLogin.user;

import com.catering.in.CateringBusinessLogin.exceptionhandling.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class UserServiceDao implements IUserServiceDao {

    private static String GET_USER_SQL = "SELECT * FROM TBL_EMPLOYEES WHERE ID = :id";
    private static String GET_ALL_USER_SQL = "SELECT * FROM TBL_EMPLOYEES";

    @Autowired
    @Qualifier("gatewayDS")
    private NamedParameterJdbcTemplate gatewayTemplate;

    @Override
    public User getUserById(int id) {
        try {
            final SqlParameterSource namedParameters = new MapSqlParameterSource()
                    .addValue("id", id);
            return gatewayTemplate.queryForObject(GET_USER_SQL, namedParameters, new UserRowMapper());
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("User Data ", "id - " + id);
        }
    }

    @Override
    public List<User> getAllUser() {
        try {
            return gatewayTemplate.query(GET_ALL_USER_SQL, new UserRowMapper());
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("User Data ");
        }
    }

}

