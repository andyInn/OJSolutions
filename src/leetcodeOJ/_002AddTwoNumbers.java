package leetcodeOJ;
//002
public class _002AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		boolean plusOne = false;
		int sum = 0, len1 = 0, len2 = 0;
		ListNode p1 = l1, p2 = l2, temp, longerliNode;
		while (true) {
			if(p1 != null){
				p1 = p1.next;
				len1++;
			}
			if(p2 != null) {
				p2 = p2.next;
				len2++;
			}
			if(p1 == null&&p2 == null) break;
		}

		p1 = l1; p2 = l2;
		longerliNode = len1 > len2 ? l1 : l2;
		temp = longerliNode;
		while (p1 != null && p2 != null) {
			sum = p1.val + p2.val;
			if (plusOne) {
				sum++;
				if (sum < 10)
					plusOne = false;
				longerliNode.val = sum % 10;
			} else {
				if (sum > 9)
					plusOne = true;
				longerliNode.val = sum % 10;
			}
			p1 = p1.next;
			p2 = p2.next;
			temp = longerliNode;
			longerliNode = longerliNode.next;
		}
		while (plusOne && longerliNode != null) {
			sum = longerliNode.val;
			sum++;
			if (sum < 10)
				plusOne = false;
			longerliNode.val = sum % 10;
			temp = longerliNode;
			longerliNode = longerliNode.next;
		}
		if (plusOne && longerliNode == null) {
			temp.next = new ListNode(1);
			temp.next.next = null;
		}
		/*// reverse again
		longerliNode = len1 > len2 ? l1 : l2;
		ListNode p = longerliNode;
		longerliNode = null;
		while (p != null) {
			temp = p;
			p = p.next;
			temp.next = longerliNode;
			longerliNode = temp;
			len2++;
		}
		================
		l2 = null;
		while (p2 != null) {
			temp = p2;
			p2 = p2.next;
			temp.next = l2;
			l2 = temp;
			len2++;
		}*/
		return len1 > len2 ? l1 : l2;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode _addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode cur = ret;

        int sum = 0;
        while (true) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.val = sum % 10;
            sum /= 10;
            if (l1 != null || l2 != null || sum != 0) {
                cur = (cur.next = new ListNode(0));
            } else {
                break;
            }
        }
        return ret;
    }

	public static void main(String[] args) {
		_002AddTwoNumbers sl = new _002AddTwoNumbers();
		ListNode l1 = new ListNode(1);
		ListNode l11 = new ListNode(8);
//		ListNode l12 = new ListNode(3);
		ListNode l2 = new ListNode(5);
//		ListNode l21 = new ListNode(6);
//		ListNode l22 = new ListNode(6);
//		ListNode l23 = new ListNode(9);
		l1.next = l11;
//		l11.next = l12;
//		l2.next = l21;
//		l21.next = l22;
//		l22.next = l23;
		ListNode res = sl.addTwoNumbers(l1, l2);
		while (res != null) {
			System.out.println(res.val + "->");
			res = res.next;
		}
	}
}