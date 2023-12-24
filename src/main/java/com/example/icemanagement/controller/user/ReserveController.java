package com.example.icemanagement.controller.user;

import com.example.icemanagement.common.result.Result;
import com.example.icemanagement.pojo.dto.ReserveRecordsDTO;
import com.example.icemanagement.service.ReserveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * 用户端预约
 */
@RestController
@RequestMapping("/user/reserve")
@Slf4j
@Tag(name = "用户端")
@Component("userReserveController")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    /**
     * 用户端创建预约
     * @param reserveRecordsDTO
     * @return
     */
    @PostMapping("/createReserve")
    @Operation(summary = "创建预约")
    public Result<ReserveRecordsDTO> createReservation(ReserveRecordsDTO reserveRecordsDTO) {
        log.info("用户端创建预约:{}",reserveRecordsDTO);
        reserveService.createReserve(reserveRecordsDTO);
        return Result.success();
    }
}
