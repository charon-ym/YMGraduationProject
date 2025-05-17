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

import com.entity.JiaogongEntity;
import com.entity.view.JiaogongView;

import com.service.JiaogongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 教工
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-13 00:31:03
 */
@RestController
@RequestMapping("/jiaogong")
public class JiaogongController {
    @Autowired
    private JiaogongService jiaogongService;


    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		JiaogongEntity u = jiaogongService.selectOne(new EntityWrapper<JiaogongEntity>().eq("jiaogongzhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"jiaogong",  "教工" );
		return R.ok().put("token", token);
	}

	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody JiaogongEntity jiaogong){
    	//ValidatorUtils.validateEntity(jiaogong);
    	JiaogongEntity u = jiaogongService.selectOne(new EntityWrapper<JiaogongEntity>().eq("jiaogongzhanghao", jiaogong.getJiaogongzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		jiaogong.setId(uId);
        jiaogongService.insert(jiaogong);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        JiaogongEntity u = jiaogongService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	JiaogongEntity u = jiaogongService.selectOne(new EntityWrapper<JiaogongEntity>().eq("jiaogongzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        jiaogongService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaogongEntity jiaogong,
		HttpServletRequest request){
        EntityWrapper<JiaogongEntity> ew = new EntityWrapper<JiaogongEntity>();

		PageUtils page = jiaogongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaogong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaogongEntity jiaogong, 
		HttpServletRequest request){
        EntityWrapper<JiaogongEntity> ew = new EntityWrapper<JiaogongEntity>();

		PageUtils page = jiaogongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaogong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaogongEntity jiaogong){
       	EntityWrapper<JiaogongEntity> ew = new EntityWrapper<JiaogongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaogong, "jiaogong")); 
        return R.ok().put("data", jiaogongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaogongEntity jiaogong){
        EntityWrapper< JiaogongEntity> ew = new EntityWrapper< JiaogongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaogong, "jiaogong")); 
		JiaogongView jiaogongView =  jiaogongService.selectView(ew);
		return R.ok("查询教工成功").put("data", jiaogongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaogongEntity jiaogong = jiaogongService.selectById(id);
        return R.ok().put("data", jiaogong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaogongEntity jiaogong = jiaogongService.selectById(id);
        return R.ok().put("data", jiaogong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaogongEntity jiaogong, HttpServletRequest request){
    	jiaogong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaogong);
    	JiaogongEntity u = jiaogongService.selectOne(new EntityWrapper<JiaogongEntity>().eq("jiaogongzhanghao", jiaogong.getJiaogongzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		jiaogong.setId(new Date().getTime());
        jiaogongService.insert(jiaogong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaogongEntity jiaogong, HttpServletRequest request){
    	jiaogong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaogong);
    	JiaogongEntity u = jiaogongService.selectOne(new EntityWrapper<JiaogongEntity>().eq("jiaogongzhanghao", jiaogong.getJiaogongzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		jiaogong.setId(new Date().getTime());
        jiaogongService.insert(jiaogong);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaogongEntity jiaogong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaogong);
        jiaogongService.updateById(jiaogong);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaogongService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<JiaogongEntity> wrapper = new EntityWrapper<JiaogongEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = jiaogongService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
