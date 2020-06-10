package com.free4lab.filesystem.action;

import com.free4lab.filesystem.client.FileSearchClient;
import com.free4lab.filesystem.common.Constants;
import com.free4lab.filesystem.common.Signal;
import com.free4lab.filesystem.response.SearchDetail;
import com.free4lab.filesystem.response.SearchResponse;
import com.free4lab.filesystem.util.ClientFactory;
import com.opensymphony.xwork2.ActionContext;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by lizhenhao on 2017/7/3.
 */
public class SearchAction extends BaseAction{

    protected Logger logger = Logger.getLogger(SearchAction.class);

    private FileSearchClient fileSearchClient = ClientFactory.getFileSearchClient();

    private String year;

    private String eventId;

    private String departmentId;

    private String keyword;

    private String operationType;

    private Integer currentPage;

    private Integer pageSize;

    private Integer totalPage;

    private List<SearchDetail> searchDetails;

    private String errorCode;

    private String operation;

    public String searchFilesAdvanced() {
        operationType = Constants.FILE_SEARCH;
        SearchResponse searchResponse = fileSearchClient.Search().params("year",year).params("eventId",eventId).params("departmentId",departmentId).params("keyword",keyword).params("enterpriseId",(String) ActionContext.getContext().getSession().get("enterpriseId")).execute();
        if(searchResponse.getErrorCode().equals(Signal.OK)) {
            operation = searchResponse.getOperation();
            searchDetails = searchResponse.getSearchList();
            return SUCCESS;
        }
        else {
            logger.error(searchResponse.getErrorMessage());
            return ERROR;
        }
    }

    public String searchFiles() {
        operationType = Constants.FILE_SEARCH;
        SearchResponse searchResponse = fileSearchClient.Search().params("keyword",keyword).
                params("enterpriseId",(String) ActionContext.getContext().getSession().get("enterpriseId")).execute();
        if(searchResponse.getErrorCode().equals(Signal.OK)) {
            searchDetails = searchResponse.getSearchList();
            operation = searchResponse.getOperation();
            return SUCCESS;
        }
        else {
            logger.error(searchResponse.getErrorMessage());
            return ERROR;
        }
    }

    public String findFiles() {
        operationType = Constants.FILE_FIND;
        SearchResponse searchResponse = fileSearchClient.Find().params("year",year==null?"":year).params("eventId",eventId==null?"":eventId).params("departmentId",departmentId==null?"":departmentId).params("enterpriseId",(String) ActionContext.getContext().getSession().get("enterpriseId")).execute();
        searchDetails = searchResponse.getSearchList();
        errorCode = searchResponse.getErrorCode();
        operation = searchResponse.getOperation();
        return SUCCESS;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<SearchDetail> getSearchDetails() {
        return searchDetails;
    }

    public void setSearchDetails(List<SearchDetail> searchDetails) {
        this.searchDetails = searchDetails;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
