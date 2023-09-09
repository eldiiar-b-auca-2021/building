//package com.example.building.Configuration;
//
//import com.example.building.Entity.ClientOfBuilding;
//import com.example.building.Repository.UserRepo;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.ApplicationListener;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
//import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
//import org.springframework.security.oauth2.client.authentication.OAuth2LoginAuthenticationToken;
//import org.springframework.security.oauth2.core.OAuth2AccessToken;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class AuthenticationListener implements ApplicationListener<AuthenticationSuccessEvent> {
//    private final UserRepo userRepo;
//    @Override
//    public void onApplicationEvent(AuthenticationSuccessEvent event) {
//        System.out.println("ok");
//        if (event.getSource() instanceof OAuth2LoginAuthenticationToken) {
//            // User authenticated with OAuth2 (Google or other provider)
//            OAuth2LoginAuthenticationToken oauth2Token = (OAuth2LoginAuthenticationToken) event.getSource();
//            System.out.println("User authenticated with OAuth2 provider: " + oauth2Token.getPrincipal().getAttribute("email"));
//            ClientOfBuilding clientOfBuilding = new ClientOfBuilding();
//            System.out.println(oauth2Token.getPrincipal());
//            clientOfBuilding.setEmail(oauth2Token.getPrincipal().getAttribute("email"));
//
//
//        } else if (event.getSource() instanceof UsernamePasswordAuthenticationToken) {
//            // User authenticated with local username and password
//            UsernamePasswordAuthenticationToken localToken = (UsernamePasswordAuthenticationToken) event.getSource();
//            System.out.println("User authenticated with local username and password: " + localToken.getName());
//        }
//    }
//}
