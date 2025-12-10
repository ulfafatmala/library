package com.school.library.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRq {
    @NotNull
    @Size(max = 100)
    private String name;

    @Size(max = 100)
    private String author;

    @Size(max = 100)
    private String publisher;

    private int numberOfPage;
}
