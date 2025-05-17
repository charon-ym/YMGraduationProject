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


import com.dao.XueshengrudangDao;
import com.entity.XueshengrudangEntity;
import com.service.XueshengrudangService;
import com.entity.vo.XueshengrudangVO;
import com.entity.view.XueshengrudangView;

@Service("xueshengrudangService")
public class XueshengrudangServiceImpl extends ServiceImpl<XueshengrudangDao, XueshengrudangEntity> implements XueshengrudangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueshengrudangEntity> page = this.selectPage(
                new Query<XueshengrudangEntity>(params).getPage(),
                new EntityWrapper<XueshengrudangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueshengrudangEntity> wrapper) {
		  Page<XueshengrudangView> page =new Query<XueshengrudangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XueshengrudangVO> selectListVO(Wrapper<XueshengrudangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XueshengrudangVO selectVO(Wrapper<XueshengrudangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XueshengrudangView> selectListView(Wrapper<XueshengrudangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueshengrudangView selectView(Wrapper<XueshengrudangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<XueshengrudangEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<XueshengrudangEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<XueshengrudangEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
