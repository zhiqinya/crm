package com.briup.service;
/** 
* @author 作者 zhiqin: 
* @version 创建时间：2020年4月3日 上午10:43:53 
* 类说明 
*/

import java.util.List;

import com.briup.bean.CustomerConstitute;

public interface ICustomerConstituteService {
	List<CustomerConstitute> regionAnalyze();
	List<CustomerConstitute> levelAnalyze();
}
