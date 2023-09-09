//package com.example.building.Configuration;
//
//import com.example.building.Entity.ClientOfBuilding;
//import com.example.building.Repository.UserRepo;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//
//@Service
//@RequiredArgsConstructor
//public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
//
//    private final UserRepo userRepository;
//
//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//        OAuth2User oauth2User = new DefaultOAuth2UserService().loadUser(userRequest);
//        System.out.println("ok");
//        String email = oauth2User.getAttribute("email");
//        String name = oauth2User.getAttribute("name");
//        // ... other attributes
//
//        // Check if the user exists in the database
//        //if (!userRepository.existsByEmail(email)) {
//            // User is not registered, create a new user record
//            ClientOfBuilding newUser = new ClientOfBuilding();
//            newUser.setEmail(email);
//            newUser.setFirstname(name);
//            // ... set other attributes
//            userRepository.save(newUser);
//       // }
//
//        return oauth2User;
//    }
//}
//
