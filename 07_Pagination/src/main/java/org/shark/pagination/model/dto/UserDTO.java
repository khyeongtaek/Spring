package org.shark.pagination.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserDTO {
    private Integer uid;
    private String email;
    private String filePath;
    private String originalFilename;
    private String filesystemName;
}
