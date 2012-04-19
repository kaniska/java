package facebook.prob;

import java.util.Random;

/**
 *  http://www.mitbbs.com/article/JobHunting/32055195_0.html
 * prob的那题：

借助于prob，可以如此进行算法：
设第k次调用prob前，目标区间是[a,b]；k=1,2,…。k=1时a=0,b=1。对于这一次调用，
假想prob的工作方式是：随机一个[a,b]上的均匀分布数，如果这个数小于等于(a+b)/2
，则返回true；否则返回false。设x=a+p*(b-a)，prob2的工作方式可假想为：随机一
个[a,b]上的均匀分布数，如果这个数小于等于x，则返回true；否则返回false。于是
可按两种情况处理：
(1)    x <= (a+b)/2
如果调用prob返回true，表明prob产生的随机数在[a,(a+b)/2]之间，但无法确定这个
随机数是否在[a,x]之间；此时令a’=a, b’=(a+b)/2，继续在[a’,b’]上重复上面的
过程(第k+1次)。
如果调用prob返回false，表明prob产生的随机数在((a+b)/2,b]之间，必不可能在[a,x
]之间，此时prob2可以返回false。
(2)    x > (a+b)/2
如果调用prob返回true，表明prob产生的随机数在[a,(a+b)/2]之间，此时这个随机数
肯定在[a,x]之间，prob2返回true。
如果调用prob返回false，表明prob产生的随机数在((a+b)/2,b]之间，但无法确定这个
随机数是否在[a,x]之间；此时令a’=(a+b)/2，b’=b，继续在[a’,b’]上重复上面的
过程(第k+1次)。
算法很快，是指数收敛的。
 *
 * @author jbu
 */
public class ProbAny_Junjie extends ProbAny{

  public boolean prob(double x) {
    if (x>=1) return true;
    if (x<=0) return false;
    double eps=0.000000001;
    double a =0, b=1;
    do {
      boolean pb = prob();
      double center = (a+b)/2;
      if (Math.abs(x-center)<eps) return pb;
      if (x>center && pb) return true;
      if (x<center && !pb) return false;
      if (x>center) a =center;
      else b=center;
//      x = (x>0.5? (x-0.5):x)*2;
      eps*=2;
      exp_value++;
    } while (true);
  }

}