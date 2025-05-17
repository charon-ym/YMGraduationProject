package com.service;

import java.util.List;
import java.util.Map;

public interface CommonService {
	List<String> getOption(Map<String, Object> params);
	/**
	 * 用于获取某字段的下拉选项值（如前端的 select 下拉框）。
	 * 获取某列的所有不重复值（如“政治面貌”、“学历”）。
	 * @param params
	 * @return
	 */
	
	Map<String, Object> getFollowByOption(Map<String, Object> params);
	/**
	 * 根据某个选项值获取对应的后续值或详细信息
	 * 级联查询（如根据一级学院选二级学院） 获取选中值的额外描述信息。
	 * @param params
	 */
	
	void sh(Map<String, Object> params);
	/**
	 * 执行审核操作
	 * 审核通过/拒绝某条记录（比如入党申请）
	 * @param params
	 * @return
	 */
	
	int remindCount(Map<String, Object> params);
	/**
	 * 返回提醒数量
	 * 首页红点提醒
	 * 用户自定义提醒
	 * @param params
	 * @return
	 */
	
	Map<String, Object> selectCal(Map<String, Object> params);
	/**
	 * 做日历类统计
	 * 按日期统计记录数量，比如某月有几人入党、举办了几场会议。
	 * @param params
	 * @return
	 */
	
	List<Map<String, Object>> selectGroup(Map<String, Object> params);
	/**
	 * 执行分组统计（Group By 查询）。
	 * 统计各学院党员人数
	 * 某字段按类别分布统计。
	 * @param params
	 * @return
	 */
	
	List<Map<String, Object>> selectValue(Map<String, Object> params);
	/**
	 * 获取指定字段的数值（支持计算/筛选）。
	 * 获取单列值集合，用于绘图/筛选。
	 * @param params
	 * @return
	 */

	List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params);
	/**
	 * 执行时间维度的统计（如按日、周、月）。
	 * 时间趋势图、折线图数据源。
	 * 分析过去几个月的入党人数变化等。
	 */

}
