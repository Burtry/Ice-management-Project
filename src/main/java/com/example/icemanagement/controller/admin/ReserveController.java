package com.example.icemanagement.controller.admin;

import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.common.result.Result;
import com.example.icemanagement.pojo.dto.EquipmentRecordsPageQueryDTO;
import com.example.icemanagement.pojo.entity.ReserveRecords;
import com.example.icemanagement.service.ReserveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 器材租借管理
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
    @Operation(summary = "分页查询器材租借记录")
    @GetMapping("/page")
    public Result<PageResult> page(EquipmentRecordsPageQueryDTO equipmentRecordsPageQueryDTO) {
        log.info("查看租借记录:{}", equipmentRecordsPageQueryDTO);
        PageResult pageResult = reserveService.page(equipmentRecordsPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 根据id查询此条租借记录
     * @param id
     * @return
     */
    @Operation(summary = "根基id查询租借记录")
    @GetMapping("/{id}")
    public Result<ReserveRecords> getById(@PathVariable Long id) {
        ReserveRecords reserveRecord =reserveService.getById(id);
        return Result.success(reserveRecord);
    }


    /**
     * 器材租借状态修改 1 同意租借 ；0 取消租借
     * @param status 租借状态
     * @return
     */
    @Operation(summary = "修改租借记录中租借状态")
    @PutMapping("/status/{status}/{id}")
    public Result updateByStatus(@PathVariable Integer status, @PathVariable Long id) {
        log.info("器材租借状态修改:{},id{}",status,id);
        reserveService.updateByStatus(status,id);
        return Result.success();
    }

}
