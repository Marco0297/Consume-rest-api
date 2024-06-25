package com.api.rest_templase_api_consumer.controller;

import com.api.rest_templase_api_consumer.dto.UserDTO;
import com.api.rest_templase_api_consumer.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    /**
     * Inyeccion de IUsuarioService
     */
    @Autowired
    private IUsuarioService service;

    /**
     * Muestra todos los usuarios de la API
     * @return
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> getAll(){
        return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
    }

    /**
     * Guarda un nuevo usuario
     * No se ocupa Response puesto que se ocupara una respuestta Http
     * @param user
     */
    @PostMapping("/saveUser")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody UserDTO user){
        service.saveUsers(user);
    }

    /**
     * Actualiza un usuario
     * No se ocupa Response puesto que se ocupara una respuestta Http
     * @param user
     */
    @PutMapping("/updateUser/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUserById(@PathVariable("id") Integer id, @RequestBody UserDTO user){
        service.updateUsers(id, user);
    }

    /**
     * Elimina user by id
     * @param id
     */
    @DeleteMapping("/deleteById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deteleUserById(@PathVariable("id") Integer id){
     service.deleteUsers(id);
    }
}
