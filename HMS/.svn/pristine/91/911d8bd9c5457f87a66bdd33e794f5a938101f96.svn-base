
package com.test.homeworkstate.manager;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Criteria;
import com.bstek.dorado.data.provider.Page;

import com.test.domain.Homeworkstate;
import com.test.homeworkstate.dao.HomeworkstateDao;

@Component("homeworkstateManager")
public class HomeworkstateManager {
	
	@Resource
	private HomeworkstateDao homeworkstateDao;
		
	/**                  
	* 分页查询信息，带有criteria
	* 将criteria转换为一个Map
	* @param page    
	* @param map
	* @throws Exception
	*/
	public void queryHomeworkstate(Page<Homeworkstate> page,Map<String, Object> parameter,Criteria criteria) throws Exception {
	    homeworkstateDao.queryHomeworkstate(page,parameter,criteria);
	}
	
	
	/**
	 * 数据保存，对多个数据集的操作，包括增删改
	 * @param dataItems
	 * @throws Exception
	 */
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	 public void saveHomeworkstate(Map<String, Collection> dataItems) throws Exception {
	    Collection<Homeworkstate> details =(Collection<Homeworkstate>) dataItems.get("dsHomeworkstate");
		this.saveHomeworkstate(details);
	 }
	 
	 
	 /**
	 * 针对单个数据集操作 包括增删改
	 * 
	 * @param details
	 * @throws Exception
	 */
	 public void saveHomeworkstate(Collection<Homeworkstate> details) throws Exception {
		if (null != details && details.size() > 0) {
	    	for(Homeworkstate item : details) {
				EntityState state = EntityUtils.getState(item);
				if (state.equals(EntityState.NEW)) {
					homeworkstateDao.saveData(item);
									} else if (state.equals(EntityState.MODIFIED)) {
					homeworkstateDao.updateData(item);
									} else if (state.equals(EntityState.DELETED)) {
										homeworkstateDao.deleteData(item);
				} else if (state.equals(EntityState.NONE)) {
														}
			}
		}
	 }
	 
	 
	
}
