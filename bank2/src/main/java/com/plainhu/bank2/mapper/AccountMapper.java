package com.plainhu.bank2.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.plainhu.bank2.po.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author hkt
 * @since 2021-02-07
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

}
