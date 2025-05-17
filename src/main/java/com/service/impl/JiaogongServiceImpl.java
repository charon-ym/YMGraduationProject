package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JiaogongDao;
import com.entity.JiaogongEntity;
import com.service.JiaogongService;
import com.entity.vo.JiaogongVO;
import com.entity.view.JiaogongView;

@Service("jiaogongService")
public class JiaogongServiceImpl extends ServiceImpl<JiaogongDao, JiaogongEntity> implements JiaogongService {
	/**
	 * 无条件分页查询
	 * @param params 分页查询参数
	 * 返回的是 JiaogongEntity 实体分页数据。
	 * 一般用于后台分页列表页面。
	 * @return
	 */
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
		/**
		 * 带条件的分页查询
		 * 返回的是JiaogongEntity 实体分页数据
		 * 一般用于后台分布列表页面
		 */
        Page<JiaogongEntity> page = this.selectPage(
                new Query<JiaogongEntity>(params).getPage(),
                new EntityWrapper<JiaogongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaogongEntity> wrapper) {
		/**
		 * 带条件的分页查询：
		 * 使用了 JiaogongView 视图类，一般为多表联查封装。
		 * wrapper：用于动态构建查询条件，例如：按院系、姓名模糊匹配等
		 */
		  Page<JiaogongView> page =new Query<JiaogongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiaogongVO> selectListVO(Wrapper<JiaogongEntity> wrapper) {
		/**
		 * VO:值对象，通常包含部分字段，供前端展示
		 * selectVO 返回单条数据，selectListVO 返回列表。
		 */
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiaogongVO selectVO(Wrapper<JiaogongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiaogongView> selectListView(Wrapper<JiaogongEntity> wrapper) {
		/**
		 * JiaogongView：视图对象，包含联表字段（如与院系表关联后的显示字段）。
		 * 通常用于前端展示或查询。
		 */
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaogongView selectView(Wrapper<JiaogongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
