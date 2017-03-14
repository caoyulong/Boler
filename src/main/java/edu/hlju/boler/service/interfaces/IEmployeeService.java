package edu.hlju.boler.service.interfaces;

import javax.servlet.http.HttpServletRequest;

import edu.hlju.boler.pojo.po.Application;
import edu.hlju.boler.pojo.po.PersonInfo;
import edu.hlju.boler.pojo.vo.BaseResponse;
import edu.hlju.boler.pojo.vo.StateResponse;

public interface IEmployeeService {

    BaseResponse addApplication(HttpServletRequest request, Application application);

    StateResponse savePersonInfo(HttpServletRequest request, PersonInfo info);

}
