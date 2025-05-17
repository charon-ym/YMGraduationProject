package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JiaogongrudangEntity;
import com.entity.view.JiaogongrudangView;

import com.service.JiaogongrudangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 教工入党
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-13 00:31:03
 */
@RestController
@RequestMapping("/jiaogongrudang")
public class JiaogongrudangController {
    @Autowired
    private JiaogongrudangService jiaogongrudangService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaogongrudangEntity jiaogongrudang,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaogong")) {
			jiaogongrudang.setJiaogongzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiaogongrudangEntity> ew = new EntityWrapper<JiaogongrudangEntity>();

		PageUtils page = jiaogongrudangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaogongrudang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaogongrudangEntity jiaogongrudang, 
		HttpServletRequest request){
        EntityWrapper<JiaogongrudangEntity> ew = new EntityWrapper<JiaogongrudangEntity>();

		PageUtils page = jiaogongrudangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaogongrudang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaogongrudangEntity jiaogongrudang){
       	EntityWrapper<JiaogongrudangEntity> ew = new EntityWrapper<JiaogongrudangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaogongrudang, "jiaogongrudang")); 
        return R.ok().put("data", jiaogongrudangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaogongrudangEntity jiaogongrudang){
        EntityWrapper< JiaogongrudangEntity> ew = new EntityWrapper< JiaogongrudangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaogongrudang, "jiaogongrudang")); 
		JiaogongrudangView jiaogongrudangView =  jiaogongrudangService.selectView(ew);
		return R.ok("查询教工入党成功").put("data", jiaogongrudangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaogongrudangEntity jiaogongrudang = jiaogongrudangService.selectById(id);
        return R.ok().put("data", jiaogongrudang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaogongrudangEntity jiaogongrudang = jiaogongrudangService.selectById(id);
        return R.ok().put("data", jiaogongrudang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaogongrudangEntity jiaogongrudang, HttpServletRequest request){
    	jiaogongrudang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaogongrudang);
        jiaogongrudangService.insert(jiaogongrudang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaogongrudangEntity jiaogongrudang, HttpServletRequest request){
    	jiaogongrudang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaogongrudang);
        jiaogongrudangService.insert(jiaogongrudang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaogongrudangEntity jiaogongrudang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaogongrudang);
        jiaogongrudangService.updateById(jiaogongrudang);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaogongrudangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<JiaogongrudangEntity> wrapper = new EntityWrapper<JiaogongrudangEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaogong")) {
			wrapper.eq("jiaogongzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = jiaogongrudangService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	






    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<JiaogongrudangEntity> ew = new EntityWrapper<JiaogongrudangEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaogong")) {
            ew.eq("jiaogongzhanghao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = jiaogongrudangService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<JiaogongrudangEntity> ew = new EntityWrapper<JiaogongrudangEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("jiaogong")) {
            ew.eq("jiaogongzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = jiaogongrudangService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<JiaogongrudangEntity> ew = new EntityWrapper<JiaogongrudangEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("jiaogong")) {
            ew.eq("jiaogongzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = jiaogongrudangService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,JiaogongrudangEntity jiaogongrudang, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("jiaogong")) {
            jiaogongrudang.setJiaogongzhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<JiaogongrudangEntity> ew = new EntityWrapper<JiaogongrudangEntity>();
        int count = jiaogongrudangService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaogongrudang), params), params));
        return R.ok().put("data", count);
    }


}
