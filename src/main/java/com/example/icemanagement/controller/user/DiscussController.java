package com.example.icemanagement.controller.user;

import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.common.result.Result;
import com.example.icemanagement.pojo.dto.EquipmentDiscussDTO;
import com.example.icemanagement.pojo.dto.PageQueryDTO;
import com.example.icemanagement.pojo.dto.SpaceDiscussDTO;
import com.example.icemanagement.pojo.entity.DiscussBySpace;
import com.example.icemanagement.pojo.vo.SpaceDiscussVO;
import com.example.icemanagement.service.DiscussService;
import com.github.pagehelper.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户端评论
 */
@RestController
@RequestMapping("/user/discuss")
@Slf4j
@Tag(name = "用户端")
public class DiscussController {

    @Autowired
    private DiscussService discussService;


    /**
     * 用户增加场地反馈
     *
     * @return
     */
    @PostMapping("/addSpaceDiscuss")
    @Operation(summary = "用户新增场地评论")
    public Result discussBySpace(@RequestBody SpaceDiscussDTO spaceDiscussDTO) {
        log.info("用户新增场地反馈{}", spaceDiscussDTO);
        discussService.createSpaceDiscuss(spaceDiscussDTO);
        return Result.success();
    }

    /**
     * 分页查看场地评论
     *
     * @param pageQueryDTO
     * @return
     */
    @GetMapping("/listSpaceDiscuss")
    @Operation(summary = "分页查看场地评论")
    public Result<PageResult> listSpaceDiscuss(PageQueryDTO pageQueryDTO) {
        log.info("分页查看场地评论:{}", pageQueryDTO);
        PageResult pageResult = discussService.listSpaceDiscuss(pageQueryDTO);
        return Result.success(pageResult);
    }


    /**
     * 用户增加器材评论
     *
     * @param equipmentDiscussDTO
     * @return
     */
    @PostMapping("/addEquipmentDiscuss")
    @Operation(summary = "用户新增器材评论")
    public Result discussByEquipment(@RequestBody EquipmentDiscussDTO equipmentDiscussDTO) {
        log.info("用户新增器材反馈{}", equipmentDiscussDTO);
        discussService.createEquipmentDiscuss(equipmentDiscussDTO);
        return Result.success();
    }

    /**
     * 分页查看器材评论
     * @param pageQueryDTO
     * @return
     */
    @GetMapping("/listEquipmentDiscuss")
    @Operation(summary = "分页查看器材评论")
    public Result<PageResult> listEquipmentDiscuss(PageQueryDTO pageQueryDTO) {
        log.info("分页查看器材评论:{}", pageQueryDTO);
        PageResult pageResult = discussService.listEquipmentDiscuss(pageQueryDTO);
        return Result.success(pageResult);

    }
}
