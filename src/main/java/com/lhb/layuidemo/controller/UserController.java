package com.lhb.layuidemo.controller;

import com.lhb.layuidemo.dto.SuccessDTO;
import com.lhb.layuidemo.dto.UserDTO;
import com.lhb.layuidemo.mapper.UserMapper;
import com.lhb.layuidemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public String index() {
        return "list";
    }

    @RequestMapping("getuserlist")
    @ResponseBody
    public UserDTO getlist() {
        List<User> userList = userMapper.selectAllUser();
        UserDTO userDTO = new UserDTO();
        userDTO.setCount(userList.size());
        userDTO.setData(userList);
        return userDTO;
    }

    @RequestMapping("list_create")
    public String list_create() {
        return "list_create";
    }

    @PostMapping("/add")
    @ResponseBody
    public SuccessDTO add(User user) {
        userMapper.insertOneUser(user);
        return new SuccessDTO("新建成功");
    }

    @PostMapping("/delete")
    @ResponseBody
    public SuccessDTO delete(@RequestParam(value = "ids[]") String[] ids) {
        for (String id : ids) {
            int i = Integer.parseInt(id);
            userMapper.deleteById(i);
        }
        return new SuccessDTO("删除成功");
    }

    @RequestMapping("user_update")
    public String update(HttpServletRequest request,
                         @RequestParam("id") Integer id){
        HttpSession session = request.getSession();
        session.setAttribute("id",id);
        return "list_update";
    }

    @RequestMapping("{id}")
    @ResponseBody
    public User update(@PathVariable(value = "id") Integer id){
        User user = userMapper.selectOneUser(id);
        return user;
    }

    @PostMapping("/update")
    @ResponseBody
    public SuccessDTO update(User user){
        userMapper.updateUser(user);
        return new SuccessDTO("修改成功");
    }
}
