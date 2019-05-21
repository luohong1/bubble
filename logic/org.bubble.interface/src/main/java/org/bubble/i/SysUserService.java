package org.bubble.i;

import org.bubble.domain.SysUser;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author luohong
 * @since 2018-12-26
 */
public interface SysUserService extends IService<SysUser> {

   /**
    * 获取所有管理员信息
    * @return
    */
   List<SysUser> getAllAdministrator();

   /**
    * 根据账号查询管理员信息
    * @param p_userCode 管理员账号
    * @return
    */
   SysUser getUserByCode(String p_userCode);
}
