package com.example.bangiay.jwt;

import com.example.bangiay.securirty.CustomUserDetails;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {
    private JwtAuthFilter jwtConfig;

    // chứa secret key và time hết hạn
    @Value("${jwt.secret}")
    private String JWT_SECRET;

    @Value("${jwt.expiration}")
    private int JWT_EXPIRATION;

    //tạo jwt token từ thông tin xác thực
    public String genToken(Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("customerId",userDetails.getId())
                .claim("email", userDetails.getUsername())
                .claim("roles", userDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }
    // trích xuất username từ jwt
    public String getUserNameFromJWT(String token) {
        Claims claims = Jwts.parser().setSigningKey(JWT_SECRET)
                .parseClaimsJws(token).getBody(); // dùng parser để phân tích
        return claims.getSubject(); // -> trả về subject username từ claim
    }
    // trích xuất customerId từ jwt
    public String getCustomerIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody(); // Dùng parser để phân tích
        return claims.get("customerId", String.class); // Trả về ID khách hàng từ claim
    }

    public List<String> getRolesFromJWT(String token) {
        Claims claims = Jwts.parser().setSigningKey(JWT_SECRET)
                .parseClaimsJws(token).getBody();
        return claims.get("roles", List.class);
    }
    // kiểm tra tính hợp lệ của jwt
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET)
                    .parseClaimsJws(authToken);
            return true;
        } catch (SignatureException | MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
            return false;
        }
    }
}
