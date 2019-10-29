package com.lvmen.community.provider;

import com.alibaba.fastjson.JSON;
import com.lvmen.community.dto.AccessTokenDTO;
import com.lvmen.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Users are redirected back to your site by GitHub
 * Created by lvmen on 2019/10/29
 */
@Component
public class GithubProvider {

    /**
     *
     * @param accessTokenDTO
     * @return
     */
    public String getAccessToken(AccessTokenDTO accessTokenDTO){

        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build(); // 发送post请求
        try (Response response = client.newCall(request).execute()) {
            String result = response.body().string(); // access_token=6eda49418b69e89dc9c2bc95d13e46d7542d0404&scope=user&token_type=bearer
            String[] split = result.split("&");
            String tokenStr = split[0];
            String token = tokenStr.split("=")[1];
            return token;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param accessToken
     * @return
     */
    public GithubUser getUser(String accessToken){

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String result = response.body().string(); // string() 方法是获取返回过来的body中的内容。
            GithubUser githubUser = JSON.parseObject(result, GithubUser.class); // 将json字符串反序列化为对象
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }







}
