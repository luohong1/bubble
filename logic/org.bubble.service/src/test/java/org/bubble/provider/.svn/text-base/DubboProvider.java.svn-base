package org.bubble.provider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bubble.i.SysUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @描述: 启动Dubbo服务用的MainClass.
 * @作者: luohong
 * @创建时间: 2018-10-5,下午9:47:55 .
 * @版本: 1.0 .
 */

public class DubboProvider {

    private static final Log log = LogFactory.getLog(DubboProvider.class);

    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
            //测试数据获取
            SysUserService userService=(SysUserService) context.getBean("sysUserService");
            System.out.println(userService.getAllAdministrator());
            context.start();
        } catch (Exception e) {
            log.error("== DubboProvider context start error:",e);
        }
        synchronized (DubboProvider.class) {
            while (true) {
                try {
                    System.out.println("服务已启动");
                    DubboProvider.class.wait();
                } catch (InterruptedException e) {
                    log.error("== synchronized error:",e);
                }
            }
        }
    }

}