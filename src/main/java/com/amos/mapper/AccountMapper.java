package com.amos.mapper;

import com.amos.bean.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component("accountMapper")
public interface AccountMapper {
    @Select("SELECT id as accountId, name FROM account WHERE id = #{id}")
    Account selectAccountByID(@Param("id") int accountId);

    @Insert("INSERT INTO account (name) VALUES ( #{name} )")
    @Options(useGeneratedKeys = true, keyProperty = "accountId", keyColumn = "id")
    int insertAccount(Account account);

    @Delete("delete from account where id = #{id}")
    int deleteAccountByID(@Param("id") int accountId);

    @Select("select id as accountId, name from account")
    Account[] selectAll();
}
