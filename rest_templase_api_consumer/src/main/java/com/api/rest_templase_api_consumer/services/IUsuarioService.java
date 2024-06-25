package com.api.rest_templase_api_consumer.services;

import com.api.rest_templase_api_consumer.dto.UserDTO;

import java.util.List;

public interface IUsuarioService {
    /**
     * Obtiene los usuarios
     * @return
     */
    public List<UserDTO> getUsers();

    /**
     * Guarda usuarios
     * @param user
     */
    public void saveUsers(UserDTO user);

    /**
     * Actualiza usuarios desde el id
     * @param id
     * @param user
     */
    public void updateUsers(Integer id, UserDTO user);

    /**
     * Borra usuarios desde id
     * @param id
     */
    public void deleteUsers(Integer id);
}
