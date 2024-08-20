package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 产品相关接口
 */
@RestController
@RequestMapping("/admin/dish")
@ApiOperation("产品相关接口")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;
    /**
     * 新增产品
     * @param dishDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增产品")
    public Result save(@RequestBody DishDTO dishDTO){
        log.info("新增产品，参数：{}", dishDTO);
        dishService.saveWithFlavor(dishDTO);
        return Result.success();
    }


    /**
     * 分页查询产品
     * @param dishPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分页查询产品")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO){
        log.info("分页查询产品，参数：{}", dishPageQueryDTO);
        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 批量删除产品
     * @param ids
     * @return
     */
    @DeleteMapping
    @ApiOperation("批量删除产品")
    public Result delete(@RequestParam List<Long> ids){
        log.info("批量删除产品，参数：{}", ids);
        dishService.deleteBatch(ids);
        return Result.success();
    }
}
