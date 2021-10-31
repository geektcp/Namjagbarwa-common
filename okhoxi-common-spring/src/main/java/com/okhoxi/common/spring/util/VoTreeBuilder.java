package com.okhoxi.common.spring.util;

import com.okhoxi.common.spring.model.vo.BaseTreeNodeVo;
import org.springframework.util.CollectionUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by tanghaiyang on 2019/1/10.
 */
public class VoTreeBuilder {

    private static <T extends BaseTreeNodeVo> boolean insertNode(T currentNode, T childNode) {
        if( currentNode.getId().equals(childNode.getParentId()) ){
            currentNode.add(childNode);
            return true;
        }
        if (Objects.nonNull(currentNode.getChildren())){
            currentNode.getChildren().forEach(currentChildNode ->{
                insertNode((T)currentChildNode, childNode);
            });
        }
        return false;
    }

    /*
    * para list will be modified when excute recursive inserting, so need deepcopy
    *
    * */
    @SuppressWarnings("all")
    public static <T extends BaseTreeNodeVo> T createTree(List<T> list, Class<T> clazz)
            throws IllegalAccessException, InstantiationException{
        T currentNode = clazz.newInstance();
        List<T> listCopy = (List<T>) deepCopy(list);
        if (Objects.nonNull(listCopy)) {
            listCopy.forEach(childNode -> {
                insertNode(currentNode, childNode);
            });
        }
        return currentNode;
    }

    public static <T extends BaseTreeNodeVo> List createTreeList(List<T> list, Class<T> clazz)
            throws IllegalAccessException, InstantiationException {
        return createTree(list, clazz).getChildren();
    }

    public static <T extends BaseTreeNodeVo> List parseTreeList(List<T> treeList){
        if (CollectionUtils.isEmpty(treeList)){
            return Collections.emptyList();
        }
        List<T> resultList = new ArrayList<>();
        treeList.stream().forEach(node -> {
            resultList.add(node);
            List<T> childrenNode = parseTreeList(node.getChildren());
            if (!CollectionUtils.isEmpty(childrenNode)){
                resultList.addAll(childrenNode);
            }
        });
        return resultList;
    }


    private static Object deepCopy(Object object) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream outputStrm = new ObjectOutputStream(outputStream);
            outputStrm.writeObject(object);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            ObjectInputStream objInputStream = new ObjectInputStream(inputStream);
            return objInputStream.readObject();
        } catch (Exception e) {

            return null;
        }
    }
}
