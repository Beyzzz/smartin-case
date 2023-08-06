package com.example.schoolmanagementapp.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class StudentUpdateDto {
    private String firstName;
    private String lastName;
    private String classroom;
}
