package zhang.algorithm.JavaTest;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/8/29
 * Time: 下午8:43
 * To change this template use File | Settings | File Templates.
 */
public class ZhangTest {

    private String name;
    private int population;
    public ZhangTest(String name, int population)
    {
        this.name = name;
        this.population = population;
    }
    public String getName()
    {
        return this.name;
    }

    public int getPopulation()
    {
        return this.population;
    }
    public String toString()
    {
        return getName() + " - " + getPopulation();
    }
    public static void main(String args[])
    {
        Comparator<ZhangTest> OrderIsdn =  new Comparator<ZhangTest>(){
            public int compare(ZhangTest o1, ZhangTest o2) {
                // TODO Auto-generated method stub
                int numbera = o1.getPopulation();
                int numberb = o2.getPopulation();
                if(numberb > numbera)
                {
                    return 1;
                }
                else if(numberb<numbera)
                {
                    return -1;
                }
                else
                {
                    return 0;
                }

            }



        };
        Queue<ZhangTest> priorityQueue =  new PriorityQueue<ZhangTest>(11,OrderIsdn);

        ZhangTest t1 = new ZhangTest("t1",1);
        ZhangTest t3 = new ZhangTest("t3",3);
        ZhangTest t2 = new ZhangTest("t2",2);
        ZhangTest t4 = new ZhangTest("t4",0);
        priorityQueue.add(t1);
        priorityQueue.add(t3);
        priorityQueue.add(t2);
        priorityQueue.add(t4);
        System.out.println(priorityQueue.poll().toString());
    }
}
