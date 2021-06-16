package com.example.demoShoeShop.services;

import com.example.demoShoeShop.entities.User;
import com.example.demoShoeShop.exceptions.ObjNotFoundException;
import com.example.demoShoeShop.exceptions.UserNotLoggedException;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

public interface LoginService {
    User findUserAndVerifyPassword(String username, String password) throws ObjNotFoundException, UserNotLoggedException;

    String createJwt(String subject, String name, String permission, Date date) throws UnsupportedEncodingException;

    Map<String, Object> verifyJwtAndGetData(HttpServletRequest request) throws UserNotLoggedException, UnsupportedEncodingException;
}
