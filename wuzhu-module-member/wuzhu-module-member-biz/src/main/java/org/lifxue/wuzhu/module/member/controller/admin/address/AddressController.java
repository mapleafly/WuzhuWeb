package org.lifxue.wuzhu.module.member.controller.admin.address;

import org.lifxue.wuzhu.framework.common.pojo.CommonResult;
import org.lifxue.wuzhu.module.member.controller.admin.address.vo.AddressRespVO;
import org.lifxue.wuzhu.module.member.convert.address.AddressConvert;
import org.lifxue.wuzhu.module.member.dal.dataobject.address.MemberAddressDO;
import org.lifxue.wuzhu.module.member.service.address.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import java.util.List;

import static org.lifxue.wuzhu.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 用户收件地址")
@RestController
@RequestMapping("/member/address")
@Validated
public class AddressController {

    @Resource
    private AddressService addressService;

    @GetMapping("/list")
    @Operation(summary = "获得用户收件地址列表")
    @Parameter(name = "userId", description = "用户编号", required = true)
    @PreAuthorize("@ss.hasPermission('member:user:query')")
    public CommonResult<List<AddressRespVO>> getAddressList(@RequestParam("userId") Long userId) {
        List<MemberAddressDO> list = addressService.getAddressList(userId);
        return success(AddressConvert.INSTANCE.convertList2(list));
    }

}
