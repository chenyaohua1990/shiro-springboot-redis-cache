package com.shiro.auth.repo.auth;


import com.shiro.auth.api.auth.dto.SubsyComboDto;
import com.shiro.auth.api.auth.entity.MstSubsyBaseEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author YangChao
 */
@Mapper
public interface IMstSubsyBaseDao {

    List<MstSubsyBaseEntity> querySubsyListByMap(Map<String, Object> map);

    MstSubsyBaseEntity queryByCode(String subsyCode);

    Integer count(Map<String, Object> paramMap);

    List<MstSubsyBaseEntity> findAll();

    String getSubsyNamesByCodes(String[] subsyCodesArray);

    List<MstSubsyBaseEntity> getSubsyListByCodes(String[] subsyCodesArray);


    String getSubsyRegionIndex(String regionCode);

    String getSubsyBrandIndex(String brandCode);

    String getLastCodeByPrefix(String prefix);

    void insert(MstSubsyBaseEntity mstSubsyBaseEntity);

    void updateById(MstSubsyBaseEntity mstSubsyBaseEntity);

    List<MstSubsyBaseEntity> findSubsyListBySubsyCodes(Map<String, Object> paramMap);

    List<MstSubsyBaseEntity> queryByMobnum(Map map);

    Integer findSubsyListForCloseCount(Map paramMap);

    List<MstSubsyBaseEntity> getSubsyInfoListByUserCode(String userCode);

    List<SubsyComboDto> getSubsyListByUserCode(String userCode);
}