package edu.hlju.boler.service.interfaces;

import javax.servlet.http.HttpServletRequest;

import edu.hlju.boler.pojo.po.Application;
import edu.hlju.boler.pojo.po.Recruitment;
import edu.hlju.boler.pojo.vo.BaseResponse;

public interface IEmployService {

    BaseResponse changeAppState(HttpServletRequest request, Application application);

    BaseResponse publishRecruitment(HttpServletRequest request, Recruitment recruitment);

    BaseResponse queryAllJobTypes();

    BaseResponse queryAllRecuitments(HttpServletRequest request);

    BaseResponse queryAllApplications(HttpServletRequest request);

    BaseResponse updateRecruitment(HttpServletRequest request, Recruitment recruitment);

}
