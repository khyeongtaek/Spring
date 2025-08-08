package org.shark.hierarchy.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BbsDTO {
    private Integer bbsId;
    private String content;
    private Integer state;
    private Integer depth;
    private Integer groupId;
    private Integer groupOrder;


}
