package org.shark.pagination.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AttachDTO {
    private Integer aid;
    private Integer nid;
    private String filePath;
    private String originalFilename;
    private String filesystemName;
}
