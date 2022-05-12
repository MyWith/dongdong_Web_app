package com.example.dongdong_web_app.application.auth.service;

import com.example.dongdong_web_app.application.auth.dto.SignInDto;
import com.example.dongdong_web_app.application.auth.dto.SignUpDto;
import com.example.dongdong_web_app.application.auth.dto.TokenDto;
import com.example.dongdong_web_app.application.auth.repository.AuthRepository;
import com.example.dongdong_web_app.application.auth.entity.AuthEntity;

import com.example.dongdong_web_app.application.auth.service.interfaces.AuthService;
import com.example.dongdong_web_app.application.auth.service.interfaces.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwt;


    @Override
    public SignInDto.Response getUserData(String user_email, String user_password) {
        String getPassword = authRepository.findByUserEmail(user_email).getUserPassword();

        if(passwordEncoder.matches(user_password, getPassword)){
            AuthEntity UserData = authRepository.findByUserEmail(user_email);
            SignInDto.Info info = new SignInDto.Info(UserData.getUserUid(), UserData.getUserNickName(), UserData.getUserAge());
            SignInDto.Animal animal = new SignInDto.Animal(UserData.getAnimalName(), UserData.getAnimalKind());
            SignInDto.Location location = new SignInDto.Location(UserData.getStreetSIDO(), UserData.getStreetSIGUNGU(), UserData.getStreetEUPMYENDONG());

            TokenDto token = jwt.createToken( UserData.getUserUid(), info );

            SignInDto.Response response = SignInDto.Response.builder()
                    .userEmail(UserData.getUserEmail())
                    .info(info)
                    .token(token)
                    .animal(animal)
                    .location(location)
                    .build();

            return response;
        }else{
            return null;
        }
    }

    @Override
    public ResponseEntity saveUserData(SignUpDto.Request request) {
        String planText = request.getUserPassword();
        String encodePassword = passwordEncoder.encode(planText);
        AuthEntity auth;
        try{
            auth = AuthEntity.builder()
                    .userEmail(request.getUserEmail())
                    .userPassword(encodePassword)
                    .userNickName(request.getInfo().getUserNickName())
                    .userAge(request.getInfo().getUserAge())
                    .animalKind(request.getAnimal().getAnimalKind())
                    .animalName(request.getAnimal().getAnimalName())
                    .animalAge(request.getAnimal().getAnimalAge())
                    .streetEUPMYENDONG(request.getLocation().getStreetEUPMYENDONG())
                    .streetSIDO(request.getLocation().getStreetSIDO())
                    .streetSIGUNGU(request.getLocation().getStreetSIGUNGU())
                    .build();

            authRepository.save(auth);

            return new ResponseEntity(null,null,200);
        }catch (Exception e){
            return new ResponseEntity(null,null,400);
        }
    }

    public SignInDto.Response autoLogin(TokenDto tokenDto){



        return null;
    }

}