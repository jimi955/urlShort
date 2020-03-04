package com.xiaoxin.urlshorter.controller;


import com.xiaoxin.urlshorter.entity.UrlShort;
import com.xiaoxin.urlshorter.repository.UrlShortRepository;
import com.xiaoxin.urlshorter.utils.IdWorker;
import com.xiaoxin.urlshorter.utils.NumericConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UrlShorterController {

    @Autowired
    IdWorker idWorker;

    @Autowired
    UrlShortRepository urlShortRepository;

    @RequestMapping("/create/shorter")
    public String getShorterUrl(@RequestParam("url") String url, HttpServletRequest request) {
        if (url == null) {
            return "No Param url";
        }
        System.out.println(url);

        String host = "http://" + request.getServerName() + ":" + request.getServerPort() + "/";
        // 1：判断该链接是否存在
        UrlShort urlShort = urlShortRepository.findByLonger(url);
        if (urlShort != null) {
            System.out.println("链接已存在--");
            return host + urlShort.getShorter();
        }

        // 2:如果不存在 生成短链接
        System.out.println("链接不存在,开始转换链接--");
        long id = idWorker.nextId();
        String sid = NumericConvertUtils.toOtherNumberSystem(id, 62);
        String shortUrl = host + sid;
        UrlShort newUrlShort = new UrlShort();
        newUrlShort.setNumber(id);
        newUrlShort.setLonger(url);
        newUrlShort.setShorter(sid);
        urlShortRepository.save(newUrlShort);
        System.out.println(shortUrl);
        return shortUrl;
    }

    @RequestMapping("/{sid}")
    public String getResponse(@PathVariable("sid") String sid, HttpServletResponse response) throws IOException {
        UrlShort urlShort = urlShortRepository.findByShorter(sid);
        if (urlShort == null) {
            return "该短链接不存在---";
        }
        response.sendRedirect(urlShort.getLonger());
        return "";
//        return "redirect:" + urlShort.getLonger();
    }
}
