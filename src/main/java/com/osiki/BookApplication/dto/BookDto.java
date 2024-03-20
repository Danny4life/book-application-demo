package com.osiki.BookApplication.dto;

import com.osiki.BookApplication.enums.BookStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    @NotBlank(message = "title must not be blank")
    private String title;
    @NotBlank(message = "author must not be blank")
    private String author;
    @NotBlank(message = "pages must not be blank")
    private int pages;
    private BookStatus bookStatus;


}