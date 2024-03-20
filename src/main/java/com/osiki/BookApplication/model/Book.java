package com.osiki.BookApplication.model;

import com.osiki.BookApplication.enums.BookStatus;
import com.osiki.BookApplication.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book_tbl")
@Builder
public class Book extends BaseClass{

    private String title;


    private String author;


    private int pages;


    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
