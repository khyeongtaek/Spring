package org.shark.pagination.service;

import lombok.RequiredArgsConstructor;
import org.shark.pagination.model.dto.PageDTO;
import org.shark.pagination.model.dto.UserDTO;
import org.shark.pagination.repository.UserDAO;
import org.shark.pagination.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final PageUtil pageUtil;
    private final UserDAO userDAO;

    @Override
    public Map<String, Object> getUsers(PageDTO pageDTO, HttpServletRequest request) {
        String sort = request.getParameter("sort");
        if (!("DESC".equalsIgnoreCase(sort) || "ASC".equalsIgnoreCase(sort))) {
            sort = "DESC";
        }

        int itemCount = userDAO.getUserCount();
        pageDTO.setItemCount(itemCount);

        pageUtil.calculatePaging(pageDTO);

        List<UserDTO> users = userDAO.getUsers(Map.of("offset",pageDTO.getOffset(), "size", pageDTO.getSize(), "sort",sort));

        String pagingHtml = pageUtil.getPagingHtml(pageDTO, request.getContextPath() + "/user/list", Map.of("size", pageDTO.getSize(), "sort",sort));

        return Map.of("users", users, "pagingHtml", pagingHtml);
    }

}
