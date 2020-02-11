package org.csource.fastdfs.test;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.net.InetSocketAddress;

public class Test1 {
  public static void main(String args[]) {
    try {
      ClientGlobal.init("F:/Workspaces/fastdfs/src/test/resources/fdfs_client.conf");
      System.out.println("network_timeout=" + ClientGlobal.g_network_timeout + "ms");
      System.out.println("charset=" + ClientGlobal.g_charset);

      TrackerGroup tg = new TrackerGroup(new InetSocketAddress[]{new InetSocketAddress("172.16.2.190", 8080)});
      TrackerClient tc = new TrackerClient(tg);

      TrackerServer ts = tc.getConnection();
      if (ts == null) {
        System.out.println("getConnection return null");
        return;
      }

      StorageServer ss = tc.getStoreStorage(ts);
      if (ss == null) {
        System.out.println("getStoreStorage return null");
      }

      StorageClient1 sc1 = new StorageClient1(ts, ss);

      NameValuePair[] meta_list = null;  //new NameValuePair[0];
      String item;
      String fileid;
      if (System.getProperty("os.name").equalsIgnoreCase("windows")) {
        item = "c:/windows/system32/notepad.exe";
        fileid = sc1.upload_file1(item, "exe", meta_list);
      } else {
        item = "/etc/hosts";
        fileid = sc1.upload_file1(item, "", meta_list);
      }

      System.out.println("Upload local file " + item + " ok, fileid=" + fileid);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
