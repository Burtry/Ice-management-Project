package com.example.icemanagement.controller.admin;
import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.common.result.Result;
import com.example.icemanagement.pojo.dto.EquipmentDTO;
import com.example.icemanagement.pojo.dto.EquipmentPageQueryDTO;
import com.example.icemanagement.pojo.dto.EquipmentPageQueryDTOByType;
import com.example.icemanagement.pojo.entity.Equipment;
import com.example.icemanagement.pojo.entity.User;
import com.example.icemanagement.service.EquipmentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 设备管理
 */
@RestController
@Slf4j
@RequestMapping("/admin/equipment")
@Tag(name = "管理端")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    /**
     * 分页器材查询
     * @return
     */
    @Operation(summary = "分页器材查询")
    @GetMapping("/page")
    public Result<PageResult> page(EquipmentPageQueryDTO equipmentPageQueryDTO) {
        log.info("器材查询:{}", equipmentPageQueryDTO);
        PageResult pageResult = equipmentService.pageQuery(equipmentPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 根据类型查询器材
     * @param type
     * @return
     */
    @Operation(summary = "分页查询器材根据类型")
    @GetMapping("/pageByType")
    public Result<PageResult> pageByType(EquipmentPageQueryDTOByType type) {
        log.info("根据类型查询器材:{}", type);
        PageResult pageResult = equipmentService.pageByType(type);
        return Result.success(pageResult);
    }

    /**
     * 根据id查询器材
     * @param id
     * @return
     */
    @Operation(summary = "根据id查询器材")
    @GetMapping("/{id}")
    public Result<Equipment> pageByType(@PathVariable Long id) {
        log.info("根据id查询器材(用于回显数据):{}", id);
        Equipment equipment = equipmentService.getById(id);
        return Result.success(equipment);
    }

    /**
     * 修改器材
     * @param equipmentDTO
     */
    @PutMapping()
    @Operation(summary = "修改器材")
    public Result update(@RequestBody EquipmentDTO equipmentDTO) {
        log.info("修改器材:{}",equipmentDTO);
        equipmentService.update(equipmentDTO);
        return Result.success();
    }


    /**
     * 新增器材
     * @param equipmentDTO
     * @return
     */
    @Operation(summary = "新增器材")
    @PostMapping()
    public Result<Object> insert(@RequestBody EquipmentDTO equipmentDTO) {
        log.info("新增器材:{}", equipmentDTO);
        equipmentService.insert(equipmentDTO);
        return Result.success();
    }

    /**
     * 批量删除器材
     * @param ids
     * @return
     */
    @Operation(summary = "批量删除器材")
    @DeleteMapping()
    public Result<Object> delete(@RequestParam List<Long> ids) {
        log.info("根据id删除器材:{}",ids);
        equipmentService.delete(ids);
        return Result.success();
    }

}
