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


import com.dao.DangzuzhixinxiDao;
import com.entity.DangzuzhixinxiEntity;
import com.service.DangzuzhixinxiService;
import com.entity.vo.DangzuzhixinxiVO;
import com.entity.view.DangzuzhixinxiView;

@Service("dangzuzhixinxiService")
public class DangzuzhixinxiServiceImpl extends ServiceImpl<DangzuzhixinxiDao, DangzuzhixinxiEntity> implements DangzuzhixinxiService {
	/**
	 * 继承ServiceImpl<Dao, Entity>：MyBatis-Plus 提供的封装类，具备基本的增删改查功能。
	 * 实现接口 DangzuzhixinxiService：这是自定义的业务接口。
	 * @param params
	 * @return
	 */
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
		/**
		 * 分页查询党组织信息。
		 * 使用空的 EntityWrapper 表示无额外条件。
		 * 最后封装成 PageUtils 返回，便于前端处理。
		 */
        Page<DangzuzhixinxiEntity> page = this.selectPage(
                new Query<DangzuzhixinxiEntity>(params).getPage(),
                new EntityWrapper<DangzuzhixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DangzuzhixinxiEntity> wrapper) {
		/**
		 * 带查询条件的分页查询（返回的是 View 层数据 DangzuzhixinxiView）。
		 * 支持条件过滤（通过 wrapper 传入条件）。
		 * 使用 baseMapper.selectListView 自定义 SQL 查询 View 类型的数据。
		 * 同样封装为 PageUtils 返回。
		 */
		  Page<DangzuzhixinxiView> page =new Query<DangzuzhixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DangzuzhixinxiVO> selectListVO(Wrapper<DangzuzhixinxiEntity> wrapper) {
		/**
		 * 查询 VO（值对象）列表，适合返回精简字段的数据。
		 */
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DangzuzhixinxiVO selectVO(Wrapper<DangzuzhixinxiEntity> wrapper) {
		/**
		 * 返回单个 VO 对象（如某条数据详情页）。
		 */
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DangzuzhixinxiView> selectListView(Wrapper<DangzuzhixinxiEntity> wrapper) {
		/**
		 * 返回 View 层数据列表（通常用于展示含关联字段的信息，如 join 查询后的结果）。
		 */
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DangzuzhixinxiView selectView(Wrapper<DangzuzhixinxiEntity> wrapper) {
		/**
		 * 返回一个 View 对象（常用于详情页展示）。
		 */
		return baseMapper.selectView(wrapper);
	}


}
