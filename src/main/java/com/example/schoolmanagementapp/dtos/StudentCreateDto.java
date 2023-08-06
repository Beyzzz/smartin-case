package com.example.schoolmanagementapp.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class StudentCreateDto {
    private String firstName;
    private String lastName;
    private String classroom;
    private Long schoolId;

}
