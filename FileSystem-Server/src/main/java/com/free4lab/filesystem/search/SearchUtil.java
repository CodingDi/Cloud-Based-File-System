package com.free4lab.filesystem.search;

import com.free4lab.filesystem.common.ConstantEnum;
import com.free4lab.filesystem.common.Constants;
import com.free4lab.filesystem.sql.beans.FileDetailEntity;
import com.free4lab.search.client.Indexer;
import com.free4lab.search.client.Searcher;
import com.free4lab.search.client.Tager;
import com.free4lab.search.common.bean.Document;
import com.free4lab.search.common.bean.Tag;
import com.free4lab.search.common.bean.result.SearchResult;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SearchUtil {
    static Indexer indexer = new Indexer(Constants.SOUYA_APPKEY, Constants.SOUYA_SECRETKEY);
    static Searcher searcher = new Searcher(Constants.SOUYA_APPKEY, Constants.SOUYA_SECRETKEY);
    static Tager tager = new Tager(Constants.SOUYA_APPKEY, Constants.SOUYA_SECRETKEY);

    private static final Logger log = Logger.getLogger(SearchUtil.class);

    /**
     * 添加一条用户的记录
     */
    public static String addContent(String content, String title, FileDetailEntity fileDetailEntity) {
        String randomUri = UUID.randomUUID().toString();//生成不重复的随机字符串作为doc的uri

        List<Tag> tags = new ArrayList<Tag>();

        Tag tagEnterpriseId = new Tag(fileDetailEntity.getEnterpriseId(), randomUri, 10);
        Tag tagEventId = new Tag(fileDetailEntity.getEventId(), randomUri, 10);
        Tag tagDepartmentId = new Tag(fileDetailEntity.getDepartmentId(), randomUri, 10);
        Tag tagYear = new Tag(fileDetailEntity.getYear(), randomUri, 10);

        //每条文档会设置tag，tag有4个，一般企业tag都是1，event department 是数据库里的id ,year是2017，2018这种字符串
        tags.add(tagEnterpriseId);
        tags.add(tagEventId);
        tags.add(tagDepartmentId);
        tags.add(tagYear);

        Document doc = new Document(randomUri, title, content, tags);
        doc.setDescription("none");
        try {
            indexer.addDoc(doc);
        }
        catch (Exception e) {
            e.printStackTrace();
            fileDetailEntity.setSouyaStatus(ConstantEnum.STATUS_TYPE.FAIL);
        }
        fileDetailEntity.setSouyaStatus(ConstantEnum.STATUS_TYPE.SUCCESS);
        return randomUri;
    }

    /**
     * 查找所有相关记录
     */
    public static List<Document> findAllContent() {
        String sortmode = "desc:time";
        SearchResult sr = searcher.searchDocument("", "", sortmode, "", 1, 200, true);

        return sr.getDocs();
    }

    /**
     * 按关键字搜索结果
     *
     * @param keyWord
     * @return
     */
    public static List<Document> findSearchContent(String keyWord,String tag) {
        String sortmode = "desc:time";
        SearchResult sr = searcher.searchDocument(keyWord, tag, sortmode, "", 1, 200, true);
        return sr.getDocs();
    }

    /**
     * 获取一条记录
     *
     * @param docUri
     * @return
     */
    public static String findOneDoc(String docUri) {
        return indexer.getDoc(docUri, true);
    }

    /**
     * 更新一条记录
     *
     * @param doc
     */
    public static void updateDoc(Document doc) {
        indexer.updateDoc(doc);
    }

    /**
     * 删除一条记录
     *
     * @param uri
     */
    public static void deleteDoc(String uri) {
        indexer.delDoc(uri);
    }

    public static void updateTag(String uri,String year,String eventId,String departmentId,String enterpriseid) {
        String document = findOneDoc(uri);
        JSONObject obj = new JSONObject(document);
        List<Tag> tags = new ArrayList<Tag>();
        JSONArray array = obj.getJSONArray("tags");
        for ( int i = 0; i< array.length(); i++) {
            tags.add(new Tag( (String)array.getJSONObject(i).get("tag"), (String)array.getJSONObject(i).get("docUri"), array.getJSONObject(i).getInt("value")));
        }
        for(Tag tag : tags) {
            tager.delTag(uri,tag.getTag());
        }
        tags.clear();
        Tag tagYear = new Tag(year, uri, 10);
        Tag tagEventId = new Tag(eventId, uri, 10);
        Tag tagDepartmentId = new Tag(departmentId, uri, 10);
        Tag tagEnterpriseid = new Tag(enterpriseid, uri, 10);
        tags.add(tagYear);
        tags.add(tagEventId);
        tags.add(tagDepartmentId);
        tags.add(tagEnterpriseid);
        tager.addTags(tags);
    }

    public static void main(String args[]) {
        String document2 = indexer.getDoc("5956ab11-4a18-4af1-a543-b9b5e8f638b6",true);
        JSONObject obj = new JSONObject(document2);
        List<Tag> tags = new ArrayList<Tag>();
        JSONArray array = obj.getJSONArray("tags");
        for ( int i = 0; i< array.length(); i++) {
            tags.add(new Tag( (String)array.getJSONObject(i).get("tag"), (String)array.getJSONObject(i).get("docUri"), array.getJSONObject(i).getInt("value")));
        }
        for(Tag tag : tags) {
            tager.delTag("5956ab11-4a18-4af1-a543-b9b5e8f638b6",tag.getTag());
        }
//        tager.addTag(new Tag("1947","d4e16376-1019-482f-bf56-de948ac5c6a5",10));
//        tager.addTag(new Tag("5","d4e16376-1019-482f-bf56-de948ac5c6a5",10));
//        tager.addTag(new Tag("2","d4e16376-1019-482f-bf56-de948ac5c6a5",10));
        tager.addTag(new Tag("1","5956ab11-4a18-4af1-a543-b9b5e8f638b6",10));

    }
}
