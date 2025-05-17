package com.dao;

import com.entity.JiaogongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiaogongVO;
import com.entity.view.JiaogongView;


/**
 * 教工
 * 
 * @author 
 * @email 
 * @date 2023-04-13 00:31:03
 */
public interface JiaogongDao extends BaseMapper<JiaogongEntity> {
	
	List<JiaogongVO> selectListVO(@Param("ew") Wrapper<JiaogongEntity> wrapper);
	
	JiaogongVO selectVO(@Param("ew") Wrapper<JiaogongEntity> wrapper);
	
	List<JiaogongView> selectListView(@Param("ew") Wrapper<JiaogongEntity> wrapper);

	List<JiaogongView> selectListView(Pagination page,@Param("ew") Wrapper<JiaogongEntity> wrapper);
	
	JiaogongView selectView(@Param("ew") Wrapper<JiaogongEntity> wrapper);
	

}
