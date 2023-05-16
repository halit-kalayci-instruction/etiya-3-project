package com.etiya.library.system.services.dtos.requests.author;

import lombok.Data;

@Data
public class UpdateAuthorRequest {
    private int id;
    private String name;
    private String surname;
    private String nationalityId;
}
