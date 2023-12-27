package com.example.icemanagement.service.ServiceImpl;

import com.example.icemanagement.common.result.PageResult;
import com.example.icemanagement.mapper.DiscussMapper;
import com.example.icemanagement.pojo.dto.PageQueryDTO;
import com.example.icemanagement.pojo.dto.SpaceDiscussDTO;
import com.example.icemanagement.pojo.entity.DiscussBySpace;
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
     * 用户添加评论
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
}
