package com.example.icemanagement.controller.admin;
import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.common.result.Result;
import com.example.icemanagement.pojo.dto.EquipmentDTO;
import com.example.icemanagement.pojo.dto.EquipmentPageQueryDTO;
import com.example.icemanagement.pojo.entity.Equipment;
import com.example.icemanagement.pojo.entity.User;
import com.example.icemanagement.service.EquipmentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 设备管理
 */
@RestController
@Slf4j
@RequestMapping("/admin")
@Tag(name = "管理端")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    /**
     * 器材查询
     * @return
     */
    @Operation(summary = "器材查询")
    @GetMapping("/page")
    //TODO 待完成 -- 分页
    public Result<PageResult> page(EquipmentPageQueryDTO equipmentPageQueryDTO) {
        log.info("器材查询");
        PageResult pageResult = equipmentService.pageQuery(equipmentPageQueryDTO);
        return Result.success(pageResult);
    }

    @Operation(summary = "新增器材")
    @PostMapping("")
    public Result<Object> insert(@RequestBody EquipmentDTO equipmentDTO) {
        equipmentService.insert(equipmentDTO);
        return Result.success();
    }
}
