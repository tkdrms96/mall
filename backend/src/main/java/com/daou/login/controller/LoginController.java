package com.daou.login.controller;

import com.daou.customer.component.AuthManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Api(value = "사용자 로그인 / 로그아웃")
public class LoginController {

    @ApiOperation(value = "로그인", notes = "")
    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        AuthManager.setCustomerId(request,1L);
        return request.getSession().getId();
    }

    @ApiOperation(value = "로그아웃", notes = "")
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "logout successful";
    }

}
