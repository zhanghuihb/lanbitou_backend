package com.burton.common.wx;

import com.alibaba.fastjson.util.Base64;
import com.burton.common.base.Constant;
import com.burton.common.wx.login.WXSession;
import com.burton.common.wx.login.WXUserInfo;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;

/**
 * @author Tainy
 * @date 2018/6/11 16:00
 */
public class WXUtil {

    private static Logger LOGGER = LoggerFactory.getLogger(WXUtil.class);

    /**
     * 获取微信登陆授权session信息
     *
     * @param appId
     * @param secret
     * @param code
     * @return
     */
    public static WXSession getSession(String appId, String secret, String code) {
        WXSession session = null;
        String requestUrl = String.format(Constant.WX_AUTHORIZATION_PATH, appId, secret, code);
        try {
            session = new ObjectMapper().readValue(HttpClientUtil.getGetResponseWithHttpClient(requestUrl, "UTf-8"),
                    new TypeReference<WXSession>() {
                    });
        } catch (IOException e) {
            LOGGER.error("解析微信用户登录session信息失败", e);
        }

        return session;
    }

    /**
     * 获取用户信息
     *
     * @author Tainy
     * @date   2018/6/11 19:03
     */
    public static WXUserInfo getWxUserInfo(String accessToken, String openId) {
        String json = HttpClientUtil.getGetResponseWithHttpClient(String.format(Constant.WX_AUTHORIZE_USERINFO_URL,accessToken, openId), "UTf-8");
        LOGGER.info("getWxUserInfo:" + json);
        return (WXUserInfo) JsonUtil.fromJson(json, WXUserInfo.class);
    }

    /**
     * 未关注微信公众平台用户信息
     *
     * @author Tainy
     * @date   2018/6/12 15:08
     */
    public static WXUserInfo getWXUserInfo(String encryptedData, String sessionKey, String iv){
        if(StringUtils.isAnyEmpty(encryptedData, sessionKey, iv)){
            return null;
        }

        AES aes = new AES();
        byte[] resultByte;
        try {
            resultByte = aes.decrypt(Base64.decodeFast(encryptedData), Base64.decodeFast(sessionKey), Base64.decodeFast(iv));
            if(null != resultByte && resultByte.length > 0){
                String userInfo = new String(WxPKCS7Encoder.decode(resultByte));
                WXUserInfo wxInfo = JsonUtil.fromJson(userInfo, WXUserInfo.class);

                return wxInfo;
            }
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }

        return null;
    }
}
