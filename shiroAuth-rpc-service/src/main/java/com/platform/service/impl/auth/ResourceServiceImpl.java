package com.platform.service.impl.auth;

import com.platform.api.auth.service.ResourceService;
import com.platform.web.dao.auth.IResourceDao;
import com.platform.api.auth.entity.Resource;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
* @ClassName: ResourceServiceImpl 
* @Description: 资源
 */
@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

   /* @Autowired
    private ResourceDao resourceDao;*/
    @Autowired
    private IResourceDao resourceDao;

    @Override
    public Resource createResource(Resource resource) {
    	resourceDao.insertSelective(resource);
        return resource;
    }

    @Override
    public Resource updateResource(Resource resource) {
    	resourceDao.updateByPrimaryKeySelective(resource);
        return resource;
    }

    @Override
    public void deleteResource(Long resourceId) {
    	resourceDao.deleteByPrimaryKey(resourceId);
    }

    @Override
    public Resource findOne(Long resourceId) {
        return resourceDao.selectByPrimaryKey(resourceId);
    }

    @Override
    public List<Resource> findAll() {
        return resourceDao.selectAll();
    }

    @Override
    public Set<String> findPermissions(Set<Long> resourceIds) {
        Set<String> permissions = new HashSet<>();
        for(Long resourceId : resourceIds) {
            Resource resource = findOne(resourceId);
            if(resource != null && !StringUtils.isEmpty(resource.getPermission())) {
                permissions.add(resource.getPermission());
            }
        }
        return permissions;
    }

    @Override
    public List<Resource> findMenus(Set<String> permissions) {
        List<Resource> allResources = findAll();
        List<Resource> menus = new ArrayList<>();
        for(Resource resource : allResources) {
            if(resource.isRootNode()) {
                continue;
            }
            if(resource.getType() != Resource.ResourceType.menu) {
                continue;
            }
            if(!hasPermission(permissions, resource)) {
                continue;
            }
            menus.add(resource);
        }
        return menus;
    }

    private boolean hasPermission(Set<String> permissions, Resource resource) {
        if(StringUtils.isEmpty(resource.getPermission())) {
            return true;
        }
        for(String permission : permissions) {
            WildcardPermission p1 = new WildcardPermission(permission);
            WildcardPermission p2 = new WildcardPermission(resource.getPermission());
            if(p1.implies(p2) || p2.implies(p1)) {
                return true;
            }
        }
        return false;
    }
}
