package com.amos.mapper;

import com.amos.bean.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component("accountMapper")
public interface AccountMapper {
    @Select("SELECT * FROM account WHERE id = #{id}")
    @Results(id = "accountResult", value = {
            @Result(property = "accountId", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password")
    })
    Account selectAccountByID(@Param("id") int accountId);

    @Insert("INSERT INTO account (name, password) VALUES ( #{name}, #{password} )")
    @Options(useGeneratedKeys = true, keyProperty = "accountId", keyColumn = "id")
    int insertAccount(Account account);

//    @Update("<script> update Author" +
//            "<set> " +
//            "<if test=\"username != null\">username=#{username},</if> " +
//            "<if test=\"password != null\">password=#{password},</if> " +
//            "<if test=\"email != null\">email=#{email},</if> " +
//            "<if test=\"bio != null\">bio=#{bio}</if>" +
//            "</set>" +
//            "where id=#{id}" +
//            "</script>")
    @Update("INSERT INTO account VALUES(#{accountId}, #{name}, #{password}) ON DUPLICATE KEY UPDATE name=#{name}, password=#{password}")
    int insertUpdateAccount(Account account);


    @Delete("delete from account where id = #{id}")
    int deleteAccountByID(@Param("id") int accountId);

    @ResultMap("accountResult")
    @Select("select * from account")
    Account[] selectAll();
}
