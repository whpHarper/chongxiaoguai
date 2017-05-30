package com.cxg.interactiveweb.tools;

import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtils {
	private Properties props = new Properties();
	public PropertiesUtils(String url){
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
