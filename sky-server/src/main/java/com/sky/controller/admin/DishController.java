package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
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

    /**
     * 根据id查询产品
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询产品")
    public Result<DishVO> getById(@PathVariable Long id){
        log.info("根据id查询产品，参数：{}", id);
        DishVO dishVO = dishService.getByIdWithFlavor(id);
        return Result.success(dishVO);
    }

    /**
     * 修改产品
     * @param dishDTO
     * @return
     */
    @PutMapping
    @ApiOperation("修改产品")
    public Result updata(@RequestBody DishDTO dishDTO){
        log.info("修改产品，参数：{}", dishDTO);
        dishService.updateWithFlavor(dishDTO);
        return Result.success();
    }

    /**
     * 启用或禁用产品
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("启用或禁用产品")
    public Result startOrStop(@PathVariable Integer status,Long id){
        dishService.setStartOrStop(status,id);
        return Result.success();
    }

    @GetMapping("/list")
    @ApiOperation("根据分类id查询菜品列表")
    public Result<List<Dish>> list(Long categoryId){
        List<Dish> dishes = dishService.list(categoryId);
        return Result.success(dishes);
    }
}
