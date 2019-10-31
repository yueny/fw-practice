package com.yueny.fw.practice.threadlocal;

/**
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-10-25 15:10
 */
public class MDCMain {
    private static MDCAdapter mdcAdapter;
    static {
        mdcAdapter = new NormalMDCAdapter();
    }

    /**
     * 输出结果
     * <pre>
     * 1/aaa
     * 1/aaa
     * 12/aaa0
     * 1/aaa
     * 13/aaa1
     * 14/aaa2
     * 1/aaa
     * 15/aaa3
     * 1/aaa
     * 16/aaa4
     * 18/aaa4c
     * 19/aaa1c
     * 20/aaa2c
     * 21/aaa3c
     * 17/aaa0c
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
        // 主线程
        mdcAdapter.put("aaa");

        for (int i = 0; i < 5; i++) {
            final int step = i;
            System.out.println(Thread.currentThread().getId() + "/" + mdcAdapter.get());

            // 子线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String parentVal = mdcAdapter.get();
                    mdcAdapter.put(parentVal + step);

                    System.out.println(Thread.currentThread().getId() + "/" + mdcAdapter.get());

                    // 孙线程
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            String parentCVal = mdcAdapter.get();
                            mdcAdapter.put(parentCVal + "c");

                            System.out.println(Thread.currentThread().getId() + "/" + mdcAdapter.get());
                        }
                    }).start();
                }
            }).start();
        }
    }

}
