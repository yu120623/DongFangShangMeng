package com.szdfc.dfsm.http;

import com.szdfc.entitylib.ActionEntity;
import com.szdfc.entitylib.BusinessCentreEntity;
import com.szdfc.entitylib.BusinessSchoolEneity;
import com.szdfc.entitylib.ExhDetailEntity;
import com.szdfc.entitylib.ExhibitionEntity;
import com.szdfc.entitylib.NewsEntity;
import com.szdfc.entitylib.StudyTourEntity;
import com.szdfc.entitylib.ThinkTankEntity;
import com.szdfc.entitylib.ThirdPartyEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by FreeMason on 2016/4/7.
 */
public interface MainAPI {
    //展会
    @GET("api/exhibitionList")
    Observable<ExhibitionEntity> getExhibition(@Query("pagerNumber") int pagerNumber);

    //智库
    @GET("api/thinkTankList")
    Observable<ThinkTankEntity> getThinkTank(@Query("pagerNumber") int pagerNumber);

    //新闻
    @GET("api/newsList")
    Observable<NewsEntity> getNews(@Query("pagerNumber") int pagerNumber);

    //1,15b656ce56314238947bc971d50ba3e2
    //展会报名
    @GET("api/enrolExhibition")
    Observable<ExhDetailEntity> getEnrolExh(@Query("enrolExId") String enrolExId, @Query("enrolUserId") String enrolUserId);

    //展会详情
    @GET("api/exhibitionFindOne")
    Observable<ExhDetailEntity> getExhDetail(@Query("eId") int eId);

    //游学
    @GET("api/studyTourList")
    Observable<StudyTourEntity> getStudyTourList(@Query("pagerNumber") int pagerNumber);

    //商学院
    @GET("api/businessSchoolList")
    Observable<BusinessSchoolEneity> getbSchoolList(@Query("pagerNumber") int pagerNumber);

    //活动信息
    @GET("api/actList")
    Observable<ActionEntity> getActList(@Query("pagerNumber") int pagerNumber);

    //服务平台
    @GET("api/thirdPartyList")
    Observable<ThirdPartyEntity> getThirdList(@Query("pagerNumber") int pagerNumber);

    //商务中心
    @GET("api/businessCentreList")
    Observable<BusinessCentreEntity> getBusinessCentreList(@Query("pagerNumber") int pagerNumber);


}
