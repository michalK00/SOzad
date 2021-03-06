package zad5;

import zad5.Algorithms.AlgorithmInterface;
import zad5.Algorithms.FirstStrategy;
import zad5.Algorithms.SecondStrategy;
import zad5.Algorithms.ThirdStrategy;

import java.util.ArrayList;
import java.util.Random;

public class main {

    public static void main(String[] args) {

        Random random = new Random();
        Utils utils = new Utils();
        Generator generator = new Generator();
        int numberOfProcessors = 80;
        int numberOfProcesses = 100;
        int maxLoad = 40;
        int maxDuration = 25;
        int maxInterval = 10;
        int cpuLoadBound = 70;

        ArrayList<CPU> cpuList = new ArrayList<>();
        for(int x = 0; x < numberOfProcessors; x++){
            int interval = random.nextInt(maxInterval-1)+1;
            cpuList.add(new CPU(interval));
            cpuList.get(x).setCpuProcessList(generator.generateSequence(cpuList.get(x), numberOfProcesses, maxLoad, maxDuration));
        }

        System.out.println("Strategy number one");
        AlgorithmInterface firstStrategy = new FirstStrategy(cpuList, cpuLoadBound, numberOfProcessors/2);
        firstStrategy.simulate();
        utils.reloadList(cpuList);
        System.out.println();
        System.out.println("Strategy number two");
        AlgorithmInterface secondStrategy = new SecondStrategy(cpuList, cpuLoadBound);
        secondStrategy.simulate();
        utils.reloadList(cpuList);
        System.out.println();
        System.out.println("Strategy number three");
        AlgorithmInterface thirdStrategy =  new ThirdStrategy(cpuList, cpuLoadBound);
        thirdStrategy.simulate();


    }

}
