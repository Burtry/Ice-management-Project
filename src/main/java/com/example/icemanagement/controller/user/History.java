package com.example.icemanagement.controller.user;

import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.common.result.Result;
import com.example.icemanagement.pojo.dto.HistoryPageQueryDTO;
import com.example.icemanagement.pojo.dto.RecordsPageQueryDTO;
import com.example.icemanagement.service.ReserveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/history")
@Slf4j
@Tag(name = "用户端")
public class History {

    @Autowired
    private ReserveService reserveService;


    /**
     * 分页查看预约的历史记录
     * @param historyPageQueryDTO
     * @return
     */
    @GetMapping("/reserve")
    @Operation(summary = "用户预约记录查看")
    public Result<PageResult> reserveHistory(HistoryPageQueryDTO historyPageQueryDTO) {
        log.info("分页查看预约历史记录{}",historyPageQueryDTO);
        PageResult pageResult = reserveService.historyPage(historyPageQueryDTO);
        return Result.success(pageResult);
    }


}
