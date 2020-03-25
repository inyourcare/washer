package com.kkh.app.controller;

import com.kkh.app.dto.ApiResponse;
import com.kkh.app.jpa.entity.WasherEntity;
import com.kkh.app.jpa.repository.UserRepository;
import com.kkh.app.jpa.repository.WasherRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Api(value = "Test", consumes = "application/json")
@RequestMapping("/v0/test")
public class TestController {

    @Autowired
    WasherRepository washerRepository;

    @ApiOperation(value = "test1", response = Map.class)
    @RequestMapping(path = "/test1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create() throws Exception {
        List<WasherEntity> washerEntities = washerRepository.findAllByCreator_UserId(Long.parseLong("261585068629915"));
        return ResponseEntity.ok().body(ApiResponse.builder().success(true).build());
    }
}
