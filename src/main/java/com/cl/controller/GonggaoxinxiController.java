package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.GonggaoxinxiEntity;
import com.cl.entity.view.GonggaoxinxiView;

import com.cl.service.GonggaoxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 公告信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-26 14:43:54
 */
@RestController
@RequestMapping("/gonggaoxinxi")
public class GonggaoxinxiController {
    @Autowired
    private GonggaoxinxiService gonggaoxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GonggaoxinxiEntity gonggaoxinxi,
		HttpServletRequest request){
        EntityWrapper<GonggaoxinxiEntity> ew = new EntityWrapper<GonggaoxinxiEntity>();

		PageUtils page = gonggaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gonggaoxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GonggaoxinxiEntity gonggaoxinxi, 
		HttpServletRequest request){
        EntityWrapper<GonggaoxinxiEntity> ew = new EntityWrapper<GonggaoxinxiEntity>();

		PageUtils page = gonggaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gonggaoxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GonggaoxinxiEntity gonggaoxinxi){
       	EntityWrapper<GonggaoxinxiEntity> ew = new EntityWrapper<GonggaoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gonggaoxinxi, "gonggaoxinxi")); 
        return R.ok().put("data", gonggaoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GonggaoxinxiEntity gonggaoxinxi){
        EntityWrapper< GonggaoxinxiEntity> ew = new EntityWrapper< GonggaoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gonggaoxinxi, "gonggaoxinxi")); 
		GonggaoxinxiView gonggaoxinxiView =  gonggaoxinxiService.selectView(ew);
		return R.ok("查询公告信息成功").put("data", gonggaoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GonggaoxinxiEntity gonggaoxinxi = gonggaoxinxiService.selectById(id);
		gonggaoxinxi = gonggaoxinxiService.selectView(new EntityWrapper<GonggaoxinxiEntity>().eq("id", id));
        return R.ok().put("data", gonggaoxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GonggaoxinxiEntity gonggaoxinxi = gonggaoxinxiService.selectById(id);
		gonggaoxinxi = gonggaoxinxiService.selectView(new EntityWrapper<GonggaoxinxiEntity>().eq("id", id));
        return R.ok().put("data", gonggaoxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GonggaoxinxiEntity gonggaoxinxi, HttpServletRequest request){
    	gonggaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gonggaoxinxi);
        gonggaoxinxiService.insert(gonggaoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GonggaoxinxiEntity gonggaoxinxi, HttpServletRequest request){
    	gonggaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gonggaoxinxi);
        gonggaoxinxiService.insert(gonggaoxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GonggaoxinxiEntity gonggaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gonggaoxinxi);
        gonggaoxinxiService.updateById(gonggaoxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gonggaoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
