import com.DataStructure.BinaryTree.HuffmanCode.EncodeResult;
import com.DataStructure.BinaryTree.HuffmanCode.HuffmanAlgorithm;
import com.DataStructure.BinaryTree.HuffmanCode.HuffmanAlgorithmImpl;

public class Test {
    public static void main(String[] args) {
        HuffmanAlgorithm hf = new HuffmanAlgorithmImpl();
        EncodeResult result = hf.encode("Hello_Java");
        System.out.println(result.getEncode());

        String decode = hf.decode(result);
        System.out.println(decode);
    }
}



