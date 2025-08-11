package org.shark.hierarchy.service;

import org.shark.hierarchy.model.dto.BbsDTO;
import org.shark.hierarchy.model.dto.PageDTO;

import java.util.Map;

public interface BbsService {
    boolean addBbs(BbsDTO bbsDTO);
    boolean addReply(BbsDTO bbsDTO);
    boolean removeBbs(Integer bbsId);
    Map<String, Object> getBbsList(PageDTO pageDTO);

}
