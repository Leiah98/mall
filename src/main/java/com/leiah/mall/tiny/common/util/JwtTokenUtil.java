package com.leiah.mall.tiny.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Leiah
 * @Description: JwtToken的生成类
 *               JWT Token的格式 header.payload.signature
 * @Date: 2020/9/16 21:04
 */
@Component
public class JwtTokenUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    /**
    * @Description: 根据负载生成JWT的token
    * @Param: [claims]
    * @Return: java.lang.String
    * @Date: 2020/9/16 21:15
    **/
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
    * @Description: 从token中获取JWT的负载
    * @Param: [token]
    * @Return: io.jsonwebtoken.Claims 
    * @Date: 2020/9/16 21:16
    **/
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            LOGGER.info("JWT格式验证失败：{}", token);
        }
        return claims;
    }

    /**
    * @Description: 生成token的过期时间
    * @Param: []
    * @Return: java.util.Date
    * @Date: 2020/9/16 21:17
    **/
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
    * @Description: 从token中获取登录用户名
    * @Param: [token]
    * @Return: java.lang.String
    * @Date: 2020/9/16 21:19
    **/
    public String getUserNameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
    * @Description: 验证token是否有效
    * @Param: [token, userDetails]
    * @Return: boolean
    * @Date: 2020/9/16 21:26
    **/
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
    * @Description: 验证token是否过期
    * @Param: [token]
    * @Return: boolean
    * @Date: 2020/9/16 21:27
    **/
    private boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    /**
    * @Description: 从token获取过期时间
    * @Param: [token]
    * @Return: java.util.Date
    * @Date: 2020/9/16 21:29
    **/
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
    * @Description: 根据用户信息生成token
    * @Param: [userDetails]
    * @Return: java.lang.String
    * @Date: 2020/9/16 21:34
    **/
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
    * @Description: 判断token是否可以刷新
    * @Param: [token]
    * @Return: boolean 
    * @Date: 2020/9/16 21:36
    **/
    public boolean canRefresh(String token) {
        return !isTokenExpired(token);
    }

    /**
    * @Description: 刷新token
    * @Param: [token]
    * @Return: java.lang.String
    * @Date: 2020/9/16 21:36
    **/
    public String refreshToken(String token) {
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }
}
