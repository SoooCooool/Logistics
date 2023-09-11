package org.example.controller;

import org.example.common.Result;
import org.example.pojo.Transfer;
import org.example.pojo.Vehicle;
import org.example.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value="/Transfer")
public class TransferController {
    @Autowired(required=false)
    TransferService transferService;

    @GetMapping(value = "/queryAll")
    @ResponseBody
    public Result queryAll(){
        List<Transfer> transfer = transferService.queryTransferAll();
        return Result.success(transfer);
    }
}
