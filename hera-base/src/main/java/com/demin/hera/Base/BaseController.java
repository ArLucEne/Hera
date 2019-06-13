package com.demin.hera.Base;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by  Domain
 * on 2019/6/10 19:40;
 */

public class BaseController<T,D extends BaseService> {

    @Autowired
    public D baseService;

    @GetMapping("/findAll")
    @ApiOperation("获得所有数据")
    public List<T> findAll(){
        return baseService.findAll();
    }

    @GetMapping("/findAllWithPage")
    @ApiOperation("分页查找")
    public PageInfo<T> findAllWithPage(@RequestParam int pageNum,@RequestParam int pageSize){
        return baseService.findAllWithPage(pageNum,pageSize);
    }

    @GetMapping("/findById")
    @ApiOperation("根据id查找")
    public Optional<T> findById(@RequestParam String id){
        return baseService.findById(id);
    }

    @PostMapping("/save")
    @ApiOperation("添加")
    public T save(@RequestBody T t){
        return (T)baseService.save(t);
    }

    @PostMapping("/update")
    @ApiOperation("更新")
    public T update(@RequestBody T t){
        return (T)baseService.update(t);
    }

    @GetMapping("/deleteById")
    @ApiOperation("根据Id删除")
    public void deleteById(@RequestParam String id){
        baseService.deleteById(id);
    }

    @GetMapping("/existById")
    @ApiOperation("查看id是否存在")
    public boolean existById(@RequestParam String id){
        return baseService.existById(id);
    }
}
