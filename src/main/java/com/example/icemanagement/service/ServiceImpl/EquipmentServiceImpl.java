package com.example.icemanagement.service.ServiceImpl;

import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.mapper.EquipmentMapper;
import com.example.icemanagement.pojo.dto.EquipmentDTO;
import com.example.icemanagement.pojo.dto.EquipmentPageQueryDTO;
import com.example.icemanagement.pojo.entity.Equipment;
import com.example.icemanagement.pojo.entity.User;
import com.example.icemanagement.service.EquipmentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentMapper equipmentMapper;

    /**
     * 器材查询
     * @return
     */
    @Override
    public PageResult pageQuery() {
        Page<Equipment> page = equipmentMapper.pageQuery();
        List<Equipment> result = page.getResult();
        int size = result.size();
        return new PageResult(size,result);
    }

    /**
     * 新增器材
     * @param
     */
    @Override
    public void insert(EquipmentDTO equipmentDTO) {
        Equipment equipment = new Equipment();
        BeanUtils.copyProperties(equipmentDTO,equipment);

        equipment.setCreateTime(LocalDateTime.now());
        equipmentMapper.insert(equipment);
    }
}
