package fb.prob;

/**
 * http://www.mitbbs.com/article_t/JobHunting/32163609.html
 * <p/>
 * 发信人: laoen (simon), 信区: JobHunting
 * 标  题: 狗 onsite 最后死在烙印上！
 * 发信站: BBS 未名空间站 (Fri Jun 29 16:22:09 2012, 美东)
 * <p/>
 * 烙印面试居然问我Markov chain 之类的coding 解法，我当场傻掉。
 * given a list of words ["apple",  "apce", appe"]
 * 写个函数之类的， 可以产生一些rules:
 * like:
 * 1. first letter is 'a' 100%
 * 2. last letter is 'e' 100%
 * 3. p followed by l  33%
 * 3. p followed by c  33%
 * ......
 * <p/>
 * 他想要Markov chain ,概率方面的方向去做。我都说我不是ml 方向的，要画一个state
 * machine 之类的东东。  请问有人知道怎么做吗？ 这些rules 是自动生成的based on
 * your input strings.
 * <p/>
 * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 * 发信人: sentence (alex), 信区: JobHunting
 * 标  题: Re: 狗 onsite 最后死在烙印上！
 * 发信站: BBS 未名空间站 (Fri Jun 29 18:47:13 2012, 美东)
 * <p/>
 * HMM需要动态规划，现场写也没有那么难，不过你的确得对整个过程非常清晰。我过去
 * 面试时候现场写过，感觉还可以，不过是因为我是做nlp的，写过太多遍了。。
 * 但是你这个不是，你的就是简单的language model. 所有的规则都是bigram，最大似然
 * 估计。
 * 第一个规则就是条件概率，前一个字符是START，后一个是'a'的概率
 * P(c_current ='a' | c_previous = START) = #(START a)/#(START)
 * #代表数字，(START a)代表一个sequence
 * 后面的规则按照此办理就可以了。所以这个问题就是问你，如何统计一个文章中所有字
 * 符出现的次数和所有二字符序列出现的顺序。
 * 可能他解释得不好，否则这个问题根本就是放水啊。。。。我要是面试时候能问我这么
 * 简单的问题就好了。。。
 * <p/>
 * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 * 发信人: tk45 (tk45s`), 信区: JobHunting
 * 标  题: Re: 狗 onsite 最后死在烙印上！
 * 发信站: BBS 未名空间站 (Fri Jun 29 20:48:12 2012, 美东)
 * <p/>
 * 做一个28X28矩阵M。26字符加头尾。M(x,y)是x后面跟y的概率。每一行概率和为1。所
 * 以“Markov"。不过不用管这个名字啦。
 * <p/>
 * 所以问题就是怎么走一边list，把这个矩阵做出来。
 * <p/>
 * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 * 发信人: roseyyan (小小), 信区: JobHunting
 * 标  题: Re: 狗 onsite 最后死在烙印上！
 * 发信站: BBS 未名空间站 (Sat Jun 30 01:05:19 2012, 美东)
 * <p/>
 * 这个题就是典型的马额科夫连。 tk45说的很对。28*28是因为头尾要加两个状态。然后
 * 就扫描字符，每扫描过一个，在相应cell 加1。 比如 ”but “  要在 开始－> b 的
 * cell加1, b－> u的 cell 加1， 。。。t －> 中止 cell 加1 。最后把每列normalize
 * 一下就行了。 不用HHM，动态规划什么，哪有那么复杂。 复杂度是O（n）。  n是字符
 * 数。
 * <p/>
 * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 * 发信人: tk45 (tk45s`), 信区: JobHunting
 * 标  题: Re: 狗 onsite 最后死在烙印上！
 * 发信站: BBS 未名空间站 (Sat Jun 30 01:08:34 2012, 美东)
 * <p/>
 * 这个倒也是。如果要问“x后面任何字符再跟y“之类的就是动态规划了。也可以直接用
 * 矩阵算啦，Markov过程。还记得条件概率的话想想M＊M[x,y]是啥，也就想出来了。
 * <p/>
 * 记得G有个面试题，很早了，怎么算组合数n取m，必须用动态规划。呵呵，没有那个规
 * 定咱直接给他公式了。
 *
 * @author mindpower
 * @since 6/30/12
 */
public class Markov {

  public static void generateRules(String[] words) {
    int p[][] = new int[28][28];
    for (String s : words) {
      for (int i = 0; i <= s.length(); i++) {
        if (i == 0) p[0][s.charAt(i) - 'a' + 1]++;
        else if (i == s.length()) p[s.charAt(i - 1) - 'a' + 1][27]++;
        else p[s.charAt(i - 1) - 'a' + 1][s.charAt(i) - 'a' + 1]++;
      }
    }
    // P(c_current ='a' | c_previous = START) = #(START a)/#(START)
    for (int j = 0; j < p[0].length; j++) {
      if (j == 0) System.out.print("       S");
      else if (j == p[0].length - 1) System.out.println("   E");
      else System.out.print("   " + (char) (j + 'a' - 1));
    }
    for (int i = 0; i < p.length; i++) {
      int total = 0;
      for (int j = 0; j < p[0].length; j++) {
        total += p[i][j];
      }
      if (i == 0) System.out.print("   S");
      else if (i == p[0].length - 1) System.out.print("   E");
      else System.out.print("   " + (char) (i + 'a' - 1));
      for (int j = 0; j < p[0].length; j++) {
        double r = total == 0 ? 0 : p[i][j] * 100 / total;
        System.out.printf(" %3.0f", r);
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    generateRules(new String[]{"apple", "apce", "appe"});
  }
}
