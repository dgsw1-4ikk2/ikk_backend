package com.example.ikk2Timmer.global.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class CommonController {
    @GetMapping("error/errorCommon")
    public void handleCommonError() {
        log.info("errorCommon");
    }

    @GetMapping("error/accessErroer")
    public void accdssDenied(Authentication authentication, Model model) {
        log.info(String.valueOf(authentication));

        model.addAttribute("msg","AccessDenied");
    }
}
