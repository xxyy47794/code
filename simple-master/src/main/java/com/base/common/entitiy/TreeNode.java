package com.base.common.entitiy;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

@Data
public class TreeNode implements Serializable {

    private String key;
    private Long value;
    private String label;
    private Long parentValue;
    private HashMap<String,Object> data;
    private List<TreeNode> children;

    public TreeNode(String key, Long value, String label, Long parentValue){
        this.key = key;
        this.value = value;
        this.label = label;
        this.parentValue = parentValue;
    }

    public TreeNode(String key,Long value, String lable){
        this.key = key;
        this.value = value;
        this.label = lable;
    }

    public TreeNode buildData(HashMap<String,Object> map){
        this.data = map;
        return this;
    }

}
