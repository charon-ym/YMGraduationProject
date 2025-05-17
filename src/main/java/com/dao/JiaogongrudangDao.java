package com.dao;

import com.entity.JiaogongrudangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiaogongrudangVO;
import com.entity.view.JiaogongrudangView;


/**
 * 教工入党
 * 
 * @author 
 * @email 
 * @date 2023-04-13 00:31:03
 */
public interface JiaogongrudangDao extends BaseMapper<JiaogongrudangEntity> {
	
	List<JiaogongrudangVO> selectListVO(@Param("ew") Wrapper<JiaogongrudangEntity> wrapper);
	
	JiaogongrudangVO selectVO(@Param("ew") Wrapper<JiaogongrudangEntity> wrapper);
	
	List<JiaogongrudangView> selectListView(@Param("ew") Wrapper<JiaogongrudangEntity> wrapper);

	List<JiaogongrudangView> selectListView(Pagination page,@Param("ew") Wrapper<JiaogongrudangEntity> wrapper);
	
	JiaogongrudangView selectView(@Param("ew") Wrapper<JiaogongrudangEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiaogongrudangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiaogongrudangEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiaogongrudangEntity> wrapper);



}
