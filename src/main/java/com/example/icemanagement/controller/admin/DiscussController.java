package com.example.icemanagement.controller.admin;

import com.example.icemanagement.common.result.Result;
import com.example.icemanagement.service.DiscussService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/discuss")
@Controller("adminDiscussController")
@Tag(name = "管理端")
@Slf4j
public class DiscussController {

    @Autowired
    private DiscussService discussService;

    /**
     * 管理员根据评论id删除场地评论
     * @param id
     * @return
     */
    @DeleteMapping("/spaceDiscuss/{id}")
    @Operation(summary = "管理员根据id删除场地评论")
    public Result deleteSpaceDiscuss(@PathVariable Long id) {
        log.info("根据评论id删除该条场地评论:{}",id);
        discussService.deleteSpaceDiscussById(id);
        return Result.success();
    }

    @DeleteMapping("/equipment/{id}")
    @Operation(summary = "管理员根据id删除器材评论")
    public Result deleteEquipmentDiscuss(@PathVariable Long id) {
        log.info("根据评论id删除该条器材评论:{}",id);
        discussService.deleteEquipmentDiscussById(id);
        return Result.success();
    }
}
