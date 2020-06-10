package com.free4lab.filesystem.sql.beans;

import javax.persistence.*;


@Entity
@Table(name="filecontent")
public class DirTreeContent {
    /**
     * 每个节点的标识
     */
    private Integer id;

    /**
     * 父节点的标识
     */
    private Integer pId;

    private String name;

    private String type;

    private boolean isParent;

    private String path;

    private String docuri;

    public DirTreeContent() {
    }

    public DirTreeContent(Integer id, Integer pId, String name, String type, boolean isParent) {
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.type = type;
        this.isParent = isParent;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "pId",nullable = false)
    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    @Column(name = "name",nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "type",nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "isParent",nullable = false)
    public boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(boolean parent) {
        isParent = parent;
    }

    @Column(name = "path",nullable = false)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Column(name = "docuri")
    public String getDocuri() {
        return docuri;
    }

    public void setDocuri(String docuri) {
        this.docuri = docuri;
    }
}
