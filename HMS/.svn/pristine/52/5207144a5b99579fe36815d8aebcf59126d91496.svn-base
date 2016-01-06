
package com.test.userinfoemation.manager;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Criteria;
import com.bstek.dorado.data.provider.Page;

import com.test.domain.Userinfoemation;
import com.test.userinfoemation.dao.UserinfoemationDao;

@Component("userinfoemationManager")
public class UserinfoemationManager {
	
	@Resource
	private UserinfoemationDao userinfoemationDao;
		
	/**                  
	* 分页查询信息，带有criteria
	* 将criteria转换为一个Map
	* @param page    
	* @param map
	* @throws Exception
	*/
	public void queryUserinfoemation(Page<Userinfoemation> page,Map<String, Object> parameter,Criteria criteria) throws Exception {
	    userinfoemationDao.queryUserinfoemation(page,parameter,criteria);
	}
	
	
	/**
	 * 数据保存，对多个数据集的操作，包括增删改
	 * @param dataItems
	 * @throws Exception
	 */
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	 public void saveUserinfoemation(Map<String, Collection> dataItems) throws Exception {
	    Collection<Userinfoemation> details =(Collection<Userinfoemation>) dataItems.get("dsUserinfoemation");
		this.saveUserinfoemation(details);
	 }
	 
	 
	 /**
	 * 针对单个数据集操作 包括增删改
	 * 
	 * @param details
	 * @throws Exception
	 */
	 public void saveUserinfoemation(Collection<Userinfoemation> details) throws Exception {
		if (null != details && details.size() > 0) {
	    	for(Userinfoemation item : details) {
				EntityState state = EntityUtils.getState(item);
				if (state.equals(EntityState.NEW)) {
					userinfoemationDao.saveData(item);
									} else if (state.equals(EntityState.MODIFIED)) {
					userinfoemationDao.updateData(item);
									} else if (state.equals(EntityState.DELETED)) {
										userinfoemationDao.deleteData(item);
				} else if (state.equals(EntityState.NONE)) {
														}
			}
		}
	 }
	 
	 
	
}
