package com.example.icemanagement.controller.user;

import com.example.icemanagement.common.result.Result;
import com.example.icemanagement.pojo.dto.SpaceDiscussDTO;
import com.example.icemanagement.pojo.entity.DiscussBySpace;
import com.example.icemanagement.service.DiscussService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @return
     */
    @PostMapping("/add")
    @Operation(summary = "用户新增场地评论")
    public Result discussBySpace(@RequestBody SpaceDiscussDTO spaceDiscussDTO) {
        log.info("用户新增场地反馈{}",spaceDiscussDTO);
        discussService.createSpaceDiscuss(spaceDiscussDTO);
        return Result.success();
    }




}
