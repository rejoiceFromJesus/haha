/**
 * 系统项目名称
 * cn.jrjzx.dbhelper.controller
 * DBController.java
 * 
 * 2017年10月13日-下午2:15:34
 *  2017金融街在线公司-版权所有
 *
 */
package cn.jrjzx.dbhelper.controller;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jrjzx.dbhelper.vo.QueryParam;

/**
 *
 * DBController
 * 
 * @author rejoice 948870341@qq.com
 * @date 2017年10月13日 下午2:15:34
 * 
 * @version 1.0.0
 *
 */
@RestController
@RequestMapping("/")
public class DBController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@PostMapping("/queryBySql")
	public List<Map<String, Object>> queryBySql(@RequestBody QueryParam param){
		String sql = param.getSql();
		if(StringUtils.isBlank(sql) || !sql.startsWith("select ")){
			throw new InvalidParameterException("invalid sql:"+sql); 
		}
		return jdbcTemplate.queryForList(sql);
	}
}
