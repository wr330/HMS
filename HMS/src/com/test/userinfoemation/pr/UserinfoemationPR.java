package com.test.userinfoemation.pr;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Criteria;
import com.bstek.dorado.data.provider.Page;

import com.test.domain.Userinfoemation;
import com.test.userinfoemation.manager.UserinfoemationManager;

@Component("userinfoemationPR")
public class UserinfoemationPR{

    @Resource
	private UserinfoemationManager userinfoemationManager;

     
   /**                  
	* 分页查询信息，带有criteria
	* @param page    
	* @param map
	* @throws Exception
	*/
	@DataProvider
	public void queryUserinfoemation(Page<Userinfoemation> page,Map<String, Object> parameter,Criteria criteria) throws Exception {
	    userinfoemationManager.queryUserinfoemation(page,parameter,criteria);
	}
	
	
	/**
	 * 数据保存，包括增删改
	 * @param dataItems
	 * @throws Exception
	 */
	 @SuppressWarnings("rawtypes")
	 @DataResolver
	 public void saveUserinfoemation(Map<String, Collection> dataItems) throws Exception {
	    userinfoemationManager.saveUserinfoemation(dataItems);
	 }
	
}
