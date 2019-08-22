package com.amos.mapper;

import com.amos.bean.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component("accountMapper")
public interface AccountMapper {
    @Select("SELECT * FROM account WHERE id = #{id}")
    Account selectAccountByID(@Param("id") int id);

    @Insert("INSERT INTO account (name) VALUES ( #{name} )")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertAccount(Account account);

    @Select("select * from account")
    Account[] selectAll();
}
