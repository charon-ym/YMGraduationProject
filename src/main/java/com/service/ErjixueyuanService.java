package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ErjixueyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ErjixueyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ErjixueyuanView;


/**
 * 二级学院
 *
 * @author 
 * @email 
 * @date 2023-04-13 00:31:03
 */
public interface ErjixueyuanService extends IService<ErjixueyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ErjixueyuanVO> selectListVO(Wrapper<ErjixueyuanEntity> wrapper);
   	
   	ErjixueyuanVO selectVO(@Param("ew") Wrapper<ErjixueyuanEntity> wrapper);
   	
   	List<ErjixueyuanView> selectListView(Wrapper<ErjixueyuanEntity> wrapper);
   	
   	ErjixueyuanView selectView(@Param("ew") Wrapper<ErjixueyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ErjixueyuanEntity> wrapper);
   	

}

