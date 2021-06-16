package com.example.demoShoeShop.services;

import com.example.demoShoeShop.Utils.JwtUtils;
import com.example.demoShoeShop.Utils.Md5;
import com.example.demoShoeShop.entities.User;
import com.example.demoShoeShop.exceptions.ObjNotFoundException;
import com.example.demoShoeShop.exceptions.UserNotLoggedException;
import com.example.demoShoeShop.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    UserRepo userRepo;

    @Override
    public User findUserAndVerifyPassword(String username, String password) throws ObjNotFoundException, UserNotLoggedException {
        Optional<User> userOpt = userRepo.findByUsername(username);
        if(userOpt.isPresent()){
            User u = userOpt.get();
            password = Md5.encrypt(password);
            if(password.equals(u.getPassword())){
                return u;
            }else{
                throw new UserNotLoggedException("wrong password");
            }
        }else{
            throw new ObjNotFoundException("user: " + username + " isn't present into DB");
        }
    }

    @Override
    public String createJwt(String subject, String name, String permission, Date datenow) throws UnsupportedEncodingException {
        Date expDate = datenow;
        expDate.setTime(datenow.getTime() + (300*1000));
        String token = JwtUtils.generateJwt(subject, expDate, name, permission);
        return token;
    }

    @Override
    public Map<String, Object> verifyJwtAndGetData(HttpServletRequest request) throws UserNotLoggedException, UnsupportedEncodingException{
        String jwt = JwtUtils.getJwtFromHttpRequest(request);
        if(jwt == null){
            throw new UserNotLoggedException("Authentication token not found in the request");
        }
        Map<String, Object> userData = JwtUtils.jwt2Map(jwt);
        return userData;
    }
}
