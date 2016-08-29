package com.szdfc.dfsm.http;

import com.szdfc.entitylib.ActionDetailEntity;
import com.szdfc.entitylib.BussinessSchoolDetailEntity;
import com.szdfc.entitylib.ExhDetailEntity;
import com.szdfc.entitylib.NewsDetailEntity;
import com.szdfc.entitylib.ResultListEntity;
import com.szdfc.entitylib.StudyTourDetailEntity;
import com.szdfc.entitylib.ThinkDetailEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by FreeMason on 2016/4/7.
 */
public interface MainAPI {
    //展会
    @GET("api/exhibitionList")
    Observable<ResultListEntity> getExhibition(@Query("pagerNumber") int pagerNumber);

    //1,15b656ce56314238947bc971d50ba3e2
    //展会报名*****
    @GET("api/enrolExhibition")
    Observable<ExhDetailEntity> getEnrolExh(@Query("enrolExId") String enrolExId, @Query("enrolUserId") String enrolUserId);

    //展会详情*****
    @GET("api/exhibitionFindOne")
    Observable<ExhDetailEntity> getExhDetail(@Query("eId") int eId);

    //智库
    @GET("api/thinkTankList")
    Observable<ResultListEntity> getThinkTankList(@Query("pagerNumber") int pagerNumber);

    //新闻
    @GET("api/newsList")
    Observable<ResultListEntity> getNewsList(@Query("pagerNumber") int pagerNumber);

    //游学
    @GET("api/studyTourList")
    Observable<ResultListEntity> getStudyTourList(@Query("pagerNumber") int pagerNumber);

    //商学院
    @GET("api/businessSchoolList")
    Observable<ResultListEntity> getbSchoolList(@Query("pagerNumber") int pagerNumber);

    //活动信息
    @GET("api/actList")
    Observable<ResultListEntity> getActList(@Query("pagerNumber") int pagerNumber);

    //服务平台
    @GET("api/thirdPartyList")
    Observable<ResultListEntity> getThirdList(@Query("pagerNumber") int pagerNumber);

    //商务中心
    @GET("api/businessCentreList")
    Observable<ResultListEntity> getBusinessCentreList(@Query("pagerNumber") int pagerNumber);

    //时尚中心
    @GET("api/fashionCentreList")
    Observable<ResultListEntity> getFashionCentreList(@Query("pagerNumber") int pagerNumber);

    //创业大赛
    @GET("api/entrepreneurshipCompetitionList")
    Observable<ResultListEntity> getCompetitionList(@Query("pagerNumber") int pagerNumber);
    //游学详细
    @GET("api/studyTourFindOne")
    Observable<StudyTourDetailEntity> studyTourFindOne(@Query("sId") String id);

    //智库详细
    @GET("api/thinkTankFindOne")
    Observable<ThinkDetailEntity> thinkTankFindOne(@Query("tId") String id);

    //新闻详细
    @GET("api/newsFindOne")
    Observable<NewsDetailEntity> newsFindOne(@Query("nId") String id);

    //活动详细
    @GET("api/actFindOne")
    Observable<ActionDetailEntity> actFindOne(@Query("conId") String id);

    //商学院详细
    @GET("api/businessSchoolFindOne")
    Observable<BussinessSchoolDetailEntity> businessSchoolFindOne(@Query("bId") String id);
}
