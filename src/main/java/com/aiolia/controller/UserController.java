package com.aiolia.controller;

import com.aiolia.common.R;
import com.aiolia.entity.User;
import com.aiolia.service.UserService;
import com.aiolia.utils.SMSUtils;
import com.aiolia.utils.ValidateCodeUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author aiolia
 * @version 1.0
 * @create 2022/12/19
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController
{
    @Autowired
    private UserService userService;

    /**
     * 发送手机短信验证码
     * @param user
     * @return
     */
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session)
    {
        String phone=user.getPhone();
        if(StringUtils.isNotEmpty(phone))
        {
            String code= ValidateCodeUtils.generateValidateCode(4).toString();
            log.info("code={");
            /*SMSUtils.sendMessage("瑞吉外卖","",phone,code);*/
            session.setAttribute(phone,code);

            return R.success("手机验证码短信发送成功");
        }

        return R.error("短信发送失败");
    }

    /**
     * 移动端用户登录
     * @param map
     * @param session
     * @return
     */
    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession session)
    {
        String phone=map.get("phone").toString();
        String code=map.get("code").toString();

        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhone,phone);
        User user=userService.getOne(queryWrapper);
        if(user==null)
        {
            user=new User();
            user.setPhone(phone);
            user.setStatus(1);
            userService.save(user);
        }

        session.setAttribute("user",user.getId());
        return R.success(user);

        /*Object codeInSession=session.getAttribute(phone);
        if(codeInSession!=null&&codeInSession.equals(code))
        {
            LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone,phone);
            User user=userService.getOne(queryWrapper);
            if(user==null)
            {
                user=new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);
            }
            return R.success(user);
        }

        return R.error("登录失败");*/
    }

    /**
     * 用户退出
     * @param request
     * @return
     */
    @PostMapping("/loginout")
    public R<String> logout(HttpServletRequest request)
    {
        request.getSession().removeAttribute("user");
        return R.success("退出成功");
    }
}
