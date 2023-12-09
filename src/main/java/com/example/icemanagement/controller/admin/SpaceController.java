package com.example.icemanagement.controller.admin;

import com.example.icemanagement.common.result.Result;
import com.example.icemanagement.pojo.dto.SpaceDTO;
import com.example.icemanagement.pojo.entity.Space;
import com.example.icemanagement.service.SpaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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










}
