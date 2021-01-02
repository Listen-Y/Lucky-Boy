package com.luckyBoy.base;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 *设计统一的基类，以泛型的方式定义出不同的参数类型、返回类型
 * User: Listen-Y.
 * Date: 2020-08-21
 * Time: 12:59
 */

public interface BaseMapper<T> {

    /**
     * 通过主键查找
     * @param id
     * @return
     */
    T selectByPrimaryKey(Integer id);

    /**
     * 添加
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * 选择性添加
     * @param record
     * @return
     */
    int insertSelective(T record);

    /**
     * 选择性修改信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 通过主键修改信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(T record);

    /**
     * 通过主键删除数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 多信息查找数据
     * @param record
     * @return
     */
    T selectOne(T record);

    /**
     * 查找所有数据
     * @return
     */
    List<T> selectAll();

    /**
     * 通过条件查找数据
     * @param record
     * @return
     */
    List<T> selectByCondition(T record);

    /**
     * 通过id批量删除数据
     * @param ids
     * @return
     */
    int deleteByIds(List<Integer> ids);

}
