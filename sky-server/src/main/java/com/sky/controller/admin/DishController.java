package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
