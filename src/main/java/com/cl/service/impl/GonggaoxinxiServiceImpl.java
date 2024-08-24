package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.GonggaoxinxiDao;
import com.cl.entity.GonggaoxinxiEntity;
import com.cl.service.GonggaoxinxiService;
import com.cl.entity.view.GonggaoxinxiView;

@Service("gonggaoxinxiService")
public class GonggaoxinxiServiceImpl extends ServiceImpl<GonggaoxinxiDao, GonggaoxinxiEntity> implements GonggaoxinxiService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<GonggaoxinxiEntity> wrapper) {
		Page<GonggaoxinxiView> page =new Query<GonggaoxinxiView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GonggaoxinxiEntity> page = this.selectPage(
                new Query<GonggaoxinxiEntity>(params).getPage(),
                new EntityWrapper<GonggaoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GonggaoxinxiEntity> wrapper) {
		  Page<GonggaoxinxiView> page =new Query<GonggaoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<GonggaoxinxiView> selectListView(Wrapper<GonggaoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GonggaoxinxiView selectView(Wrapper<GonggaoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
