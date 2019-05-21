package org.bubble.mapper;

import org.bubble.domain.SysUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author luohong
 * @since 2018-12-26
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    //@Select("SELECT ID,CREATE_TIME,VERSION,USER_CODE,USER_NAME,USER_PWD FROM sys_user")
    //@Select("getAllAdministrator")
    List<SysUser> getAllAdministrator();

    //@Select("getUserByCode")
    SysUser getUserByCode(String userCode);
}