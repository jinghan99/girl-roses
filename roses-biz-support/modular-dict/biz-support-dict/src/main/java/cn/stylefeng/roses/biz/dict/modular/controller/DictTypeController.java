package cn.stylefeng.roses.biz.dict.modular.controller;

import cn.stylefeng.roses.biz.dict.api.entity.DictType;
import cn.stylefeng.roses.biz.dict.api.model.DictTypeInfo;
import cn.stylefeng.roses.biz.dict.modular.service.DictTypeService;
import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.core.reqres.request.RequestData;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.kernel.scanner.modular.stereotype.ApiResource;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 字典类型管理
 *
 * @author fengshuonan
 * @Date 2018/7/25 下午12:47
 */
@RestController
@ApiResource(name = "字典类型管理", path = "/dictType")
public class DictTypeController {

    @Autowired
    private DictTypeService dictTypeService;

    /**
     * 获取字典类型列表
     *
     * @author fengshuonan
     * @Date 2018/7/25 下午12:36
     */
    @PostMapping(name = "获取字典类型列表", path = "/getDictTypeList")
    public ResponseData getDictTypeList(RequestData requestData) {
        DictTypeInfo dictTypeInfo = requestData.parse(DictTypeInfo.class);
        Page<DictTypeInfo> page = PageFactory.defaultPage();
        List<DictTypeInfo> dictTypeList = dictTypeService.getDictTypeList(page, dictTypeInfo);
        page.setRecords(dictTypeList);
        return ResponseData.success(page);
    }

    /**
     * 添加字典类型
     *
     * @author fengshuonan
     * @Date 2018/7/25 下午12:36
     */
    @PostMapping(name = "添加字典类型", path = "/addDictType")
    public ResponseData addDictType(RequestData requestData) {
        DictType dictType = requestData.parse(DictType.class);
        this.dictTypeService.addDictType(dictType);
        return ResponseData.success();
    }

    /**
     * 修改字典类型
     *
     * @author fengshuonan
     * @Date 2018/7/25 下午12:36
     */
    @PostMapping(name = "修改字典类型", path = "/updateDictType")
    public ResponseData updateDictType(RequestData requestData) {
        DictType dictType = requestData.parse(DictType.class);
        this.dictTypeService.updateDictType(dictType);
        return ResponseData.success();
    }

    /**
     * 删除字典类型
     *
     * @author fengshuonan
     * @Date 2018/7/25 下午12:36
     */
    @PostMapping(name = "删除字典类型", path = "/deleteDictType")
    public ResponseData deleteDictType(RequestData requestData) {
        Long dictTypeId = requestData.getLong("dictTypeId");
        this.dictTypeService.deleteDictType(dictTypeId);
        return ResponseData.success();
    }

    /**
     * 修改字典类型状态
     *
     * @author fengshuonan
     * @Date 2018/7/25 下午12:36
     */
    @PostMapping(name = "修改字典类型状态", path = "/updateStatus")
    public ResponseData updateStatus(RequestData requestData) {
        Long dictTypeId = requestData.getLong("dictTypeId");
        this.dictTypeService.deleteDictType(dictTypeId);
        return ResponseData.success();
    }
}
