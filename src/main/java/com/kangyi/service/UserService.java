package com.kangyi.service;

import com.kangyi.pojo.Menu;
import com.kangyi.pojo.User;
import com.kangyi.util.Result;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
    String getUserList();

    String getMenuListForPage(int pno, int psize);

    List<Menu> testList(int pno, int psize, Model model);

    User findByUsername(String userName);

    User login(String username, String password, HttpServletRequest request);

    Result getListForPage(int pno, int psize, String username, String sortField, String sortType);

    int insertUser(User user);

    User findUserById(Long id);

    void editUser(User user);

    void deleteUserById(Long id);

    String changePassword(HttpSession session, User user, Model model);

//    void bindDept(Long id, Long deptId);

//    String getCheckedDeptList(User user);

    List<User> selectAll();

    List<User> selectUname(String username);
}
