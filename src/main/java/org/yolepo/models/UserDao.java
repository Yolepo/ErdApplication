package org.yolepo.models;

import org.springframework.data.repository.Repository;

import javax.transaction.Transactional;

/**
 * Created by mjali on 04/11/2016.
 */
@Transactional
public interface UserDao extends Repository<User, Long> {

    User findByLastName(String lastName);

}
