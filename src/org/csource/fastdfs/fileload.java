package org.csource.fastdfs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;

public class fileload {
	// 声明一个StorageServer对象，
    static StorageServer storageServer = null;
    static StorageClient storageClient=null;
	public static void main(String[] args) {
		   try {
			/*ClientGlobal.init("F:/Workspaces/fastdfs/src/test/resources/fdfs_client.conf");
			 // 创建一个TrackerClient对象
            TrackerClient tracker = new TrackerClient(); 
            // 创建一个TrackerServer对象。
            TrackerServer trackerServer = tracker.getConnection(); 
            
            // 获得StorageClient对象
            storageClient = new StorageClient(trackerServer, storageServer); 
         
           NameValuePair nvp [] = new NameValuePair[]{ 
                    new NameValuePair("age", "18"), 
                    new NameValuePair("sex", "male") 
            }; 
         // 直接调用StorageClient对象方法上传文件即可。
          String[]  strings;
             strings = storageClient.upload_file("D:\\image2.jpg", "jpg", nvp);
            for (String string : strings) {
                System.out.println(string);
            } */
            TestThread thread=new TestThread();
           // thread.setStorageClient(storageClient);
            //thread.setGroup(strings[0]);
            //thread.setFileName(strings[1]);
           for(int i=0;i<100;i++){
        	   new Thread(thread).start();
           }
         /*   NameValuePair nvps [] = storageClient.get_metadata("group2", "M00/00/00/rBACvlkkT5qAAr8mAACZqHfOheI949.jpg"); 
            for(NameValuePair nvp : nvps){ 
                System.out.println(nvp.getName() + ":" + nvp.getValue()); 
            } */
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}  
		   
		   
		   
	}
    
	public void fileInfo() throws IOException, MyException{
		 //文件信息
          FileInfo fi = storageClient.get_file_info("group2", "M00/00/00/rBACvlkkRjyAaKABAACZqHfOheI562.jpg");
         System.out.println(fi.getSourceIpAddr()); 
         System.out.println(fi.getFileSize()); 
         System.out.println(fi.getCreateTimestamp()); 
         System.out.println(fi.getCrc32());  
	}
	
	public static void fileDelete(){
	
		 // int i = storageClient.delete_file("group1", "M00/00/00/wKgRcFV_08OAK_KCAAAA5fm_sy874.conf"); 
	}
	
	public void fileDownLoad() throws IOException, MyException{
		byte[] b = storageClient.download_file("group2", "M00/00/00/rBACvlkkRjyAaKABAACZqHfOheI562.jpg"); 
        // 将下载的文件流保存
        IOUtils.write(b, new FileOutputStream("D:/"+UUID.randomUUID().toString()+".jpg"));
       
	}
}
 