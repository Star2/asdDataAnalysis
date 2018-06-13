package com.aisidi.analysis.core.service;

public abstract class AbstractService {

	
	public static int getTotalPage(int count  , int num) {  
		int totalPage = 0 ;
        if (count % num == 0)  
            totalPage = count / num;  
        else  
            totalPage = count / num + 1;  
        return totalPage;  
    } 
	
	
	public static void main(String[] args) {
		System.out.println(getTotalPage(1001	, 10));
	}
}
