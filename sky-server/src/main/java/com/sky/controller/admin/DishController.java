package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 产品相关接口
 */
@RestController
@RequestMapping("/admin/dish")
@ApiOperation("产品相关接口")
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
        dishService.saveWithFlavor(dishDTO);
        return Result.success();
    }
}