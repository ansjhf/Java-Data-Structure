package com.DataStructure.BinaryTree.HuffmanCode;

public interface HuffmanAlgorithm {
    /**
     * 编码字符串
     * @param str 要编码的字符串
     * @return
     */
    public EncodeResult encode(String str);

    /**
     * 根据编码结果返回原来的字符串
     * @param encodeResult
     * @return
     */
    public String decode(EncodeResult encodeResult);
}
