import java.lang.*;
import java.util.*;
public class StringPerformanceComparison {
    public static void main(String[] args) {
        int numIterations = 1_000_000;
        String sampleText = "hello";
        StringBuffer stringBuffer = new StringBuffer();
        long startBuffer = System.nanoTime();
        for (int i = 0; i < numIterations; i++) {
            stringBuffer.append(sampleText);
        }
        long endBuffer = System.nanoTime();
        long bufferTime = endBuffer - startBuffer;
        StringBuilder stringBuilder = new StringBuilder();
        long startBuilder = System.nanoTime();
        for (int i = 0; i < numIterations; i++) {
            stringBuilder.append(sampleText);
        }
        long endBuilder = System.nanoTime();
        long builderTime = endBuilder - startBuilder;
        System.out.println("Time taken using StringBuffer: " + bufferTime / 1_000_000 + " ms");
        System.out.println("Time taken using StringBuilder: " + builderTime / 1_000_000 + " ms");
    }
}

