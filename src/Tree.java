public class Tree {
	public Tree left, right;
	public int count, n;
	private boolean reset = false;

	public Tree(int in){
		count = 1;
		n = in;
		left = null;
		right = null;
	}

	public void add(int in){
		if (reset){
			count = 1;
			n = in;
			left = null;
			right = null;
		} else if (in == n){
			count = count + 1;
		} else if (in < n){
			if (left == null){
				left = new Tree(in);
			} else {
				left.add(in);
			}
		} else {
			if (right == null){
				right = new Tree(in);
			} else {
				right.add(in);
			}
		}
	}

	public void print(){
		if (left != null){
			left.print();
		}

		for (int i = 0; i < count; i = i + 1){
			System.out.printf("%d ", n);
		}

		if (right != null){
			right.print();
		}
	}

	public int takeOut(){
		if (count == 0){
			reset = true;
			return 0;
		}

		if (left != null){
			if (left.count != 0){
				return left.takeOut();
			}
		}

		if (count > 1){
			count = count - 1;
			return n;
		}

		if (right != null) {
			if (right.count != 0){
				int tmp = n;

				n = right.n;
				count = right.count;
				left = right.left;
				right = right.right;

				return tmp;
			}
		}

		count = count - 1;
		return n;
	}
}
