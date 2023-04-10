package com.example.online.shopping.controller;

import com.example.online.shopping.jwt.JwtUtils;
import com.example.online.shopping.model.ERole;
import com.example.online.shopping.model.Role;
import com.example.online.shopping.model.User;
import com.example.online.shopping.payload.LoginRequest;
import com.example.online.shopping.payload.SignupRequest;
import com.example.online.shopping.payload.response.MessageResponse;
import com.example.online.shopping.payload.response.UserInfoResponse;
import com.example.online.shopping.repository.RoleRepository;
import com.example.online.shopping.repository.UserRepository;
import com.example.online.shopping.security.userservices.UserDetailsImpl;
import com.example.online.shopping.service.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    AuthServiceImpl authServiceimpl;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {


//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        System.out.println("Security context holder executed");
//
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//
//        System.out.println("UserDetails = "+userDetails);
//
//        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
//
//        System.out.println("jwtCokie "+jwtCookie);
//
//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(item -> item.getAuthority())
//                .collect(Collectors.toList());

//        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
//                .body(new UserInfoResponse(userDetails.getId(),
//                        userDetails.getUsername(),
//                        userDetails.getEmail(),
//                        roles));

        return authServiceimpl.login(loginRequest);

    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
//        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: Username is already taken!"));
//        }
//
//        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Error: Email is already in use!"));
//        }
//
//        // Create new user's account
//        User user = new User(signUpRequest.getFirstName(),signUpRequest.getLastName(),
//                              signUpRequest.getEmail(),signUpRequest.getUsername(),signUpRequest.getPassword(),
//                signUpRequest.getConfirmPassword(),signUpRequest.getContactNumber());
//
//        Set<String> strRoles = signUpRequest.getRoles();
//        System.out.println(strRoles);
//        Set<Role> roles = new HashSet<>();
//
//        if (strRoles == null) {
//            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//            roles.add(userRole);
//        } else {
//            strRoles.forEach(role -> {
//                switch (role) {
//                    case "admin":
//                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(adminRole);
//
//                        break;
//                    case "mod":
//                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(modRole);
//
//                        break;
//                    default:
//                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(userRole);
//                }
//            });
//        }
//
//        user.setRoles(roles);
//        userRepository.save(user);
//
//        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//    }

        System.out.println("/Register invoked");
        return authServiceimpl.register(signUpRequest);}
}