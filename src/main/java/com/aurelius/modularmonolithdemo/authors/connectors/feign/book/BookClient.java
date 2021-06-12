package com.aurelius.modularmonolithdemo.authors.connectors.feign.book;

import com.aurelius.modularmonolithdemo.books.dtos.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "book-service", url = "http://localhost:8080", configuration = BookFeignClientConfig.class)
public interface BookClient {
    @GetMapping("/books")
    List<BookDto> getBookList(@RequestParam("authorIdList") List<String> authorIdList);
}
