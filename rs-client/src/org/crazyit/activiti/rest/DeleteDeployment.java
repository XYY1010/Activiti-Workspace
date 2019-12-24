package org.crazyit.activiti.rest;

import org.apache.cxf.common.util.Base64Utility;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.Response;
import java.io.InputStream;

/**
 * @Author: xyy
 * @Date: 2019/12/24 10:17
 */
public class DeleteDeployment {
    public static void main(String[] args) throws Exception {
        // 创建 webclient，设置 URL、认证用户名和密码
        WebClient client = WebClient.create("http://localhost:8086" +
                "/activiti-rest/service/repository/deployments/15040",
                "xyy", "123456", null);
        // 设置认证格式为基础认证格式
        String authorizationHeader = "Basic " + Base64Utility.encode(
                "user:password".getBytes());
        client.header("Authorization", authorizationHeader);
        // 获取响应
        Response response = client.delete();
        // 获取响应内容
        InputStream ent = (InputStream) response.getEntity();
        String content = IOUtils.readStringFromStream(ent);
        // 输出字符串
        System.out.println(content);
    }
}
