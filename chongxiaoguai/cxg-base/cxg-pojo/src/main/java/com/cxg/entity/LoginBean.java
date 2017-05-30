package com.cxg.entity;

import javax.persistence.Table;

/**
 * (LOGIN)
 * 
 * @author haipeng
 * @version 1.0.0 2017-05-26
 */
@Table(name="t_login")
public class LoginBean implements java.io.Serializable {

    /**  */
    private Long id;
    
    /**  */
    private String user;
    
    /**  */
    private String password;
    
    /**
     * 获取
     * 
     * @return 
     */
    public Long getId() {
        return this.id;
    }
     
    /**
     * 设置
     * 
     * @param id
     *          
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public String getUser() {
        return this.user;
    }
     
    /**
     * 设置
     * 
     * @param user
     *          
     */
    public void setUser(String user) {
        this.user = user;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public String getPassword() {
        return this.password;
    }
     
    /**
     * 设置
     * 
     * @param password
     *          
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String toString(){
    	StringBuffer sb=new StringBuffer();
    	sb.append("{");
    	sb.append("id:"+this.getId()+",");
    	sb.append("user:"+this.getUser());
    	return sb.toString();
    }
}