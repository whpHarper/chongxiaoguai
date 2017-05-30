package com.cxg.utils;

import java.io.InputStreamReader;
import java.util.Properties;

public class ConfigProperties {
	
	private Properties props = new Properties();
	
	public ConfigProperties(){
		 InputStreamReader is;
		try {
			is = new InputStreamReader(this.getClass().getResourceAsStream("/config.properties"),"UTF-8");
			props.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ConfigProperties(String url){
		InputStreamReader is;
		try {
			is = new InputStreamReader(this.getClass().getResourceAsStream(url),"UTF-8");
			props.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getProperty(String key) {
        return this.props.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return this.props.getProperty(key, defaultValue);
    }
}
