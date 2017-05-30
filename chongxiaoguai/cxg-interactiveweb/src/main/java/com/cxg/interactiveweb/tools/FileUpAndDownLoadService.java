package com.cxg.interactiveweb.tools;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;

/**
 * 文件上传下载工具类
 * @author zhangpeng
 *
 */
/**
 * @author zhangpeng
 *
 */
@Service
public class FileUpAndDownLoadService {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	/**
	 * 获取mongodb数据库文件操作对象
	 * @return
	 */
	private GridFS getGridFS(){
		DB db = mongoTemplate.getDb();
		GridFS gridFS= new GridFS(db,"fs");
		return gridFS;
	}
	
	/**
	 * 文件上传
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	public void upload(HttpServletRequest request,BigDecimal userId) throws IOException{
		GridFS gridFS= getGridFS();
		GridFSFile file = null;
		MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = mRequest.getFileMap();       
        Iterator<Map.Entry<String, MultipartFile>> it = fileMap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, MultipartFile> entry = it.next();
            MultipartFile mFile = entry.getValue();//获取文件
            file = gridFS.createFile(mFile.getInputStream());// 创建gridfs文件
			file.put("filename", mFile.getOriginalFilename());
			file.put("userId", userId.toString());
			file.put("uploadDate", new Date());
			file.put("contentType",mFile.getContentType());
			file.save();
           
        }
	}
	
	/**
	 * 查看文件
	 * @param params k-v 搜索条件 
	 * @return
	 */
	public List<GridFSDBFile> viewFiles(Map<String,String> params){
		GridFS gridFS= getGridFS();
		BasicDBObject basicDBObject = new BasicDBObject();
		for(Map.Entry<String, String> entry:params.entrySet()){
			String key= entry.getKey();
			String value=entry.getValue();
			basicDBObject.append(key, value);
		}
		List<GridFSDBFile> list = gridFS.find(basicDBObject);
		return list;
	}
	
	/**
	 * 文件查看与下载
	 * @param id 文件唯一标示id
	 * @param response
	 * @throws IOException
	 */
	public void downLoad(String id,HttpServletResponse response) throws IOException{
		GridFS gridFS= getGridFS();
		ObjectId objId = new ObjectId(id);
		GridFSDBFile gridFSDBFile =(GridFSDBFile)gridFS.findOne(objId);
		
		if (gridFSDBFile != null) {

			OutputStream sos = response.getOutputStream();

			response.setContentType("application/octet-stream");
			// 获取原文件名
			String name = (String) gridFSDBFile.get("filename");
			String fileName = new String(name.getBytes("utf-8"), "ISO8859-1");

			// 设置下载文件名
			response.addHeader("Content-Disposition", "attachment; filename=\""
					+ fileName + "\"");

			// 向客户端输出文件
			gridFSDBFile.writeTo(sos);
			sos.flush();
			sos.close();
		}
	}
	
	/**
	 * 单文件删除
	 * @param id 文件唯一标识
	 * @return
	 */
	public String delete(String id){
		GridFS gridFS= getGridFS();
		ObjectId objId = new ObjectId(id);
		gridFS.remove(objId);
		return "success";
	}
	
}
