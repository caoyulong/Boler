package edu.hlju.boler.service.interfaces;

import javax.servlet.http.HttpServletRequest;

import edu.hlju.boler.pojo.po.Application;
import edu.hlju.boler.pojo.po.OnlineResume;
import edu.hlju.boler.pojo.po.PersonInfo;
import edu.hlju.boler.pojo.vo.BaseResponse;
import edu.hlju.boler.pojo.vo.StateResponse;

public interface IEmployeeService {

    BaseResponse addApplication(HttpServletRequest request, Application application);

    BaseResponse delOnlineResume(HttpServletRequest request, int id);

    BaseResponse queryAllApps(HttpServletRequest request, int pageNum, int pageSize);

    BaseResponse queryAllRecruitments(HttpServletRequest request, int pageNum, int pageSize);

    BaseResponse queryPersonInfo(HttpServletRequest request);

    BaseResponse queryUserOnlineResumes(HttpServletRequest request);

    BaseResponse saveOnlineResume(HttpServletRequest request, OnlineResume onlineResume);

    StateResponse savePersonInfo(HttpServletRequest request, PersonInfo info);

    BaseResponse updateOnlineResume(HttpServletRequest request, OnlineResume resume);

    BaseResponse updatePersonInfo(HttpServletRequest request, PersonInfo info);

}
