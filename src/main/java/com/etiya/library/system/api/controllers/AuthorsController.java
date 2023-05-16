package com.etiya.library.system.api.controllers;

import com.etiya.library.system.core.result.Result;
import com.etiya.library.system.entities.concretes.Author;
import com.etiya.library.system.services.abstracts.AuthorService;
import com.etiya.library.system.services.constants.Paths;
import com.etiya.library.system.services.dtos.requests.author.AddAuthorRequest;
import com.etiya.library.system.services.dtos.requests.author.UpdateAuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

// magic string
@RestController
@RequestMapping(Paths.API_PREFIX + Paths.AUTHORS)
public class AuthorsController {
    private AuthorService authorService;

    @Autowired
    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping()
    public Result add(@RequestBody @Valid AddAuthorRequest addAuthorRequest){
        return authorService.add(addAuthorRequest);
    }

    @PutMapping()
    public void update(@RequestBody UpdateAuthorRequest updateAuthorRequest){
        authorService.update(updateAuthorRequest);
    }
}
