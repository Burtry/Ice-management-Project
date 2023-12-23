package com.example.icemanagement.service.ServiceImpl;

import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.mapper.EquipmentMapper;
import com.example.icemanagement.pojo.dto.EquipmentDTO;
import com.example.icemanagement.pojo.dto.EquipmentPageQueryDTOByName;
import com.example.icemanagement.pojo.dto.EquipmentPageQueryDTOByType;
import com.example.icemanagement.pojo.entity.Equipment;
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
     * 分页器材查询
     * @return
     */
    @Override
    public PageResult pageQuery(EquipmentPageQueryDTOByName equipmentPageQueryDTOByName) {
        //开始分页查询
        //1.开始分页，调用pagehelper中的startPage方法，传进去页码和每页展示数
        PageHelper.startPage(equipmentPageQueryDTOByName.getPage(), equipmentPageQueryDTOByName.getPageSize());
        //调用mapper层进行数据查询，返回一个Page类型的对象,通过这个对象就可以获得总记录数和返回结果
        Page<Equipment> page = equipmentMapper.pageQuery(equipmentPageQueryDTOByName);
        List<Equipment> result = page.getResult();
        long total = page.getTotal();
        return new PageResult(total,result);
    }

    /**
     * 根据类型分页查询
     * @param
     * @return
     */
    @Override
    public PageResult pageByType(EquipmentPageQueryDTOByType equipmentPageQueryDTOByType) {
        PageHelper.startPage(equipmentPageQueryDTOByType.getPage(),equipmentPageQueryDTOByType.getPageSize());
        Page<Equipment> page = equipmentMapper.pageByType(equipmentPageQueryDTOByType);
        List<Equipment> result = page.getResult();
        long total = page.getTotal();
        return new PageResult(total,result);
    }

    /**
     * 根据id查询器材
     * @param id
     * @return
     */
    @Override
    public Equipment getById(Long id) {
        Equipment equipment = equipmentMapper.getById(id);
        return equipment;
    }

    /**
     * 修改器材
     * @param equipmentDTO
     */
    @Override
    public void update(EquipmentDTO equipmentDTO) {
        Equipment equipment = new Equipment();
        BeanUtils.copyProperties(equipmentDTO,equipment);
        //更新修改时间
        equipment.setUpdateTime(LocalDateTime.now());
        //修改器材信息
        equipmentMapper.update(equipment);
    }
    /**
     * 新增器材
     * @param
     */
    @Override
    public void insert(EquipmentDTO equipmentDTO) {
        Equipment equipment = new Equipment();
        BeanUtils.copyProperties(equipmentDTO,equipment);
        //将新增的器材状态都设置成0未借出状态
        equipment.setStatus(0);
        equipment.setCreateTime(LocalDateTime.now());
        equipment.setUpdateTime(LocalDateTime.now());
        equipmentMapper.insert(equipment);
    }

    /**
     * 根据ids集合批量删除器材
     * @param ids id集合
     */
    @Override
    public void delete(List<Long> ids) {
        equipmentMapper.deleteByIds(ids);
    }

}
