package com.example.spring_data.service;

import com.example.spring_data.Dao.AuthorDao;
import com.example.spring_data.Dao.BookDao;
import com.example.spring_data.Dao.PublisherDao;
import com.example.spring_data.Dto.BookDto;
import com.example.spring_data.Dto.ResponseDto;
import com.example.spring_data.Repository.AuthorRepository;
import com.example.spring_data.Repository.BookRepository;
import com.example.spring_data.Repository.PublisherRepository;
import com.example.spring_data.mapping.AuthorMapping;
import com.example.spring_data.mapping.BookMapping;
import com.example.spring_data.mapping.PublisherMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

//    public ResponseDto<List<BookDto>> getAllBooks(Integer size, Integer page) {
//        PageRequest pageRequest = PageRequest.of(page,size);
//        Page<BookDao> bookDaos = bookRepository.findAll(pageRequest);
    public ResponseDto<List<BookDto>> getAllBooks(){
        List<BookDao> bookDaos = bookRepository.findAll();
        if (!bookDaos.isEmpty()) {
            List<BookDto> list = new ArrayList<>();
            for (BookDao bookDao : bookDaos) {
                Optional<AuthorDao> authorDaos = authorRepository.findById(bookDao.getAuthor_id());
                Optional<PublisherDao> publisherDtos = publisherRepository.findById(bookDao.getPublisher_id());
                list.add(BookMapping.toDto(bookDao, AuthorMapping.toDto(authorDaos.get()), PublisherMapping.toDto(publisherDtos.get())));

            }
//            Page<BookDto> reult = new PageImpl<>(list,bookDaos.getPageable(),bookDaos.getTotalElements());
            return new ResponseDto<>(true, 0, "ok", list);

        }
        return new ResponseDto<>(false, -1, "xatolik", null);
    }

    public ResponseDto<BookDto> getById(Integer id) {
        if (id != null) {
            Optional<BookDao> bookDao = bookRepository.findById(id);
            AuthorDao authorDao = authorRepository.getById(bookDao.get().getId());
            PublisherDao publisherDao = publisherRepository.getById(bookDao.get().getPublisher_id());
            if(!bookDao.isEmpty()){
                return new ResponseDto<>(false,-1,"id topilmadi",null);
            }
            BookDto bookDto = BookMapping.toDto(bookDao.get(), AuthorMapping.toDto(authorDao), PublisherMapping.toDto(publisherDao));
            return new ResponseDto<>(true, 0, "ok", bookDto);
        }
        return new ResponseDto<>(false, -1, "Id null xolatida", null);
    }

    public ResponseDto<BookDto> deledeId(Integer id) {
        Optional<BookDao> bookDao = bookRepository.findById(id);
        AuthorDao authorDao = authorRepository.getById(id);
        PublisherDao publisherDao = publisherRepository.getById(id);
        if (!bookDao.isEmpty()) {
            bookRepository.delete(bookDao.get());
            return new ResponseDto<>(true, 0, "Malimot ochirildi", BookMapping.toDto(bookDao.get(), AuthorMapping.toDto(authorDao), PublisherMapping.toDto(publisherDao)));
        }
        return new ResponseDto<>(false, -1, "Bunday id mahsulot mavjud emas", null);
    }

    public ResponseDto<BookDto>insert(BookDto bookDto) {
        if(bookDto != null) {
            BookDao bookDao = BookMapping.toDao(bookDto);
            bookRepository.save(bookDao);
            return new ResponseDto<>(true,0,"Malumot Bazaga saqlandi",bookDto);
        }
        return new ResponseDto<>(false,-1,"Xatolik",null);
    }

    public ResponseDto<BookDto> insertAll(BookDto bookDto) {
        if(bookDto != null){
            BookDao bookDao = BookMapping.toDao(bookDto);
            AuthorDao authorDao = AuthorMapping.toDao(bookDto.getAuthorDto());
            PublisherDao publisherDao = PublisherMapping.toDao(bookDto.getPublisherDto());
            bookRepository.save(bookDao);
            authorRepository.save(authorDao);
            publisherRepository.save(publisherDao);
            return new ResponseDto<>(true,0,"insert All",bookDto);
        }
        return new ResponseDto<>(false,-1,"xatolik",null);
    }

    public ResponseDto<BookDto> update(BookDto bookDto) {
        if(bookDto.getId() == null)
            return new ResponseDto<>(false,-1,"Id null",bookDto);
          BookDao bookDao = bookRepository.getById(bookDto.getId());
          if(bookDao != null){
              bookRepository.save(BookMapping.toDao(bookDto));
              return new ResponseDto<>(true,0,"update",bookDto);
          }
          return new ResponseDto<>(false,-1,"Xatolik",bookDto);
    }
}
