//package Interview.Collection;
//
///**
// * @description:
// * @author: Desmand
// * @time: 2020/10/30 8:02 下午
// */
//
//public class CyclicBarrier {
//    int parties;
//    int count;
//    Runnable barrierCommand;
//    public CyclicBarrier(int parties) {
//        this(parties, null);
//    }
//    public CyclicBarrier(int parties, Runnable barrierAction) {
//        if (parties <= 0) throw new IllegalArgumentException();
//        this.parties = parties;
//        this.count = parties;
//        this.barrierCommand = barrierAction;
//    }
//
//}
