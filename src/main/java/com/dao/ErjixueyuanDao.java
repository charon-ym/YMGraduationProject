package com.dao;

import com.entity.ErjixueyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ErjixueyuanVO;
import com.entity.view.ErjixueyuanView;


/**
 * 二级学院
 * 
 * @author 
 * @email 
 * @date 2023-04-13 00:31:03
 */
public interface ErjixueyuanDao extends BaseMapper<ErjixueyuanEntity> {
	
	List<ErjixueyuanVO> selectListVO(@Param("ew") Wrapper<ErjixueyuanEntity> wrapper);
	
	ErjixueyuanVO selectVO(@Param("ew") Wrapper<ErjixueyuanEntity> wrapper);
	
	List<ErjixueyuanView> selectListView(@Param("ew") Wrapper<ErjixueyuanEntity> wrapper);

	List<ErjixueyuanView> selectListView(Pagination page,@Param("ew") Wrapper<ErjixueyuanEntity> wrapper);
	
	ErjixueyuanView selectView(@Param("ew") Wrapper<ErjixueyuanEntity> wrapper);
	

}
