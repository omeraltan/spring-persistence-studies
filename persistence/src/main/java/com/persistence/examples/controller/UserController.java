package com.persistence.examples.controller;

import com.persistence.examples.entity.User;
import com.persistence.examples.service.UserService;
import com.persistence.examples.util.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    @ResponseBody
    public List<User> findAll(@RequestParam(value = "search", required = false) String search){
        List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        if (search != null){
            Pattern pattern = Pattern.compile("('\'w+?)(:|<|>)('\'w+?)");
            Matcher matcher = pattern.matcher(search + ",");
            while (matcher.find()){
                params.add(new SearchCriteria(matcher.group(1), matcher.group(2),matcher.group(3)));
            }
        }
        return service.searchUser(params);
    }

}
