public class TreeMain {
	public static void main(String[] args) {
		TreeNode t = new IntTreeNode();
		//System.out.println(t.Height());
		t.Add(6);
		System.out.println(t.value);
		t.Add(9);
		System.out.println(t.value);
	}
}
