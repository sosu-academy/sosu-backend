package com.academy.sosu.zhello;

import com.academy.sosu.model.base.ResponseList;
import com.academy.sosu.model.base.ResponseObject;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "/find-obj-no-meta", method = RequestMethod.GET, params = {"status"})
    public ResponseObject<Hello> findObjNoMeta(String status) {
        Hello h = new Hello("민진", status);
        return new ResponseObject<>(h);
    }

    @RequestMapping(value = "/find-obj-with-meta", method = RequestMethod.GET, params = {"status"})
    public ResponseObject<Hello> findObjWithMeta(String status) {
        Hello h = new Hello("민진", status);
        HelloMeta hm = new HelloMeta(10);
        return new ResponseObject<>(h, hm);
    }

    @RequestMapping(value = "/find-list-no-meta", method = RequestMethod.GET, params = {"status"})
    public ResponseList<Hello> findListNoMeta(String status) {
        Hello h = new Hello("민진", status);
        List<Hello> helloList = new ArrayList<>();
        helloList.add(h);

        return new ResponseList<>(helloList);
    }

    @RequestMapping(value = "/find-list-with-meta", method = RequestMethod.GET, params = {"status"})
    public ResponseList<Hello> findListWithMeta(String status) {
        Hello h = new Hello("민진", status);
        HelloMeta hm = new HelloMeta(10);

        List<Hello> helloList = new ArrayList<>();
        helloList.add(h);

        ResponseList<Hello> responseList = new ResponseList<>(helloList, hm);
        return new ResponseList<>(helloList, hm);
    }
}
