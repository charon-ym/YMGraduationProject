package com.dao;

import com.entity.DangzuzhixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.DangzuzhixinxiVO;
import com.entity.view.DangzuzhixinxiView;



/**
 * 党组织信息
 * @author 
 * @email 
 * @date 2023-04-13 00:31:03
 */
public interface DangzuzhixinxiDao extends BaseMapper<DangzuzhixinxiEntity> {
	/**
	 * MyBatis-Plus DAO（数据访问对象）接口，用于访问数据库中与 DangzuzhixinxiEntity（党组织信息实体类）相关的数据。
	 * 接口名为 DangzuzhixinxiDao，继承了 MyBatis-Plus 提供的 BaseMapper，并定义了多个自定义查询方法。
	 * 定义与数据库交互的 SQL 映射接口，具体的 SQL 实现由 MyBatis XML 或注解完成。
	 * BaseMapper<T> 是 MyBatis-Plus 提供的泛型接口，封装了基础的增删改查（CRUD）方法；
	 * 所以只要继承了 BaseMapper<DangzuzhixinxiEntity>，就拥有了对 dangzuzhixinxi 表的基本操作
	 * @param wrapper
	 * @return
	 */
	
	List<DangzuzhixinxiVO> selectListVO(@Param("ew") Wrapper<DangzuzhixinxiEntity> wrapper);
	/**
	 * 查询结果为一组 VO（View Object），即用于页面展示的对象；
	 * @Param("ew") 是 MyBatis 中的注解，告诉 SQL 使用的参数名；
	 * @param wrapper 是 MyBatis-Plus 的条件构造器，可用来构建动态 SQL 查询条件。
	 * @return
	 */
	
	DangzuzhixinxiVO selectVO(@Param("ew") Wrapper<DangzuzhixinxiEntity> wrapper);
	/**
	 * 查询一条 VO 数据；
	 * 通常用于详情页或唯一条件匹配。
	 * @param wrapper
	 * @return
	 */
	
	List<DangzuzhixinxiView> selectListView(@Param("ew") Wrapper<DangzuzhixinxiEntity> wrapper);
	/**
	 * 查询一组 View 对象（通常是连接了多个表或包含计算字段的视图类）；
	 * 可用于数据展示层（例如列表页）。
	 * @param page
	 * @param wrapper
	 * @return
	 */

	List<DangzuzhixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DangzuzhixinxiEntity> wrapper);
	/**
	 * 带分页功能的查询方法；
	 * 参数 Pagination page 是 MyBatis-Plus 提供的分页类；
	 * 通常与前端的分页请求配合使用。
	 * @param wrapper
	 * @return
	 */
	
	DangzuzhixinxiView selectView(@Param("ew") Wrapper<DangzuzhixinxiEntity> wrapper);
	/**
	 * 查询一条 View 数据；
	 * 用于视图详情页展示。
	 */
}
