package com.persistence.examples.service;

import com.persistence.examples.entity.User;
import com.persistence.examples.util.SearchCriteria;

import java.util.List;

public interface UserService {
    List<User> searchUser(List<SearchCriteria> params);

    void save(User entity);
}
