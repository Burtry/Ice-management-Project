package com.example.icemanagement.controller.user;

import com.example.icemanagement.common.result.Result;
import com.example.icemanagement.pojo.dto.ReserveRecordsDTO;
import com.example.icemanagement.pojo.vo.ReserveRecordsVO;
import com.example.icemanagement.service.ReserveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    /**
     * 根据用户id查看用户预约
     * @return
     */
    @GetMapping("/list")
    @Operation(summary = "查看预约")
    public Result<List<ReserveRecordsVO>> listReserveRecords(Long id) {
        log.info("根据用户id查询用户预约:{}",id);
        List<ReserveRecordsVO> list = reserveService.list(id);
        return Result.success(list);
    }

    /**
     * 取消预约
     * @param id 预约id
     * @return
     */
    @PutMapping("/cancel/{id}")
    @Operation(summary = "取消预约")
    public Result cancel(@PathVariable Long id) {
        log.info("取消预约：{}",id);
        reserveService.cancel(id);
        return Result.success();
    }


}
