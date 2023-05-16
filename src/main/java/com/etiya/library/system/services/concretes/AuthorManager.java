package com.etiya.library.system.services.concretes;

import com.etiya.library.system.core.exceptions.types.BusinessException;
import com.etiya.library.system.core.internationalization.MessageService;
import com.etiya.library.system.core.result.Result;
import com.etiya.library.system.core.result.SuccessResult;
import com.etiya.library.system.entities.concretes.Author;
import com.etiya.library.system.repositories.abstracts.AuthorRepository;
import com.etiya.library.system.services.abstracts.AuthorService;
import com.etiya.library.system.services.constants.Messages;
import com.etiya.library.system.services.dtos.requests.author.AddAuthorRequest;
import com.etiya.library.system.services.dtos.requests.author.UpdateAuthorRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorManager implements AuthorService {
    private AuthorRepository authorRepository;
    private MessageService messageService;

    @Override
    public Result add(AddAuthorRequest addAuthorRequest) {
        authorWithSameNationalityIdShouldNotExists(addAuthorRequest.getNationalityId());
        //TODO: ModelMapper
        Author author = new Author();
        author.setName(addAuthorRequest.getName());
        author.setSurname(addAuthorRequest.getSurname());
        author.setNationalityId(addAuthorRequest.getNationalityId());
        authorRepository.save(author);
        return new SuccessResult(messageService.getMessage(Messages.AuthorMessages.AUTHOR_ADDED_SUCCESSFULLY));
    }

    @Override
    public void update(UpdateAuthorRequest updateAuthorRequest) {
        Author authorToUpdate = authorRepository.findById(updateAuthorRequest.getId()).orElse(null);
        authorToUpdate.setName(updateAuthorRequest.getName());
        authorToUpdate.setSurname(updateAuthorRequest.getSurname());
        authorToUpdate.setNationalityId(updateAuthorRequest.getNationalityId());
        authorRepository.save(authorToUpdate);
    }

    private void authorWithSameNationalityIdShouldNotExists(String nationalityId)
    {
        Author author = authorRepository.findByNationalityId(nationalityId);
        if(author!=null)
            throw new BusinessException(messageService.getMessageWithParams(Messages.AuthorMessages.NATIONALITY_ID_EXISTS, nationalityId));
    }
}
