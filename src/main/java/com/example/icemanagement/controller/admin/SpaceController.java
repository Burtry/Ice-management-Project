package com.example.icemanagement.controller.admin;

import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.common.result.Result;
import com.example.icemanagement.pojo.dto.EquipmentPageQueryDTO;
import com.example.icemanagement.pojo.dto.SpaceDTO;
import com.example.icemanagement.pojo.dto.SpacePageQueryDTO;
import com.example.icemanagement.pojo.entity.Space;
import com.example.icemanagement.service.SpaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 场地管理
 */
@RestController
@Slf4j
@RequestMapping("/admin/space")
@Tag(name = "管理端")
public class SpaceController {

    @Autowired
    private SpaceService spaceService;

    /**
     * 新增场地
     * @param spaceDTO
     * @return
     */
    @Operation(summary = "新增场地")
    @PostMapping()
    public Result insert(@RequestBody SpaceDTO spaceDTO) {
        log.info("新增场地:{}", spaceDTO);
        spaceService.insert(spaceDTO);
        return Result.success();

    }

    @Operation(summary = "场地查询")
    @GetMapping("/page")
    public Result<PageResult> page(SpacePageQueryDTO spacePageQueryDTO) {
        log.info("场地查询:{}", spacePageQueryDTO);
        PageResult pageResult = spaceService.pageQuery(spacePageQueryDTO);
        return Result.success(pageResult);
    }










}
