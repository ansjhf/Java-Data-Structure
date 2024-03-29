package com.DataStructure.BinaryTree.HuffmanCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class HuffmanAlgorithmAbstract implements HuffmanAlgorithm{

    /**
     * Task:编码
     * @param str 要编码的字符串
     * @return
     */
    @Override
    public EncodeResult encode(String str) {
        ArrayList<Node> letterList = toList(str);
        Node rootNode = createTree(letterList);
        Map<Character, String> letterCode = getLetterCode(rootNode);
        EncodeResult result = encode(letterCode, str);
        return result;
    }

    /**
     * Task:解码
     * @param decodeResult
     * @return
     */
    @Override
    public String decode(EncodeResult decodeResult) {
        //解码得到的字符串
        StringBuffer decodeStr = new StringBuffer();
        //获得解码器
        Map<String, Character> decodeMap = getDecoder(decodeResult.getLetterCode());
        //解码器键集合
        Set<String> keys = decodeMap.keySet();
        //待解码的字符串
        String encode = decodeResult.getEncode();
        // 从最短的开始匹配之所以能够成功，是因为哈夫曼编码的唯一前缀性质
        // 临时的可能的键值
        String temp = "";
        // 改变temp值大小的游标
        int i = 1;
        while (encode.length() > 0) {
            temp = encode.substring(0, i);
            if (keys.contains(temp)) {
                Character character = decodeMap.get(temp);
                decodeStr.append(character);
                encode = encode.substring(i);
                i = 1;
            } else {
                i++;
            }
        }

        return decodeStr.toString();
    }

    private ArrayList<Node> toList(String letters) {
        ArrayList<Node> letterList = new ArrayList<Node>();
        Map<Character,Integer> ci = new HashMap<Character,Integer>();
        for (int i = 0; i < letters.length(); i++) {
            Character character = letters.charAt(i);
            if (!ci.keySet().contains(character)) {
                ci.put(character, 1);
            } else {
                Integer oldValue = ci.get(character);
                ci.put(character, oldValue + 1);
            }
        }
        Set<Character> keys = ci.keySet();
        for (Character key : keys) {
            Node node = new Node();
            Data data = new Data();
            data.setC(key);
            data.setFrequency(ci.get(key));
            node.setData(data);
            letterList.add(node);
        }
        return letterList;
    }

    protected abstract Node createTree(ArrayList<Node> letterList);

    /**
     * 编码
     * @param letterCode 字符/编码对集合
     * @param letters 指定的需要编码的字符串
     * @return 编码结果
     */
    private EncodeResult encode(Map<Character, String> letterCode, String letters) {
        StringBuffer encode = new StringBuffer();
        for (int i = 0; i < letters.length(); i++) {
            Character character = letters.charAt(i);
            encode.append(letterCode.get(character));
        }
        EncodeResult result = new EncodeResult(encode.toString(), letterCode);
        return result;
    }

    /**
     * 获得所有字符编码对
     * @param rootNode rootNode哈夫曼树的根节点
     * @return 所有字符编码对
     */
    private Map<Character, String> getLetterCode(Node rootNode) {
        Map<Character, String> letterCode = new HashMap<Character, String>();
        // 处理只有一个节点的情况
        if (rootNode.getLeftChild() == null && rootNode.getRightChild() == null) {
            letterCode.put(rootNode.getData().getC(), "1");
            return letterCode;

        }
        getLetterCode(rootNode, "", letterCode);
        return letterCode;
    }

    /**
     * 历遍哈夫曼树，获得所有字符编码对
     * @param rootNode
     * @param suffix 编码前缀，也就是编码这个字符时，之前路径上的所有编码
     * @param letterCode 用于保存字符编码结果
     */
    private void getLetterCode(Node rootNode, String suffix, Map<Character, String> letterCode) {
        if (rootNode != null) {
            if (rootNode.getLeftChild() == null && rootNode.getRightChild() == null) {
                Character character = rootNode.getData().getC();
                letterCode.put(character, suffix);
            }
            getLetterCode(rootNode.getLeftChild(), suffix + "0", letterCode);
            getLetterCode(rootNode.getRightChild(), suffix + "1", letterCode);
        }
    }

    /**
     * Task:获得解码器，通过'字符/编码' 得到 '编码/字符对'
     * @param letterCode
     * @return
     */
    private Map<String, Character> getDecoder(Map<Character, String> letterCode) {
        Map<String, Character> decodeMap = new HashMap<>();
        Set<Character> keys = letterCode.keySet();
        for (Character key : keys) {
            String value = letterCode.get(key);
            decodeMap.put(value, key);
        }
        return  decodeMap;
    }

}
