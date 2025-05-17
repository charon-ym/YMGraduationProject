package com.dao;

import com.entity.XueshengrudangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XueshengrudangVO;
import com.entity.view.XueshengrudangView;


/**
 * 学生入党
 * 
 * @author 
 * @email 
 * @date 2023-04-13 00:31:03
 */
public interface XueshengrudangDao extends BaseMapper<XueshengrudangEntity> {
	
	List<XueshengrudangVO> selectListVO(@Param("ew") Wrapper<XueshengrudangEntity> wrapper);
	
	XueshengrudangVO selectVO(@Param("ew") Wrapper<XueshengrudangEntity> wrapper);
	
	List<XueshengrudangView> selectListView(@Param("ew") Wrapper<XueshengrudangEntity> wrapper);

	List<XueshengrudangView> selectListView(Pagination page,@Param("ew") Wrapper<XueshengrudangEntity> wrapper);
	
	XueshengrudangView selectView(@Param("ew") Wrapper<XueshengrudangEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XueshengrudangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XueshengrudangEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XueshengrudangEntity> wrapper);



}
