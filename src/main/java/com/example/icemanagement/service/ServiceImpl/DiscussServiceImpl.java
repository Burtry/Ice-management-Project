package com.example.icemanagement.service.ServiceImpl;

import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.mapper.DiscussMapper;
import com.example.icemanagement.pojo.dto.EquipmentDiscussDTO;
import com.example.icemanagement.pojo.dto.PageQueryDTO;
import com.example.icemanagement.pojo.dto.SpaceDiscussDTO;
import com.example.icemanagement.pojo.entity.DiscussByEquipment;
import com.example.icemanagement.pojo.entity.DiscussBySpace;
import com.example.icemanagement.pojo.vo.EquipmentDiscussVO;
import com.example.icemanagement.pojo.vo.SpaceDiscussVO;
import com.example.icemanagement.service.DiscussService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class DiscussServiceImpl implements DiscussService {

    @Autowired
    private DiscussMapper discussMapper;

    /**
     * 用户添加场地评论
     * @param spaceDiscussDTO
     */
    @Override
    public void createSpaceDiscuss(SpaceDiscussDTO spaceDiscussDTO) {
        DiscussBySpace discussBySpace = new DiscussBySpace();
        BeanUtils.copyProperties(spaceDiscussDTO,discussBySpace);
        discussBySpace.setCreateTime(LocalDateTime.now());
        discussBySpace.setUpdateTime(LocalDateTime.now());
        discussMapper.createSpaceDiscuss(discussBySpace);

        Long id = discussBySpace.getId();
        log.info("insert语句生成的主键值id:{}",id);

    }

    /**
     * 分页查看场地评论
     * @param pageQueryDTO
     * @return
     */
    @Override
    public PageResult listSpaceDiscuss(PageQueryDTO pageQueryDTO) {
        PageHelper.startPage(pageQueryDTO.getPage(), pageQueryDTO.getPageSize());
        Page<SpaceDiscussVO> page = discussMapper.listSpaceDiscuss();
        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 用户添加场地评论
     * @param equipmentDiscussDTO
     */
    @Override
    public void createEquipmentDiscuss(EquipmentDiscussDTO equipmentDiscussDTO) {
        DiscussByEquipment discussByEquipment = new DiscussByEquipment();
        BeanUtils.copyProperties(equipmentDiscussDTO,discussByEquipment);
        discussByEquipment.setCreateTime(LocalDateTime.now());
        discussByEquipment.setUpdateTime(LocalDateTime.now());
        discussMapper.createEquipmentDiscuss(discussByEquipment);

        Long id = discussByEquipment.getId();
        log.info("insert语句生成的主键值id:{}",id);

    }

    /**
     * 分页查看器材评论
     * @param pageQueryDTO
     * @return
     */
    @Override
    public PageResult listEquipmentDiscuss(PageQueryDTO pageQueryDTO) {
        PageHelper.startPage(pageQueryDTO.getPage(), pageQueryDTO.getPageSize());
        Page<EquipmentDiscussVO> page = discussMapper.listEquipment();
        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 管理员根据id删除场地评论
     * @param id 评论id
     */
    @Override
    public void deleteSpaceDiscussById(Long id) {
        discussMapper.deleteSpaceDiscussById(id);
    }

    /**
     * 管理员根据id删除器材评论
     * @param id
     */
    @Override
    public void deleteEquipmentDiscussById(Long id) {
        discussMapper.deleteEquipmentById(id);
    }
}
