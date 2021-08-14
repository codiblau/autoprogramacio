package com.codiblau.autoprogramacio.handler;

import com.codiblau.autoprogramacio.manager.TokenManager;
import com.codiblau.autoprogramacio.manager.TokenResponse;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenManager tokenManager;

    //@Autowired
    //private UsuariPianoManager usuariPianoManager;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        return true;
        /*
         * Detecta si la petición es un OPTIONS en tal caso devuelve true.
         * */
        //if (request.getMethod().equals("OPTIONS")) return true;

        /*
         * Si no es un OPTIONS comprueba si la petición contiene el Token
         * y comprueba si es válido o si ha expirado.
         * */
        /*String auth = request.getHeader("Authorization");

        if (auth != null && !auth.isEmpty()) {
            String token = auth.replace("Bearer ", "");
            TokenResponse validate = tokenManager.validateToken(token);

            if (validate.equals(TokenResponse.ERROR)) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No valid Token");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;

            } else if (validate.equals(TokenResponse.EXPIRED)) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Expired Token");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }

            Claims claims = tokenManager.getClaims(request);

            String email = (String) claims.get("email");
            UsuariPiano usuari = usuariPianoManager.findByEmail(email);

            if (usuari == null) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not valid");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }

            response.setStatus(HttpServletResponse.SC_OK);
            return true;

        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token not received");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }*/
    }
}
