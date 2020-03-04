package com.xiaoxin.urlshorter.controller;

import com.xiaoxin.urlshorter.utils.QrCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
@Controller
@RequestMapping("/qrcode")
public class CreateCodeController {
    /**
     * 二维码
     */
    @RequestMapping("/create")
    public void qrcode(@RequestParam("url") String url, HttpServletResponse response) throws IOException {
        if (url == null || url.equals("")) {
            response.getWriter().write("Param url is Empty ---");
        }
        try {
            OutputStream os = response.getOutputStream();
            QrCodeUtils.encode(url, "", os, true);
//            QrCodeUtils.encode(requestUrl, "/static/images/logo.png", os, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}