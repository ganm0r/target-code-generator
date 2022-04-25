package targetcodegenerator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class TargetCodeGenerator {
    
    public static void simulate(String sourceCodeFile, String outputFile) throws IOException, FileNotFoundException {
        
        Vector<String> targetCodeFile = new Vector<String>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceCodeFile));

        String currentLine;

        while((currentLine = bufferedReader.readLine()) != null) {
            String[] currentLineSplit = currentLine.split(" ");

            switch(currentLineSplit[0]) {
                case "*" :
                    targetCodeFile.addElement("mov R,"+currentLineSplit[1]);
                    targetCodeFile.addElement("mult R,"+currentLineSplit[2]);
                    targetCodeFile.addElement("mov "+currentLineSplit[3]+",R");
                    break;

                case "+" :
                    targetCodeFile.addElement("mov R,"+currentLineSplit[1]);
                    targetCodeFile.addElement("add R,"+currentLineSplit[2]);
                    targetCodeFile.addElement("mov "+currentLineSplit[3]+",R");
                    break;

                case "-" :
                    targetCodeFile.addElement("mov R,"+currentLineSplit[1]);
                    targetCodeFile.addElement("sub R,"+currentLineSplit[2]);
                    targetCodeFile.addElement("mov "+currentLineSplit[3]+",R");
                    break;

                case "=" :
                    targetCodeFile.addElement("mov R,"+currentLineSplit[1]);
                    targetCodeFile.addElement("mov "+currentLineSplit[3]+",R");
                    break;
            }
        }

        bufferedReader.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));

        for(int i = 1; i <= targetCodeFile.size(); i++) {
            bufferedWriter.write(targetCodeFile.get(i-1));
            bufferedWriter.newLine();

            if(i % 3 == 0) {
                bufferedWriter.newLine();
            }
        }

        bufferedWriter.close();
    }
}
