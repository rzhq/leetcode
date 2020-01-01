class Connector {
    public static ListNode connect(Integer[] in) {
        if ( in == null || in.length < 1 ) return null;
        ListNode root = new ListNode(in[0]);
        ListNode node = root;
        for ( int i = 1; i < in.length; i++ ) {
            node.next = new ListNode(in[i]);
            node = node.next;
        }
        return root;
    }
    
    public static void print(ListNode node) {
        while ( node != null ) {
            System.out.printf("%d ", node.val);
            node = node.next;
        }
        System.out.println();
    }
}
