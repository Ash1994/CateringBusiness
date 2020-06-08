package com.catering.in.CateringBusinessLogin.user;

import com.catering.in.CateringBusinessLogin.MongoDbDao;
import com.catering.in.CateringBusinessLogin.exceptionhandling.exceptions.ResourceNotFoundException;
import com.catering.in.CateringBusinessLogin.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class UserServiceDao implements IUserServiceDao {

//    private static String GET_USER_SQL = "SELECT * FROM TBL_EMPLOYEES WHERE ID = ?";
//    private static String GET_ALL_USER_SQL = "SELECT * FROM TBL_EMPLOYEES";
//
//    private JdbcTemplate gatewayTemplate;

//    @Autowired
//    private MongoTemplate gatewayTemplate;

    @Autowired
    MongoDbDao gatewayTemplate;

//    @Autowired
//    @Qualifier("gatewayDS")
//    private NamedParameterJdbcTemplate gatewayTemplate;

//    @Autowired
//    @Qualifier("h2DataSource")
//    public void setPdfLibDataSource(final DataSource dataSource) {
//        gatewayTemplate = new JdbcTemplate(dataSource);
//    }

    @Override
    public User getUserById(int id) {
        try {
//            Query query = new Query();
//            query.addCriteria(Criteria.where("id").is(id));
            return gatewayTemplate.findById(id).get();
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("User Data ", "id - " + id);
        }
    }

    @Override
    public List<User> getAllUser() {
        try {
            return gatewayTemplate.findAll();
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("User Data ");
        }
    }

    @Override
    public void saveAll(User user) {
        gatewayTemplate.save(user);
    }
}

