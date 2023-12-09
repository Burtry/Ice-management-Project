package com.example.icemanagement.service.ServiceImpl;

import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.mapper.SpaceMapper;
import com.example.icemanagement.pojo.dto.SpaceDTO;
import com.example.icemanagement.pojo.dto.SpacePageQueryDTO;
import com.example.icemanagement.pojo.entity.Space;
import com.example.icemanagement.service.SpaceService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SpaceServiceImpl implements SpaceService {

    @Autowired
    private SpaceMapper spaceMapper;
    /**
     * 新增场地
     * @param spaceDTO
     */
    @Override
    public void insert(SpaceDTO spaceDTO) {
        Space space = new Space();
        BeanUtils.copyProperties(spaceDTO,space);
        space.setCreateTime(LocalDateTime.now());
        space.setUpdateTime(LocalDateTime.now());
        spaceMapper.insert(space);


    }

    /**
     * 场地分页查询
     * @param spacePageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(SpacePageQueryDTO spacePageQueryDTO) {
        PageHelper.startPage(spacePageQueryDTO.getPage(),spacePageQueryDTO.getPageSize());
        Page<Space> page = spaceMapper.pageQuery(spacePageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
