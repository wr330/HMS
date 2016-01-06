
package com.test.assignhomework.manager;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Criteria;
import com.bstek.dorado.data.provider.Page;

import com.test.domain.Assignhomework;
import com.test.assignhomework.dao.AssignhomeworkDao;

@Component("assignhomeworkManager")
public class AssignhomeworkManager {
	
	@Resource
	private AssignhomeworkDao assignhomeworkDao;
		
	/**                  
	* 分页查询信息，带有criteria
	* 将criteria转换为一个Map
	* @param page    
	* @param map
	* @throws Exception
	*/
	public void queryAssignhomework(Page<Assignhomework> page,Map<String, Object> parameter,Criteria criteria) throws Exception {
	    assignhomeworkDao.queryAssignhomework(page,parameter,criteria);
	}
	
	
	/**
	 * 数据保存，对多个数据集的操作，包括增删改
	 * @param dataItems
	 * @throws Exception
	 */
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	 public void saveAssignhomework(Map<String, Collection> dataItems) throws Exception {
	    Collection<Assignhomework> details =(Collection<Assignhomework>) dataItems.get("dsAssignhomework");
		this.saveAssignhomework(details);
	 }
	 
	 
	 /**
	 * 针对单个数据集操作 包括增删改
	 * 
	 * @param details
	 * @throws Exception
	 */
	 public void saveAssignhomework(Collection<Assignhomework> details) throws Exception {
		if (null != details && details.size() > 0) {
	    	for(Assignhomework item : details) {
				EntityState state = EntityUtils.getState(item);
				if (state.equals(EntityState.NEW)) {
					assignhomeworkDao.saveData(item);
									} else if (state.equals(EntityState.MODIFIED)) {
					assignhomeworkDao.updateData(item);
									} else if (state.equals(EntityState.DELETED)) {
										assignhomeworkDao.deleteData(item);
				} else if (state.equals(EntityState.NONE)) {
														}
			}
		}
	 }
	 
	 
	
}
