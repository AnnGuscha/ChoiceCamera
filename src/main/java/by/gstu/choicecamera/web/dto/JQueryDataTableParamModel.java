package by.gstu.choicecamera.web.dto;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Anna on 12/11/2015.
 */
public class JQueryDataTableParamModel {
    public String sEcho;
    public String sSearch;
    public int iDisplayLength;
    public int iDisplayStart;
    public int iColumns;
    public int iSortingCols;
    public String sColumns;
    //public int sSearch_0;
    public int iSortCol_0;
    public String sSortDir_0;
    //public int sSearch_1;
    public int iSortCol_1;
    //public int sSearch_2;
    public int iSortCol_2;
    //public int sSearch_3;
    public int iSortCol_3;

    public JQueryDataTableParamModel() {
    }

    public JQueryDataTableParamModel(HttpServletRequest request) {
        this.sEcho = request.getParameter("sEcho");
        this.iColumns = Integer.parseInt(request.getParameter("iColumns"));
        this.iDisplayLength = Integer.parseInt(request.getParameter("iDisplayLength"));
        this.iDisplayStart = Integer.parseInt(request.getParameter("iDisplayStart"));
        this.iSortingCols = Integer.parseInt(request.getParameter("iSortingCols"));
        this.sSearch = request.getParameter("sSearch");
        this.sColumns = request.getParameter("sColumns");
        this.sSortDir_0 = request.getParameter("sSortDir_0");
//        this.sSearch_0 = Integer.parseInt((String) request.getParameter("sSearch_0"));
//        this.sSearch_1 = Integer.parseInt((String) request.getParameter("sSearch_1"));
//        this.sSearch_2 = Integer.parseInt((String) request.getParameter("sSearch_2"));
//        this.sSearch_3 = Integer.parseInt((String) request.getParameter("sSearch_3"));
        this.iSortCol_0 = request.getParameter("iSortCol_0") != null ? Integer.parseInt(request.getParameter("iSortCol_0")) : 0;
        this.iSortCol_1 = request.getParameter("iSortCol_1") != null ? Integer.parseInt(request.getParameter("iSortCol_1")) : 0;
        this.iSortCol_2 = request.getParameter("iSortCol_2") != null ? Integer.parseInt(request.getParameter("iSortCol_2")) : 0;
        this.iSortCol_3 = request.getParameter("iSortCol_3") != null ? Integer.parseInt(request.getParameter("iSortCol_3")) : 0;
    }

    public String getsEcho() {
        return sEcho;
    }

    public void setsEcho(String sEcho) {
        this.sEcho = sEcho;
    }

    public String getsSearch() {
        return sSearch;
    }

    public void setsSearch(String sSearch) {
        this.sSearch = sSearch;
    }

    public int getiDisplayLength() {
        return iDisplayLength;
    }

    public void setiDisplayLength(int iDisplayLength) {
        this.iDisplayLength = iDisplayLength;
    }

    public int getiDisplayStart() {
        return iDisplayStart;
    }

    public void setiDisplayStart(int iDisplayStart) {
        this.iDisplayStart = iDisplayStart;
    }

    public int getiColumns() {
        return iColumns;
    }

    public void setiColumns(int iColumns) {
        this.iColumns = iColumns;
    }

    public int getiSortingCols() {
        return iSortingCols;
    }

    public void setiSortingCols(int iSortingCols) {
        this.iSortingCols = iSortingCols;
    }

    public String getsColumns() {
        return sColumns;
    }

    public void setsColumns(String sColumns) {
        this.sColumns = sColumns;
    }

    public int getiSortCol_0() {
        return iSortCol_0;
    }

    public void setiSortCol_0(int iSortCol_0) {
        this.iSortCol_0 = iSortCol_0;
    }

    public String getsSortDir_0() {
        return sSortDir_0;
    }

    public void setsSortDir_0(String sSortDir_0) {
        this.sSortDir_0 = sSortDir_0;
    }

    public int getiSortCol_1() {
        return iSortCol_1;
    }

    public void setiSortCol_1(int iSortCol_1) {
        this.iSortCol_1 = iSortCol_1;
    }

    public int getiSortCol_2() {
        return iSortCol_2;
    }

    public void setiSortCol_2(int iSortCol_2) {
        this.iSortCol_2 = iSortCol_2;
    }

    public int getiSortCol_3() {
        return iSortCol_3;
    }

    public void setiSortCol_3(int iSortCol_3) {
        this.iSortCol_3 = iSortCol_3;
    }
}
