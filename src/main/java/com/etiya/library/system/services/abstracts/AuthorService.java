package com.etiya.library.system.services.abstracts;

import com.etiya.library.system.core.result.Result;
import com.etiya.library.system.entities.concretes.Author;
import com.etiya.library.system.services.dtos.requests.author.AddAuthorRequest;
import com.etiya.library.system.services.dtos.requests.author.UpdateAuthorRequest;

public interface AuthorService {
    /**
     * Operation to add author to database.
     * @param addAuthorRequest Includes information of author which needs to be added.
     */
    Result add(AddAuthorRequest addAuthorRequest);

    /**
     * Operation to update existing author in database
     * @param updateAuthorRequest Includes information of author which needs to be updated.
     */
    void update(UpdateAuthorRequest updateAuthorRequest);
}