package com.etiya.library.system.services.dtos.requests.author;

import com.etiya.library.system.services.constants.Messages;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AddAuthorRequest {
    @NotNull
    @NotBlank(message = Messages.AuthorMessages.NAME_CANNOT_BE_EMPTY)
    @Size(min=2,max=15, message=Messages.AuthorMessages.NAME_LENGTH_VALIDATION)
    private String name;
    @NotNull
    @NotBlank
    @Size(min=2)
    private String surname;
    @NotNull
    @NotBlank
    @Size(min = 11, max = 11)
    private String nationalityId;
}
