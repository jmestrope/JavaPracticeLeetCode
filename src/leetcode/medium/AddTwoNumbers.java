package leetcode.medium;

public class AddTwoNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0); // result holder
		ListNode pointer = result; // pointer

		int carry = 0;

		while (l1 != null || l2 != null) { //run while either is still has next value

			int sum = carry;

			if (l1 != null) {
				sum = l1.val + sum;
				l1 = l1.next;
			}

			if (l2 != null) {
				sum = l2.val + sum;
				l2 = l2.next;
			}
			
			carry = sum / 10; // get the carry
			sum = sum % 10; // get the remainder of carry
			pointer.next = new ListNode(sum); // add to list
			pointer = pointer.next; //move to next pointer
		}
		
		if(carry == 1) {
			pointer.next = new ListNode(1);
		}

		return result.next; // use next to exclude 0 

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);

		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(9);

		ListNode actual = addTwoNumbers(l1, l2);
		
		while (actual != null) {
			System.out.print(actual.val);
			actual = actual.next;
		}
		
		System.out.println();
		
		ListNode l3 = new ListNode(2);
	    l3.next = new ListNode(4);
	    l3.next.next = new ListNode(3);

	    ListNode l4 = new ListNode(5);
	    l4.next = new ListNode(6);
	    l4.next.next = new ListNode(4);


	    ListNode actual2 = addTwoNumbers(l3, l4);

		while (actual2 != null) {
			System.out.print(actual2.val);
			actual2 = actual2.next;
		}
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}