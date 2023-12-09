package com.example.icemanagement.service.ServiceImpl;

import com.example.icemanagement.mapper.SpaceMapper;
import com.example.icemanagement.pojo.dto.SpaceDTO;
import com.example.icemanagement.pojo.entity.Space;
import com.example.icemanagement.service.SpaceService;
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
}
