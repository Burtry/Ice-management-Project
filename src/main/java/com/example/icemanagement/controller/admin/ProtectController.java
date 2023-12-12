package com.example.icemanagement.controller.admin;

import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.common.result.Result;
import com.example.icemanagement.pojo.dto.EquipmentRecordsPageQueryDTO;
import com.example.icemanagement.pojo.dto.MaintenanceRecordDTO;
import com.example.icemanagement.service.ProtectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 器材维护管理
 */
@RestController
@Slf4j
@RequestMapping("/admin/protect")
@Tag(name = "管理端")
public class ProtectController {

    @Autowired
    private ProtectService protectService;

    /**
     * 新增器材维护计划
     *
     * @return
     */
    @Operation(summary = "新增维护计划")
    @PostMapping()
    public Result insert(@RequestBody MaintenanceRecordDTO maintenanceRecordDTO) {
        log.info("新增器材维护计划");
        protectService.insert(maintenanceRecordDTO);
        return Result.success();
    }

    /**
     * 维护计划分页查看
     */
    @GetMapping("/page")
    @Operation(summary = "分页查询维护计划")
    public Result<PageResult> page(EquipmentRecordsPageQueryDTO equipmentRecordsPageQueryDTO) {
        log.info("分页查看维护计划");
        PageResult pageResult = protectService.page(equipmentRecordsPageQueryDTO);

        return Result.success(pageResult);
    }

    /**
     * 修改维护计划
     *
     * @param maintenanceRecordDTO
     * @return
     */
    @Operation(summary = "修改维护计划")
    @PutMapping()
    public Result update(@RequestBody MaintenanceRecordDTO maintenanceRecordDTO) {
        log.info("修改维护计划");
        protectService.update(maintenanceRecordDTO);
        return Result.success();
    }

    /**
     * 批量删除维护计划
     *
     * @param ids
     * @return
     */
    @Operation(summary = "批量删除维护计划")
    @DeleteMapping()
    public Result<Object> delete(@RequestParam List<Long> ids) {
        log.info("根据ids删除维护计划:{}", ids);
        protectService.delete(ids);
        return Result.success();

    }
}
