package com.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bean.Users;
import com.sun.xml.internal.ws.spi.db.DatabindingException;

import java.util.Date;

public class getTokenUtils {
    public static String gettoken(Users users){
        Date start=new Date();//token令牌开始时间
        Long timelong=System.currentTimeMillis()+60*60*1000;//设置有效时长1h
        Date end=new Date(timelong);//结束时间
        //生成token令牌
        String token= JWT.create().withAudience(users.getUid().toString()).withIssuedAt(start).withExpiresAt(end).sign(Algorithm.HMAC256(users.getPasswd()));
        return token;
    }
}
