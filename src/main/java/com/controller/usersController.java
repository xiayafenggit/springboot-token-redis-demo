package com.controller;

import com.bean.Users;
import  com.util.getTokenUtils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class usersController {
    Jedis jedis=new Jedis("127.0.0.1",6379);
        @RequestMapping(value = "check_users.do")
    public String check(HttpServletRequest request, HttpServletResponse response,Users users){
        System.out.println(users.toString());
        users=users==null?new Users(1,"admin","123456"):users;
        try {
            //得到token令牌
            String token=getTokenUtils.gettoken(users);
            System.out.println("生成的token令牌："+token);
            //将token令牌存到Cookie对象
            Cookie cookie=new Cookie("token","token");
            //将Cookie对象发送到浏览器
            response.addCookie(cookie);
            //将生成的token存储到redis中，有效时长60秒
            jedis.setex("token",60,token);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
@RequestMapping(value = "Users_login.do")
    public String login(String token){
    System.out.println("登录时cookie中拿到的token:"+token);
    String tk=jedis.get("token");
    System.out.println("登录时从redis取出的token :"+tk);
            if(token.equals(tk)){
                //System.out.println("登录成功");
                return "登录成功";
            }
    //System.out.println("token过期失效，登录失败");
        return "token过期失效，登录失败";
    }
}
