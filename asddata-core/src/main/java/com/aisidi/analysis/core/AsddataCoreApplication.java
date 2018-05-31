package com.aisidi.analysis.core;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

/**
 *
 * @author zhaojy
 * @date 2018-05-23
 */
@SpringBootApplication
@MapperScan("com.aisidi.analysis.core.mapper")
public class AsddataCoreApplication {

	public static void main(String[] args) {
		System.out.println("===========Start===========");
		SpringApplication.run(AsddataCoreApplication.class, args);
		System.out.println("=========Run Success===========");
	}

	/**
	 *	配置mybatis的分页插件pageHelper
	 */
	@Bean
	public PageHelper pageHelper(){
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("offsetAsPageNum","true");
		properties.setProperty("rowBoundsWithCount","true");
		properties.setProperty("reasonable","true");
		//配置mysql数据库的方言
		properties.setProperty("dialect","mysql");
		pageHelper.setProperties(properties);
		return pageHelper;
	}
}
