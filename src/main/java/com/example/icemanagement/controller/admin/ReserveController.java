package com.example.icemanagement.controller.admin;

import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.common.result.Result;
import com.example.icemanagement.pojo.dto.RecordsPageQueryDTO;
import com.example.icemanagement.pojo.entity.LeaseRecords;
import com.example.icemanagement.pojo.entity.ReserveRecords;
import com.example.icemanagement.service.ReserveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 场地预约管理
 */
@Slf4j
@RestController
@RequestMapping("/admin/reserve")
@Tag(name = "管理端")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;


    @Operation(summary = "分页查询场地预约记录")
    @GetMapping("/page")
    public Result<PageResult> page(RecordsPageQueryDTO recordsPageQueryDTO) {
        log.info("查看预约记录:{}", recordsPageQueryDTO);
        PageResult pageResult = reserveService.page(recordsPageQueryDTO);
        return Result.success(pageResult);
    }

    @Operation(summary = "根据id查询预约记录")
    @GetMapping("/{id}")
    public Result<ReserveRecords> getById(@PathVariable Long id) {
        log.info("根据id查询预约记录:{}",id);
        ReserveRecords reserveRecords = reserveService.getById(id);
        return Result.success(reserveRecords);
    }

    /**
     * 场地预约状态修改 1 agree ；0 cancel
     * @param status 租借状态
     * @return
     */
    @Operation(summary = "修改预约记录中预约状态")
    @PutMapping("/status/{status}/{id}")
    public Result updateByStatus(@PathVariable Integer status, @PathVariable Long id) {
        log.info("场地预约状态修改:{},id{}",status,id);
        reserveService.updateByStatus(status,id);
        return Result.success();
    }



}
