package org.crazyit.activiti.rest;

import org.apache.cxf.common.util.Base64Utility;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;

import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;

/**
 * @Author: xyy
 * @Date: 2019/12/24 9:35
 */
public class TestDeployment {
    public static void main(String[] args) throws Exception{
        // 创建 WebClient, 设置 URL、认证用户名和密码
        WebClient client = WebClient.create("http://localhost:8086" +
                "/activiti-rest/service/repository/deployments", "xyy",
                "123456", null);
        // 设置认证格式为基础认证格式
        String authorizationHeader = "Basic " + Base64Utility.encode(
                "user:password".getBytes());
        client.header("Authorization", authorizationHeader);
        // 设置内容类型
        client.type("multipart/form-data");
        // 获取上传文件
        String path = TestDeployment.class.getResource("/").toString();
        File file = new File(new URI(path
                + "bpmn/DeploymentUpload.bpmn20.xml"));
        // 一定要 name 属性
        ContentDisposition cd = new ContentDisposition("form-data; " +
                "name=deployment; filename=DeploymentUpload.bpmn20.xml");
        Attachment attachment = new Attachment(null,
                new FileInputStream(file), cd);
        // 获取响应，使用 POS 方法
        Response response = client.post(new MultipartBody(attachment));
        // 获取响应内容
        InputStream ent = (InputStream) response.getEntity();
        String content = IOUtils.readStringFromStream(ent);
        // 输出字符串
        System.out.println(content);

        /*------------  部署数据查询  -------------*/
        client = WebClient.create("http://localhost:8086" +
                        "/activiti-rest/service/repository/deployments?sort" +
                        "=name&nameLike=%processes", "xyy",
                "123456", null);
        client.header("Authorization", authorizationHeader);
        response = client.get();
        ent = (InputStream) response.getEntity();
        content = IOUtils.readStringFromStream(ent);
        System.out.println(content);
    }
}
