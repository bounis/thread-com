public class Main {

    public static void main(String[] args) {
        ListNode three = new ListNode(3, null);
        ListNode four = new ListNode(4, three);
        ListNode two = new ListNode(2, four);

        ListNode secondFour = new ListNode(4, null);
        ListNode six = new ListNode(6, secondFour);
        ListNode five = new ListNode(5, six);
        add(two, five);
    }

    private static ListNode add(ListNode two, ListNode five) {

        StringBuilder firstNumber = new StringBuilder();
        StringBuilder secondNumber = new StringBuilder();
        ListNode node= two;
        while (node != null) {
            firstNumber.append(String.valueOf(node.val));
            node = node.next;
        }

        node = five;
        while (node != null) {
            secondNumber.append(String.valueOf(node.val));
            node = node.next;
        }

        System.out.println(firstNumber);
        System.out.println(secondNumber);

        return null;
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

     public ListNode(int val, ListNode next) {
         this.val = val;
         this.next = next;
     }
 }
