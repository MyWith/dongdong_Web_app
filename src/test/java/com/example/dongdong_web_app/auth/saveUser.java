package com.example.dongdong_web_app.auth;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class saveUser {

    @Autowired
    private MockMvc mockMvc;


    static JSONObject createRequest(
            String userNickName,
            int userAge,
            String animalName,
            String animalKind,
            String userEmail,
            String userPassword) throws JSONException {

        JSONObject request = new JSONObject();
        JSONObject info = new JSONObject();
        JSONObject animal = new JSONObject();

        info.put("userNickName", userNickName)
                .put("userAge", userAge);

        animal.put("animalName", animalName)
                .put("animalKind", animalKind);

        request.put("info", info);
        request.put("animal", animal);
        request.put("userEmail", userEmail)
                .put("userPassword", userPassword);

        return request;
    }
}
