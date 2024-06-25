package com.api.rest_templase_api_consumer.services;

import com.api.rest_templase_api_consumer.dto.UserDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService{

    /**
     * Valor leido desde archivo properties donde se guarda la api a cosumir
     */
    @Value("${spring.consume.api.url}")
    private String basePath;

    /**
     * Para empezar a consumir nuestra API ocupamos Rest Template que es propia de
     * Spring Boot.
     * Previamente debemos definirlo de lo contrario marcara error
     */
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<UserDTO> getUsers() {
        /**
         * Se puede pegar la API directamente
         * Pero para hacerlo con buenas practicas se usara en el properties o yml
         */
        //UserDTO[] response = restTemplate.getForObject("https://667b1522bd627f0dcc91a2e4.mockapi.io/api/v1/users", UserDTO[].class);
        UserDTO[] response = restTemplate.getForObject(basePath+"users", UserDTO[].class);
        return Arrays.asList(response);
    }

    @Override
    public void saveUsers(UserDTO user) {
        restTemplate.postForObject(basePath+"users", user, UserDTO.class);
    }

    @Override
    public void updateUsers(Integer id, UserDTO user) {
        restTemplate.put(basePath+"users/"+id, user, UserDTO.class);
    }

    @Override
    public void deleteUsers(Integer id) {
        restTemplate.delete(basePath+"users/"+ id);
    }
}
