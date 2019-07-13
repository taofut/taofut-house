package com.ft.house.mapper;

import com.ft.house.common.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 创建人：taofut
 * 创建时间：2019-06-30 15:43
 * 描述：
 */
@Mapper
public interface UserMapper {

    List<User> selectUsers();
}
