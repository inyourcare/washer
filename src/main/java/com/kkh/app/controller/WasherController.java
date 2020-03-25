package com.kkh.app.controller;

import com.kkh.app.dto.ApiResponse;
import com.kkh.app.dto.request.washer.*;
import com.kkh.app.exception.ExpectableException;
import com.kkh.app.security.CurrentUser;
import com.kkh.app.security.CustomUserDetails;
import com.kkh.app.service.WasherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@Api(value = "Store", consumes = "application/json")
@RequestMapping("/v0/washer")
public class WasherController {
    @Autowired
    WasherService washerService;

    @ApiOperation(value = "create", response = Map.class)
    @RequestMapping(path = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@CurrentUser CustomUserDetails user, @Valid @RequestBody WasherCreateRequest request) throws Exception {
        try {
            washerService.create(user,request);
        } catch (ExpectableException e) {
            return ResponseEntity.ok().body(ApiResponse.builder().success(false).message(e.getMessage()).build());
        }
        return ResponseEntity.ok().body(ApiResponse.builder().success(true).build());
    }

    @ApiOperation(value = "update", response = Map.class)
    @RequestMapping(path = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@CurrentUser CustomUserDetails user, @Valid @RequestBody WasherUpdateRequest request) throws Exception {
        try {
            washerService.update(user,request);
        } catch (ExpectableException e) {
            return ResponseEntity.ok().body(ApiResponse.builder().success(false).message(e.getMessage()).build());
        }
        return ResponseEntity.ok().body(ApiResponse.builder().success(true).build());
    }

    @ApiOperation(value = "readList", response = Map.class)
    @RequestMapping(path = "/readList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity readList(@CurrentUser CustomUserDetails user, @Valid @RequestBody WasherReadListRequest request) throws Exception {
        try {
            washerService.readList(user,request);
        } catch (ExpectableException e) {
            return ResponseEntity.ok().body(ApiResponse.builder().success(false).message(e.getMessage()).build());
        }
        return ResponseEntity.ok().body(ApiResponse.builder().success(true).build());
    }

    @ApiOperation(value = "readDetails", response = Map.class)
    @RequestMapping(path = "/readDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity readDetails(@CurrentUser CustomUserDetails user, @Valid @RequestBody WasherReadDetailsRequest request) throws Exception {
        try {
            washerService.readDetails(user,request);
        } catch (ExpectableException e) {
            return ResponseEntity.ok().body(ApiResponse.builder().success(false).message(e.getMessage()).build());
        }
        return ResponseEntity.ok().body(ApiResponse.builder().success(true).build());
    }

    @ApiOperation(value = "delete", response = Map.class)
    @RequestMapping(path = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@CurrentUser CustomUserDetails user, @Valid @RequestBody WasherDeleteRequest request) throws Exception {
        try {
            washerService.delete(user,request);
        } catch (ExpectableException e) {
            return ResponseEntity.ok().body(ApiResponse.builder().success(false).message(e.getMessage()).build());
        }
        return ResponseEntity.ok().body(ApiResponse.builder().success(true).build());
    }

    @ApiOperation(value = "setAvailable", response = Map.class)
    @RequestMapping(path = "/setAvailable", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity setAvailable(@CurrentUser CustomUserDetails user, @Valid @RequestBody WasherSetAvailableRequest request) throws Exception {
        try {
            washerService.setAvailable(user,request);
        } catch (ExpectableException e) {
            return ResponseEntity.ok().body(ApiResponse.builder().success(false).message(e.getMessage()).build());
        }
        return ResponseEntity.ok().body(ApiResponse.builder().success(true).build());
    }
}
