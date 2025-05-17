package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DangzuzhixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DangzuzhixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DangzuzhixinxiView;


/**
 * 党组织信模块
 *
 * @author 
 * @email 
 * @date 2023-04-13 00:31:03
 */
public interface DangzuzhixinxiService extends IService<DangzuzhixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DangzuzhixinxiVO> selectListVO(Wrapper<DangzuzhixinxiEntity> wrapper);
   	
   	DangzuzhixinxiVO selectVO(@Param("ew") Wrapper<DangzuzhixinxiEntity> wrapper);
   	
   	List<DangzuzhixinxiView> selectListView(Wrapper<DangzuzhixinxiEntity> wrapper);
   	
   	DangzuzhixinxiView selectView(@Param("ew") Wrapper<DangzuzhixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DangzuzhixinxiEntity> wrapper);

}

