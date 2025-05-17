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


import com.dao.ErjixueyuanDao;
import com.entity.ErjixueyuanEntity;
import com.service.ErjixueyuanService;
import com.entity.vo.ErjixueyuanVO;
import com.entity.view.ErjixueyuanView;

@Service("erjixueyuanService")
public class ErjixueyuanServiceImpl extends ServiceImpl<ErjixueyuanDao, ErjixueyuanEntity> implements ErjixueyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
		/**
		 * 分页查询 ErjixueyuanEntity 数据（无条件）
		 * params:分页参数
		 * EntityWrapper：查询条件（这里为空，表示查全部）
		 * 使用 MyBatis-Plus 封装的分页查询。
		 * 返回 PageUtils 对象，前端容易处理。
		 */
        Page<ErjixueyuanEntity> page = this.selectPage(
                new Query<ErjixueyuanEntity>(params).getPage(),
                new EntityWrapper<ErjixueyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ErjixueyuanEntity> wrapper) {
		/**
		 * 带条件的分页查询，返回视图对象 ErjixueyuanView
		 * wrapper：封装的查询条件（如某学院名称）
		 * selectListView 是自定义 SQL（可能涉及多表联合）查询
		 * 返回的是 ErjixueyuanView 类型，用于页面展示
		 */
		  Page<ErjixueyuanView> page =new Query<ErjixueyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ErjixueyuanVO> selectListVO(Wrapper<ErjixueyuanEntity> wrapper) {
		/**
		 * 返回值对象（VO）列表：
		 * 通常用于前端展示或接口返回所需的部分字段
		 */
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ErjixueyuanVO selectVO(Wrapper<ErjixueyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ErjixueyuanView> selectListView(Wrapper<ErjixueyuanEntity> wrapper) {
		/**
		 * 返回视图对象（view）列表
		 * 多用于多表联查、包含额外字段的列表展示
		 */
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ErjixueyuanView selectView(Wrapper<ErjixueyuanEntity> wrapper) {
		/**
		 * 返回单个视图对象
		 * 多用于详情页展示
		 */
		return baseMapper.selectView(wrapper);
	}


}
