package com.api.rest_templase_api_consumer.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * El paquete DTO significa: Data Transfer Object. Solo es un objeto que
 * mueve datos
 * Con esto, no requerimos persistir datos
 */
@Data
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    /**
     * Son los datos que vienen desde la api
     */
    private long id;
    private String name;
    private String username;
    private String email;

}
