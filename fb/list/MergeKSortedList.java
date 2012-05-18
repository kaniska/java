package fb.list;

import fb.ListNode;

import java.util.*;

/**
 * @author mindpower
 * @since 3/23/12 6:56 PM
 */
public interface MergeKSortedList {
  public ListNode mergeKLists(ArrayList<ListNode> lists);
}

/**
 * O(n*logk) algorithm, n is total number of nodes from all lists
 * http://code.google.com/p/sureinterview/source/browse/src/solution/sort/MergeNSorted.java#102
 * http://yewenxing.wordpress.com/2012/02/21/merge-k-sorted-lists/
 */
class MergeKSortedList_MinHeap implements  MergeKSortedList {
  public ListNode mergeKLists(ArrayList<ListNode> lists) {
    if (lists==null || lists.size()==0) return null;
    ListNode head = null, pre=null;
    PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(), new ListNodeComparator());
    for (int i=0;i<lists.size();i++) { // k lists
      if (lists.get(i)!=null) q.add(lists.get(i));
    }
    while (!q.isEmpty()) {
      ListNode l = q.poll();
      if (head==null) head = l;
      else pre.next = l;
      pre = l;
      if (l.next!=null) q.add(l.next);
    }
    return head;
  }
}

class ListNodeComparator implements Comparator<ListNode> {
  public int compare(ListNode l1, ListNode l2) {
    return l1.val-l2.val;
  }
}

/**
 * http://stackoverflow.com/questions/2705366/merging-k-sorted-linked-lists-analysis
 * N1, N2, N3... stand for LIST1, LIST2, LIST3 sizes

 O(N1 + N2) + O(N3 + N4) + O(N5 + N6) + ...
 O(N1 + N2 + N3 + N4) + O(N5 + N6 + N7 + N8) + ...
 O(N1 + N2 + N3 + N4 + .... + NK)
 It looks obvious that there will be log(K) of these rows, each of them implementing O(N) operations,
 so time for MERGE(LIST1, LIST2, ... , LISTK) operation would actually equal O(N log K).
 */
class MergeKSortedList_Divide_And_Conquer implements  MergeKSortedList {
  public ListNode mergeKLists(ArrayList<ListNode> lists) {
    return null;
  }
}
/**
 * O(n*k) since for each of n nodes we need to compare with all k lists
 */
class MergeKSortedList_Iterative implements MergeKSortedList {
  public ListNode mergeKLists(ArrayList<ListNode> lists) {
    ListNode head = null, pre = null;
    while (true) {
      int k = -1;
      int min = Integer.MAX_VALUE;
      for (int i = 0; i < lists.size(); i++) {
        if (lists.get(i) != null && lists.get(i).val <= min) {
          min = lists.get(i).val;
          k = i;
        }
      }
      if (k == -1) {
        break;
      }
      if (head == null) { // head = null as well
        head = lists.get(k);
      }
      else {
        pre.next = lists.get(k);
      }
      pre = lists.get(k);
      lists.set(k, lists.get(k).next);
    }
    return head;
  }


}
