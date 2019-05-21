package org.bubble.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.bubble.domain.SysUser;
import org.bubble.mapper.SysUserMapper;
import org.bubble.i.SysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author luohong
 * @since 2018-12-26
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    EntityWrapper<SysUser> ew;

    @Override
    public List<SysUser> getAllAdministrator() {
        return sysUserMapper.getAllAdministrator();
    }

    @Override
    public SysUser getUserByCode(String p_userCode) {
        if (p_userCode == null || p_userCode.trim().isEmpty()) {
            return null;
        } else {
            return sysUserMapper.getUserByCode(p_userCode);
        }
    }

}
