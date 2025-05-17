package com.entity.view;

import com.entity.JiaogongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 教工
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-13 00:31:03
 */
@TableName("jiaogong")
public class JiaogongView  extends JiaogongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiaogongView(){
	}
 
 	public JiaogongView(JiaogongEntity jiaogongEntity){
 	try {
			BeanUtils.copyProperties(this, jiaogongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
