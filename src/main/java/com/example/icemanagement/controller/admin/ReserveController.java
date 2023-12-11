package com.example.icemanagement.controller.admin;

import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.common.result.Result;
import com.example.icemanagement.pojo.dto.EquipmentRecordsPageQueryDTO;
import com.example.icemanagement.service.ReserveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 租借管理
 */
@RestController
@Slf4j
@RequestMapping("/admin/reserve")
@Tag(name = "管理端")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    /**
     * 分页查看器材租借记录
     * @param equipmentRecordsPageQueryDTO
     * @return
     */
    @Operation(summary = "器材租借记录查询")
    @GetMapping("/page")
    public Result<PageResult> page(EquipmentRecordsPageQueryDTO equipmentRecordsPageQueryDTO) {
        log.info("查看租借记录:{}", equipmentRecordsPageQueryDTO);
        PageResult pageResult = reserveService.page(equipmentRecordsPageQueryDTO);
        return Result.success(pageResult);
    }
}
