package cn.edu.xidian.sselab;
/**
 * title:Same Tree
 * content:
 *  Given two binary trees, write a function to check if they are equal or not.
 *  Two binary trees are considered equal if they are structurally identical and the nodes have the same value. 
 */
public class SameTree {

	/**
	 * @author wzy
	 * @param args
	 * @see �ж��������Ƿ���ͬ������Ҫ���ṹ��ͬʱҲҪ��ÿ���ڵ��Ӧ��ֵ
	 * �����뵽���Ƕ����ֱ���б����������뵽�˵ݹ�
	 * �������õ��Ǻ�������ķ�ʽ��ͬʱ������Ҷ�ӽڵ�֮��Ҫ�����������
	 * ��1�������Ӧ�Ľڵ㶼��null���򷵻�true
	 * ��2���������һ���ڵ�Ϊnull������һ���ڵ㲻Ϊnull���򷵻�false
	 * ��3����������ڵ㶼��Ϊnull��������ֵ����� ������false
	 * ��4����������ڵ㶼��Ϊnull��������ֵ��ȣ�����еݹ����
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			this.val = x;
		}
	}
	public boolean isSameTree(TreeNode p, TreeNode q){
		boolean flag1 = false;
		boolean flag2 = false;		
		if(p == null && q == null ){
			return true;
		}else if((p == null || q == null)){
			return false;
		}else if(p.val != q.val){
			return false;			
		}else{
			flag1 = isSameTree(p.left,q.left);
			flag2 = isSameTree(p.right,q.right);
		}
		return (flag1 && flag2);
	}
		
}
