package org.shark.pagination.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserDTO {
    private Integer uid;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String ipAddress;
}
