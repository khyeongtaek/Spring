package org.shark.file.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class NoticeDTO {
    private Integer nid;
    private String title;
    private String content;
}
