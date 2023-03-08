package com.academy.sosu.hello;

import com.academy.sosu.Hello;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "나의 꿈은 서버개발자였어...")
@RequestMapping("/api")
public class HelloController {

    @RequestMapping(value = "/find", method = RequestMethod.GET, params = {"status"})
    public Hello findPetsByStatus(String status) {
        return new Hello("민진", status);
    }

    @RequestMapping(value = "operation2", method = RequestMethod.POST)
    public ResponseEntity<String> operation2() {
        return ResponseEntity.ok("example");
    }
}
