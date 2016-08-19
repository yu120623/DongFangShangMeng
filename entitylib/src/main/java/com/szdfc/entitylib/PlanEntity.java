package com.szdfc.entitylib;

import java.util.List;

/**
 * Created by HGo on 2016/7/28.
 */
public class PlanEntity {
    private String resultcode;
    private String reason;

    private List<ResultBean> result;
    private int error_code;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {

        private String FlightNum;
        private String AirlineCode;
        private String Airline;
        private String DepCity;
        private String ArrCity;
        private String DepCode;
        private String ArrCode;
        private String OnTimeRate;
        private String DepTerminal;
        private String ArrTerminal;
        private String FlightDate;
        private String PEKDate;
        private String DepTime;
        private String ArrTime;
        private String Dexpected;
        private String Aexpected;


        public String getFlightNum() {
            return FlightNum;
        }

        public void setFlightNum(String flightNum) {
            FlightNum = flightNum;
        }

        public String getAirlineCode() {
            return AirlineCode;
        }

        public void setAirlineCode(String airlineCode) {
            AirlineCode = airlineCode;
        }

        public String getAirline() {
            return Airline;
        }

        public void setAirline(String airline) {
            Airline = airline;
        }

        public String getDepCity() {
            return DepCity;
        }

        public void setDepCity(String depCity) {
            DepCity = depCity;
        }

        public String getArrCity() {
            return ArrCity;
        }

        public void setArrCity(String arrCity) {
            ArrCity = arrCity;
        }

        public String getDepCode() {
            return DepCode;
        }

        public void setDepCode(String depCode) {
            DepCode = depCode;
        }

        public String getArrCode() {
            return ArrCode;
        }

        public void setArrCode(String arrCode) {
            ArrCode = arrCode;
        }

        public String getOnTimeRate() {
            return OnTimeRate;
        }

        public void setOnTimeRate(String onTimeRate) {
            OnTimeRate = onTimeRate;
        }

        public String getDepTerminal() {
            return DepTerminal;
        }

        public void setDepTerminal(String depTerminal) {
            DepTerminal = depTerminal;
        }

        public String getArrTerminal() {
            return ArrTerminal;
        }

        public void setArrTerminal(String arrTerminal) {
            ArrTerminal = arrTerminal;
        }

        public String getFlightDate() {
            return FlightDate;
        }

        public void setFlightDate(String flightDate) {
            FlightDate = flightDate;
        }

        public String getPEKDate() {
            return PEKDate;
        }

        public void setPEKDate(String PEKDate) {
            this.PEKDate = PEKDate;
        }

        public String getDepTime() {
            return DepTime;
        }

        public void setDepTime(String depTime) {
            DepTime = depTime;
        }

        public String getArrTime() {
            return ArrTime;
        }

        public void setArrTime(String arrTime) {
            ArrTime = arrTime;
        }

        public String getDexpected() {
            return Dexpected;
        }

        public void setDexpected(String dexpected) {
            Dexpected = dexpected;
        }

        public String getAexpected() {
            return Aexpected;
        }

        public void setAexpected(String aexpected) {
            Aexpected = aexpected;
        }
    }
}
