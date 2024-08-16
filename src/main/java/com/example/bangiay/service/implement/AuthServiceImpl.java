package com.example.bangiay.service.implement;

import com.example.bangiay.dto.request.LoginRequest;
import com.example.bangiay.dto.request.SignupRequest;
import com.example.bangiay.dto.respone.JwtResponse;
import com.example.bangiay.dto.respone.MessageRespone;
import com.example.bangiay.entity.KhachHang;
import com.example.bangiay.entity.NhanVien;
import com.example.bangiay.jwt.JwtTokenProvider;
import com.example.bangiay.repository.ChucVuRepository;
import com.example.bangiay.repository.KhachHangRepository;
import com.example.bangiay.repository.NhanVienRepository;
import com.example.bangiay.securirty.CustomUserDetails;
import com.example.bangiay.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private ChucVuRepository chucVuRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<?> login(LoginRequest loginRequest) {
        try {
            // Kiểm tra xem email có tồn tại ko
            if (!nhanVienRepository.existsByEmail(loginRequest.getEmail())
                    && !khachHangRepository.existsByEmail(loginRequest.getEmail())) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new MessageRespone("Tài khoản không tồn tại. Vui lòng đăng ký."));
            }

            //authenticationManager.authenticate mã hóa mật khẩu mới đăng nhập đc
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getMatKhau())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtTokenProvider.genToken(authentication);
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            List<String> roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(new JwtResponse(
                    jwt,
                    "Bearer",
                    userDetails.getUsername(),
                    userDetails.getHoTen(),
                    userDetails.getEmail(),
                    roles
            ));
        } catch (BadCredentialsException e) {
            // Xử lý trường hợp mật khẩu không đúng
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new MessageRespone("Email hoặc mật khẩu không chính xác."));
        } catch (Exception e) {
            // Xử lý các lỗi khác
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageRespone("Đã xảy ra lỗi khi đăng nhập. Vui lòng thử lại sau."));
        }
    }

    @Override
    public ResponseEntity<?> registerNhanVien(SignupRequest signupRequest) {
        if(nhanVienRepository.existsByEmail(signupRequest.getEmail())){
            return ResponseEntity.badRequest().body(new MessageRespone("Lỗi email đã được sử dụng !"));
        }
        NhanVien nhanVien= new NhanVien();
        nhanVien.setEmail(signupRequest.getEmail());
        nhanVien.setMatKhau(passwordEncoder.encode(signupRequest.getMatKhau())); // mã hóa mật khẩu
        nhanVien.setHoTen(signupRequest.getHoTen());
        nhanVien.setSoDienThoai(signupRequest.getSoDienThoai());

        nhanVienRepository.save(nhanVien);
        return ResponseEntity.ok(new MessageRespone("Tạo tài khoản nhân viên thành công"));
    }

    @Override
    public ResponseEntity<?> registerKhachHang(SignupRequest signupRequest) {
        if(khachHangRepository.existsByEmail(signupRequest.getEmail())){
            return ResponseEntity.badRequest().body(new MessageRespone("Lỗi email đã được sử dụng !"));
        }
        KhachHang khachHang=new KhachHang();
        khachHang.setMa(generateUniqueMa());
        khachHang.setEmail(signupRequest.getEmail());
        khachHang.setMatKhau(passwordEncoder.encode(signupRequest.getMatKhau())); // mã hóa mật khẩu
        khachHang.setHoTen(signupRequest.getHoTen());
        khachHang.setSoDienThoai(signupRequest.getSoDienThoai());
        khachHangRepository.save(khachHang);
        return ResponseEntity.ok(new MessageRespone("Tạo tài khoản khách hàng thành công "));
    }
    private String generateUniqueMa(){
        return "KH" + System.currentTimeMillis();
    }
}
