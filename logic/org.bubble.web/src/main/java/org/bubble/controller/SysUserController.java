package org.bubble.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.bubble.domain.SysUser;
import org.bubble.i.SysUserService;
import org.bubble.base.http.DataSet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiOperation;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luohong
 * @since 2018-12-26
 */
@Controller
@RequestMapping("/SysUser")
@Api(tags = "SysUser用户信息") //swagger分类标题注解
public class SysUserController {
    private static Logger log=LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    SysUserService sysUserService;

    @ApiResponses(value = {
            @ApiResponse(code = 1, message = "查询成功"),
            @ApiResponse(code = -1, message = "查询失败")})
    @ApiOperation(httpMethod = "GET", value = "查询管理员信息")//swagger 当前接口注解
    @RequestMapping(value="/getUser",method=RequestMethod.GET)
    public ResponseEntity getUserByCode(HttpServletRequest request,String userCode){
        log.debug("查询管理员信息");
        return DataSet.ok(sysUserService.getUserByCode(userCode));
    }
    @ApiResponses(value = {
            @ApiResponse(code = 1, message = "查询成功"),
            @ApiResponse(code = -1, message = "查询失败")})
    @ApiOperation(httpMethod = "GET", value = "查询所有管理员信息")//swagger 当前接口注解
    @RequestMapping(value="getAllAdministrator",method=RequestMethod.GET)
    public ResponseEntity getAllAdministrator(HttpServletRequest request){
        log.debug("查询所有管理员信息");
        return DataSet.ok(sysUserService.getAllAdministrator());
    }
}
