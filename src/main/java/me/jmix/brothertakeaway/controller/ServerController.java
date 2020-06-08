package me.jmix.brothertakeaway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JellyfishMIX
 * @date 2020/6/5 10:47 下午
 */
@RestController
@RequestMapping("/server")
public class ServerController {
    @GetMapping("/message")
    public String message() {
        return "this is product message";
    }
}
