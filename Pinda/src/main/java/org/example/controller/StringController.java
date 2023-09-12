package org.example.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;



@RestController
@Controller
@RequestMapping("/api")
public class StringController {
    @CrossOrigin(origins = "127.0.0.1:80")


    @PostMapping("/receiveString")
    public ResponseEntity<String> receiveString(@RequestBody String receivedString) {
        // 在这里你可以处理receivedString，例如将它存储到数据库或执行其他逻辑
        // 以下示例只是简单地返回一个响应
        System.out.print(receivedString);
        return ResponseEntity.ok("Received string: " + receivedString);
    }
}
