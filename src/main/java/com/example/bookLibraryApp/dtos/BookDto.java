package com.example.bookLibraryApp.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private int yearPublished;
}
