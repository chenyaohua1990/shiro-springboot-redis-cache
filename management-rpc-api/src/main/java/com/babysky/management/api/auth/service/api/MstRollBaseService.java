package com.babysky.management.api.auth.service.api;


import com.babysky.management.api.auth.entity.MstRollBaseEntity;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MstRollBaseService {


    List<MstRollBaseEntity> findAll();

    MstRollBaseEntity findByCode(String rollCode);

    List<MstRollBaseEntity> findPage(Map<String, Object> map);

    MstRollBaseEntity createRole(MstRollBaseEntity role);

    MstRollBaseEntity updateRole(MstRollBaseEntity role);

    void deleteRoleByCode(String rollCode);

    Set<String> findRoles(String... roleCodes);

    Set<String> findPermissions(String[] strings);

    Integer count(Map<String, Object> paramMap);

    String findNamesByRollCodes(String[] rollCodes);

    List<MstRollBaseEntity> findBySubsyCodes(String subsyCodes);

}
