package com.test.assignhomework.pr;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Criteria;
import com.bstek.dorado.data.provider.Page;

import com.test.domain.Assignhomework;
import com.test.assignhomework.manager.AssignhomeworkManager;

@Component("assignhomeworkPR")
public class AssignhomeworkPR{

    @Resource
	private AssignhomeworkManager assignhomeworkManager;

     
   /**                  
	* 分页查询信息，带有criteria
	* @param page    
	* @param map
	* @throws Exception
	*/
	@DataProvider
	public void queryAssignhomework(Page<Assignhomework> page,Map<String, Object> parameter,Criteria criteria) throws Exception {
	    assignhomeworkManager.queryAssignhomework(page,parameter,criteria);
	}
	
	
	/**
	 * 数据保存，包括增删改
	 * @param dataItems
	 * @throws Exception
	 */
	 @SuppressWarnings("rawtypes")
	 @DataResolver
	 public void saveAssignhomework(Map<String, Collection> dataItems) throws Exception {
	    assignhomeworkManager.saveAssignhomework(dataItems);
	 }
	
}
