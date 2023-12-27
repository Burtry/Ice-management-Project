package com.example.icemanagement.controller.user;

import com.example.icemanagement.common.result.Result;
import com.example.icemanagement.pojo.dto.LeaseRecordsDTO;
import com.example.icemanagement.pojo.vo.LeaseRecordsVO;
import com.example.icemanagement.service.LeaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户端借还
 */
@RestController
@Slf4j
@RequestMapping("/user/lease")
@Tag(name = "用户端")
@Controller("userLeaseController")
public class LeaseController {

    @Autowired
    private LeaseService leaseService;

    /**
     * 根据用户id查看该用户租借记录
     * @return
     */
    @GetMapping("/list")
    @Operation(summary = "用户查看租借记录")
    public Result<List<LeaseRecordsVO>> listLeaseRecords(Long userId) {
        List<LeaseRecordsVO> list =  leaseService.getByUserId(userId);
        return Result.success(list);
    }


    /**
     * 创建租借信息
     * @param leaseRecordsDTO
     * @return
     */
    @PostMapping("/createLease")
    @Operation(summary = "创建租借信息")
    public Result createLease(@RequestBody LeaseRecordsDTO leaseRecordsDTO) {
        log.info("创建租借:{}",leaseRecordsDTO);
        leaseService.createLease(leaseRecordsDTO);
        return Result.success();
    }

    /**
     * 取消租借
     * @param id 租借id
     * @return
     */
    @PutMapping("/cancel/{id}")
    @Operation(summary = "用户取消租借")
    public Result cancel(@PathVariable Long id) {
        log.info("用户取消租借id:{}",id);
        leaseService.cancel(id);
        return Result.success();
    }



}
