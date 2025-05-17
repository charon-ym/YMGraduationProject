package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XueshengrudangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XueshengrudangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XueshengrudangView;


/**
 * 学生入党
 *
 * @author 
 * @email 
 * @date 2023-04-13 00:31:03
 */
public interface XueshengrudangService extends IService<XueshengrudangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueshengrudangVO> selectListVO(Wrapper<XueshengrudangEntity> wrapper);
   	
   	XueshengrudangVO selectVO(@Param("ew") Wrapper<XueshengrudangEntity> wrapper);
   	
   	List<XueshengrudangView> selectListView(Wrapper<XueshengrudangEntity> wrapper);
   	
   	XueshengrudangView selectView(@Param("ew") Wrapper<XueshengrudangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueshengrudangEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<XueshengrudangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<XueshengrudangEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<XueshengrudangEntity> wrapper);



}

