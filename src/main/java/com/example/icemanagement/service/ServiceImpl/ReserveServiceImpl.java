package com.example.icemanagement.service.ServiceImpl;

import com.example.icemanagement.common.exception.BaseException;
import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.mapper.RecordsMapper;
import com.example.icemanagement.pojo.dto.RecordsPageQueryDTO;
import com.example.icemanagement.pojo.entity.ReserveRecords;
import com.example.icemanagement.service.ReserveService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReserveServiceImpl implements ReserveService {

    @Autowired
    private RecordsMapper recordsMapper;


    /**
     * 分页查询预约记录
     * @param recordsPageQueryDTO
     * @return
     */
    @Override
    public PageResult page(RecordsPageQueryDTO recordsPageQueryDTO) {
        PageHelper.startPage(recordsPageQueryDTO.getPage(), recordsPageQueryDTO.getPageSize());
        Page<ReserveRecords> page = recordsMapper.reservePage();
        return new PageResult(page.getTotal(),page.getResult());

    }

    /**
     * 根据id查询预约记录
     * @param id
     * @return
     */
    @Override
    public ReserveRecords getById(Long id) {
        ReserveRecords reserveRecords = recordsMapper.reserveGetById(id);
        if (reserveRecords == null) {
            throw new BaseException("该预约记录不存在");
        }
        return reserveRecords;
    }

    /**
     * 根据id修改场地状态
     * @param status
     * @param id
     */
    @Override
    public void updateByStatus(Integer status, Long id) {
        ReserveRecords reserveRecords = new ReserveRecords();
        reserveRecords.setUpdateTime(LocalDateTime.now());
        reserveRecords.setId(id);
        reserveRecords.setStatus(status);
        recordsMapper.reserveUpdate(reserveRecords);
    }
}
