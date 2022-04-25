package main;

import targetcodegenerator.TargetCodeGenerator;

public class Main {
    public static void main(String[] args) throws Exception {
        final String INPUT_FILE_NAME = "/home/gndhrv/Documents/Sem VI/SPCC/TargetCodeGenerator/lib/inputFile.txt";
        final String OUTPUT_FILE_NAME = "/home/gndhrv/Documents/Sem VI/SPCC/TargetCodeGenerator/lib/outputFile.txt";

        TargetCodeGenerator.simulate(INPUT_FILE_NAME, OUTPUT_FILE_NAME);
    }
}
