package org.csource.fastdfs;

import java.io.FileOutputStream;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.csource.common.NameValuePair;

public class TestThread  implements Runnable{
	/*String group=null;
	 String fileName=null;
	 StorageClient storageClient=null;
	 StorageServer storageServer = null;  */
	 /*  public void setGroup(String group) {
		this.group = group;
	  }

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setStorageClient(StorageClient storageClient) {
		this.storageClient = storageClient;
	}
*/
		@Override
	    public void run() {
	        try {
	            System.out.println(Thread.currentThread().getName());
	            ClientGlobal.init("F:/Workspaces/fastdfs/src/test/resources/fdfs_client.conf");
				 // 创建一个TrackerClient对象
	            TrackerClient tracker = new TrackerClient(); 
	            // 创建一个TrackerServer对象。
	            TrackerServer trackerServer = tracker.getConnection(); 
	            StorageServer storageServer = null;
	            // 获得StorageClient对象
	            StorageClient storageClient = new StorageClient(trackerServer, storageServer); 
	         
	           NameValuePair nvp [] = new NameValuePair[]{ 
	                    new NameValuePair("age", "18"), 
	                    new NameValuePair("sex", "male") 
	            }; 
	         // 直接调用StorageClient对象方法上传文件即可。
	          /*String[]  strings;
	             strings = storageClient.upload_file("D:\\image2.jpg", "jpg", nvp);
	            for (String string : strings) {
	                System.out.println(string);
	            } */
	           
	           
	           byte[] b = storageClient.download_file("group2", "M00/00/01/rBACvlkkgrWAG7D3AACZqHfOheI900.jpg"); 
	           // 将下载的文件流保存
	           IOUtils.write(b, new FileOutputStream("D:/"+UUID.randomUUID().toString()+".jpg"));
	        
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
