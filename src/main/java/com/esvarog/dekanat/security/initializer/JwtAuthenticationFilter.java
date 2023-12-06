package com.esvarog.dekanat.security.initializer;

import com.esvarog.dekanat.dto.MyUserPrincipal;
import com.esvarog.dekanat.entity.Users;
import com.esvarog.dekanat.security.JwtProvider;
import com.esvarog.dekanat.service.JwtService;
import com.esvarog.dekanat.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {


    private final JwtService jwtService;
    private final UserService userService;
    private final JwtProvider jwtProvider;

    public JwtAuthenticationFilter(JwtService jwtService, JwtProvider jwtProvider, UserService userService) {
        this.jwtService = jwtService;
        this.jwtProvider = jwtProvider;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Отримайте токен з заголовка запиту
        String token = jwtService.extractToken(request);

        if (token != null && jwtService.validateToken(this.userService.loadByToken(token).getTokenExpire())) {
            // Отримайте інформацію про користувача з токена
            System.out.println("Token отримано");
            String username = this.userService.loadByToken(token).getUsername();

            // Отримайте користувача з бази даних
            Users user = new Users();
            UserDetails userDetails = userService.loadUserByUsername(username);
            user.setId(this.userService.findByUsername(userDetails.getUsername()).getId());
            user.setEnabled(userDetails.isEnabled());
            user.setPassword(userDetails.getPassword());
            user.setRole(userDetails.getAuthorities().toArray()[0].toString());
            user.setUsername(userDetails.getUsername());
            user.setTokenExpire(this.userService.loadByToken(token).getTokenExpire());

            if (user.getTokenExpire()!=null) {
                // Перевірте, чи користувач має право виконувати запит
                // Наприклад, перевірте ролі або інші атрибути

                // Створіть аутентифікацію Spring Security

                Authentication authentication = new PreAuthenticatedAuthenticationToken(
                        MyUserPrincipal.create(user),
                        new MyUserPrincipal(user), null
                );


                // Встановіть аутентифікацію в контекст безпеки
                authentication.setAuthenticated(true);
                System.out.println("Автентифіковно");
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }

}

