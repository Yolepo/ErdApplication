package org.yolepo.models;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by mjali on 04/11/2016.
 */
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserDao extends PagingAndSortingRepository<User, Long> {

    User findByLastName(@Param("lastName") String lastName);

    User findById(Long id);



}
