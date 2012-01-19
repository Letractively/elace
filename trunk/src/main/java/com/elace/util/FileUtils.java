package com.elace.util;

import org.apache.commons.lang.StringUtils;

public class FileUtils {
	
	/**
	 * 获取上传文件的扩展名
	 * @param fileName
	 * @return
	 */
	public static String getExtensionName(String fileName) {
		String extensionName = "";
		if(!StringUtils.isBlank(fileName)){
			String[] strs = fileName.split("\\.");
			if(strs.length == 2){
				extensionName = strs[1];
			}
		}
		return extensionName;
	}

}
