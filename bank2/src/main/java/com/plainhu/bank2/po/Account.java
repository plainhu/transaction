package com.plainhu.bank2.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author hkt
 * @since 2021-02-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_account")
public class Account extends Model<Account> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String username;

    private Integer balance;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
