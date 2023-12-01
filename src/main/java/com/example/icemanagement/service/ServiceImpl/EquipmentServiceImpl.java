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
    public PageResult pageQuery(EquipmentPageQueryDTO equipmentPageQueryDTO) {
        //开始分页查询
        //1.开始分页，调用pagehelper中的startPage方法，传进去页码和每页展示数
        PageHelper.startPage(equipmentPageQueryDTO.getPage(), equipmentPageQueryDTO.getPageSize());
        //调用mapper层进行数据查询，返回一个Page类型的对象,通过这个对象就可以获得总记录数和返回结果
        Page<Equipment> page = equipmentMapper.pageQuery(equipmentPageQueryDTO);
        List<Equipment> result = page.getResult();
        int total = result.size();
        return new PageResult(total,result);
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
