package org.shark.pagination.service;

import org.shark.pagination.model.dto.PageDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface UserService {

    Map<String, Object> getUsers(PageDTO pageDTO, HttpServletRequest request);
}
