package com.springboot.blog.service;

import com.springboot.blog.entity.db.Resource;
import com.springboot.blog.entity.db.Resources;

import java.util.List;

public interface ResourcesService {
    public Resources byAccountId(int accountId);

    public List<?> detailByAccountId(Resources resources,String way);
    public List<Resource> resourceClassify(int accountId, String way, String classify);
    List<?> detail(int accountId,String way,String classify,String description);

}
