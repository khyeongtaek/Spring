package org.shark.hierarchy.service;

import lombok.RequiredArgsConstructor;
import org.shark.hierarchy.model.dto.BbsDTO;
import org.shark.hierarchy.model.dto.PageDTO;
import org.shark.hierarchy.repository.BbsDAO;
import org.shark.hierarchy.util.PageUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class BbsServiceImpl implements BbsService {
    private final BbsDAO bbsDAO;
    private final PageUtil pageUtil;

    @Override
    public boolean addBbs(BbsDTO parent) {
        try {
            int addedBbsCount = bbsDAO.insertParentBbs(parent);
            if (addedBbsCount != 1) {
                throw new RuntimeException("게시글 등록 실패");
            }
            int updateBbsCount = bbsDAO.updateGroupId(parent);
            if (updateBbsCount != 1) {
                throw new RuntimeException("GroupId 업데이트 실패");
            }

        } catch (Exception e) {
            throw new RuntimeException("게시물 추가 중 오류",e);
        }
        return true;
    }

    @Override
    public boolean addReply(BbsDTO bbsDTO) {
        try {
            BbsDTO parent = BbsDTO.builder()
                    .groupId(bbsDTO.getGroupId())
                    .groupOrder(bbsDTO.getGroupOrder())
                    .build();
            bbsDAO.updateGroupOrder(parent);
            BbsDTO child = BbsDTO.builder()
                    .content(bbsDTO.getContent())
                    .depth(bbsDTO.getDepth() + 1)
                    .groupId(bbsDTO.getGroupId())
                    .groupOrder(bbsDTO.getGroupOrder() + 1)
                    .build();

            int addedBbsCount = bbsDAO.insertChildBbs(child);
            if (addedBbsCount != 1) {
                throw new RuntimeException("답글 등록 실패");
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("답글 등록 중 오류가 발생했습니다.", e);
        }
        return true;
    }

    @Override
    public boolean removeBbs(Integer bbsId) {
        return bbsDAO.deleteBbsById(bbsId) == 1;
    }

    @Override
    public Map<String, Object> getBbsList(PageDTO pageDTO) {
        int itemCount = bbsDAO.getBbsCount();

        pageDTO.setItemCount(itemCount);
        pageUtil.calculatePaging(pageDTO);

        List<BbsDTO> bbsList = bbsDAO.getBbsList(pageDTO);

        return Map.of("bbsList", bbsList, "pageDTO", pageDTO);
    }
}
