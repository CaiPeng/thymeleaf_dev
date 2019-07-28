package org.professor.blog.controller;

import org.professor.blog.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MediaTypeController {

    /**
     * 根据客户端请求的 Content-Type，响应相应的 UserVO 类型.
     *
     * @return User
     */
    @RequestMapping("/user")
    public User getUser() {
        return new User("Professor", 18);
    }

}