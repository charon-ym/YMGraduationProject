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


import com.dao.JiaogongrudangDao;
import com.entity.JiaogongrudangEntity;
import com.service.JiaogongrudangService;
import com.entity.vo.JiaogongrudangVO;
import com.entity.view.JiaogongrudangView;

@Service("jiaogongrudangService")
public class JiaogongrudangServiceImpl extends ServiceImpl<JiaogongrudangDao, JiaogongrudangEntity> implements JiaogongrudangService {
	/**
	 * 教师入党信息（Jiaogongrudang） 模块的服务实现类，提供对数据库表 jiaogongrudang 的各种查询和统计功能。
	 * @param params
	 * @return
	 */
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
		/**
		 * 无条件分页查询JiaogongrudangEntity 实体
		 * 用于前端分页展示数据
		 * 使用Query封装页码、条数参数
		 */
        Page<JiaogongrudangEntity> page = this.selectPage(
                new Query<JiaogongrudangEntity>(params).getPage(),
                new EntityWrapper<JiaogongrudangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaogongrudangEntity> wrapper) {
		/**
		 * 带查询条件的分页查询，返回View视图对象
		 * JiaogongrudangView：一般用于多表联查、展示详细信息。
		 * wrapper：查询条件，如按教师名、状态筛选。
		 */
		  Page<JiaogongrudangView> page =new Query<JiaogongrudangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiaogongrudangVO> selectListVO(Wrapper<JiaogongrudangEntity> wrapper) {
		/**
		 * VO（值对象）：只封装部分字段用于前端展示，避免暴露所有数据库字段。
		 * 用于详情页或数据筛选。
		 */
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiaogongrudangVO selectVO(Wrapper<JiaogongrudangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiaogongrudangView> selectListView(Wrapper<JiaogongrudangEntity> wrapper) {
		/**
		 * View：比 VO 更丰富，通常是多表联查结果或冗余字段封装。
		 * selectView 用于获取单条记录，selectListView 用于列表。
		 */
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaogongrudangView selectView(Wrapper<JiaogongrudangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


	/**
	 * 图表统计、聚合分析，比如 ECharts 图表。
	 * selectValue：普通的字段值统计（比如入党状态计数）。
	 * selectTimeStatValue：按时间字段（如入党时间）分组统计。
	 * selectGroup：对某字段（如部门、教师类别）分组并计数。
	 */
    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<JiaogongrudangEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<JiaogongrudangEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<JiaogongrudangEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

}
