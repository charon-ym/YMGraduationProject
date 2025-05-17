package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiaogongrudangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiaogongrudangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaogongrudangView;


/**
 * 教工入党
 *
 * @author 
 * @email 
 * @date 2023-04-13 00:31:03
 */
public interface JiaogongrudangService extends IService<JiaogongrudangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaogongrudangVO> selectListVO(Wrapper<JiaogongrudangEntity> wrapper);
   	
   	JiaogongrudangVO selectVO(@Param("ew") Wrapper<JiaogongrudangEntity> wrapper);
   	
   	List<JiaogongrudangView> selectListView(Wrapper<JiaogongrudangEntity> wrapper);
   	
   	JiaogongrudangView selectView(@Param("ew") Wrapper<JiaogongrudangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaogongrudangEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<JiaogongrudangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<JiaogongrudangEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<JiaogongrudangEntity> wrapper);



}

