package org.shark.pagination.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class PageDTO {
    private int page = 1;
    private int size = 20;
    private int offset;

    private int itemCount;
    private int pageCount;
    private int beginPage;
    private int endPage;

    public PageDTO() {}

    public PageDTO(int size, int page, int itemCount) {
        this.size = size;
        this.page = page;
        this.itemCount = itemCount;
    }
}
